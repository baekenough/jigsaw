package com.cliff.jigsaw.controller;

import com.cliff.jigsaw.common.upload.ResponseForm;
import com.cliff.jigsaw.model.user.User;
import com.cliff.jigsaw.model.profile.UserProfile;
import com.cliff.jigsaw.model.user.vo.CreateUserVo;
import com.cliff.jigsaw.model.user.vo.GetUserVo;
import com.cliff.jigsaw.model.user.vo.UpdateUserVo;
import com.cliff.jigsaw.model.profile.vo.profile.CreateUserProfileVo;
import com.cliff.jigsaw.model.profile.vo.profile.GetUserProfileVo;
import com.cliff.jigsaw.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public User getUser(@RequestBody GetUserVo vo) {
        return userService.findUser(vo.getEmail());
    }

    @PutMapping("{id}")
    public Optional<User> updateUser(@PathVariable Long id, @RequestBody UpdateUserVo vo) {
        return userService.updateUser(id, vo);
    }

    @PostMapping("")
    public User createUser(@RequestBody CreateUserVo vo) {
        return userService.createUser(vo);
    }


    //https://velog.io/@phraqe/Sekkison06-%EC%A4%91%EC%9A%94-%EB%A1%9C%EC%A7%81%EB%93%A4-2-feat.-%ED%8C%8C%EC%9D%BC-%EC%97%85%EB%A1%9C%EB%93%9C
    //profile image path
    @Value("${file.upload-dir}")
    private String uploadDir;

    //profile
    @GetMapping("/profile/{id}")
    public GetUserProfileVo getProfile(@PathVariable Long id) {
        return userService.getProfile(id);
    }

    @PostMapping("/profile")
    public UserProfile createProfile(@RequestBody CreateUserProfileVo vo) throws Exception {
        UserProfile profile = userService.createUserProfile(vo);
        userService.updateUserProfileNid(profile.getUserProfileNid(), profile.getId());
        return profile;
    }

    @ResponseBody
    @PostMapping("/profile/upload")
    public ResponseForm uploadProfile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("id") Long id) {
        try {
            return userService.uploadFile(id, file);
        } catch (IOException e) {
            return null;
        }
    }
}
