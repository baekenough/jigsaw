package com.cliff.jigsaw.service.impl;

import com.cliff.jigsaw.common.exception.exception.CustomErrorCode;
import com.cliff.jigsaw.common.exception.exception.CustomException;
import com.cliff.jigsaw.common.upload.ResponseForm;
import com.cliff.jigsaw.model.user.User;
import com.cliff.jigsaw.model.user.UserProfile;
import com.cliff.jigsaw.model.user.vo.CreateUserVo;
import com.cliff.jigsaw.model.user.vo.UpdateUserVo;
import com.cliff.jigsaw.model.user.vo.UserProfileVo;
import com.cliff.jigsaw.repository.UserProfileRepository;
import com.cliff.jigsaw.repository.UserRepository;
import com.cliff.jigsaw.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;

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

    public UserProfileVo getProfile(Long userNid) {
        UserProfile profile =  userProfileRepository.findByUserNid(userNid).orElseThrow(
                () -> new CustomException(CustomErrorCode.USER_NOT_FOUND_ERROR)
        );
        UserProfileVo vo = new UserProfileVo();
        vo.setUserProfileNid(profile.getUserProfileNid());
        vo.setUserNid(profile.getUserNid());
        vo.setFile(profile.getFile());
        return vo;
    }

    // 프로필 올리기
    // 파일 경로
    @Value("${file.upload-dir}")
    private String uploadDir;

    // 이미지 파일은 최대 5MB
    private static final long MAX_IMAGE_SIZE = 5242880;

    public ResponseForm uploadFile(Long userNid, MultipartFile file) throws IOException {
        ResponseForm responseForm = new ResponseForm();

        // 파일이 없거나 빈파일이면 레파지토리에서 userNid 기준으로 탐색
        if (file.isEmpty() || "".equals(file.getName())) {
            System.out.println("NO FILE");
            UserProfile userProfile = userProfileRepository.findByUserNid(userNid).orElseThrow(
                    () -> new CustomException(CustomErrorCode.FILE_SIZE_IS_TOO_BIG)
            );

            // 파일이 없고 기본 파일이 아니면 파일 삭제 후 기본 파일로 저장
            if (userProfile != null && !userProfile.getFile().equals("default.jpg"))
                new File(uploadDir + "/" + userProfile.getFile()).delete();
            userProfile.setFile("default.jpg");
            userProfileRepository.save(userProfile);
            return responseForm.setSuccess(null);
        }

        // 이미지 크기 제한 체크
        if (file.getSize() > MAX_IMAGE_SIZE) {
            throw new RuntimeException("이미지 크기가 너무 큽니다.");
        }

        // 이미지 저장
        String fileName = writeFile(file, userNid);
        UserProfile userProfile = userProfileRepository.findByUserNid(userNid).orElse(null);

        // 파일이 없고 기본 파일이 아니면 저장
        if (userProfile != null && !userProfile.getFile().equals("default.jpg"))
            new File(uploadDir + "/" + userProfile.getFile()).delete();

        userProfile.setFile(fileName);
        userProfileRepository.save(userProfile);

        return responseForm.setSuccess("upload success");
    }

    private String writeFile(MultipartFile file, Long userNid) throws IOException {
        String extension = com.google.common.io.Files.getFileExtension(file.getOriginalFilename());
        String fileName = UUID.randomUUID().toString() + "." + extension;
        byte[] fileContent = file.getBytes();

        String filePath = uploadDir + "/" + fileName;

        Path path = Paths.get(filePath);
        Files.write(path, fileContent);
        return fileName;
    }

}
