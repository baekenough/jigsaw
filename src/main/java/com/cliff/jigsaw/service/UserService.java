package com.cliff.jigsaw.service;

import com.cliff.jigsaw.model.User;
import com.cliff.jigsaw.model.vo.CreateUserVo;
import com.cliff.jigsaw.model.vo.UpdateUserVo;

import java.util.Optional;

public interface UserService {

    User findUser(String email);
    Optional<User> updateUser(Long userNid, UpdateUserVo vo);
    User createUser(CreateUserVo vo);

}
