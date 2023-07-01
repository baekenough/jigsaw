package com.cliff.jigsaw.service;

import com.cliff.jigsaw.common.upload.ResponseForm;
import com.cliff.jigsaw.model.user.User;
import com.cliff.jigsaw.model.profile.UserProfile;
import com.cliff.jigsaw.model.user.vo.CreateUserVo;
import com.cliff.jigsaw.model.user.vo.UpdateUserVo;
import com.cliff.jigsaw.model.profile.vo.profile.CreateUserProfileVo;
import com.cliff.jigsaw.model.profile.vo.profile.GetUserProfileVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface UserService {

    User findUser(String email);
    Optional<User> updateUser(Long userNid, UpdateUserVo vo);
    User createUser(CreateUserVo vo);
    UserProfile createUserProfile(CreateUserProfileVo vo);

    GetUserProfileVo getProfile(Long userNid);
    ResponseForm uploadFile(Long userNid, MultipartFile file) throws IOException;

    void updateUserProfileNid(Long userProfileNid, Long userNid) throws Exception;

}
