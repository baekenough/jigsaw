package com.cliff.jigsaw.service.impl;

import com.cliff.jigsaw.common.exception.exception.CustomErrorCode;
import com.cliff.jigsaw.common.exception.exception.CustomException;
import com.cliff.jigsaw.model.User;
import com.cliff.jigsaw.model.vo.CreateUserVo;
import com.cliff.jigsaw.model.vo.UpdateUserVo;
import com.cliff.jigsaw.repository.UserRepository;
import com.cliff.jigsaw.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public User findUser(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(
                () -> new CustomException(CustomErrorCode.USER_NOT_FOUND_ERROR)
        );
    }

    @Override
    public Optional<User> updateUser(Long userNid, UpdateUserVo vo) {
        userRepository.findById(userNid)
                .map(user -> {
                    user.setPhoneNumber(vo.getPhoneNumber());
                    user.setJobGroup(vo.getJobGroup());
                    user.setSkill(vo.getSkill());
                    user.setField(vo.getField());
                    user.setType(vo.getType());
                    return userRepository.saveAndFlush(user);
                })
                .orElseThrow(
                        () -> new CustomException(CustomErrorCode.USER_NOT_FOUND_ERROR)
                );
        return userRepository.findById(userNid);
    }

    @Override
    public User createUser(CreateUserVo vo) {
        User user = new User(vo);
        userRepository.saveAndFlush(user);
        return user;
    }

}
