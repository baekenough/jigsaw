package com.cliff.jigsaw.controller;

import com.cliff.jigsaw.common.upload.ResponseForm;
import com.cliff.jigsaw.model.user.User;
import com.cliff.jigsaw.model.user.vo.CreateUserVo;
import com.cliff.jigsaw.model.user.vo.UpdateUserVo;
import com.cliff.jigsaw.model.user.vo.UserProfileVo;
import com.cliff.jigsaw.model.user.vo.UserVo;
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
    public User getUser(@RequestBody UserVo vo) {
        return userService.findUser(vo.getEmail());
    }

    @PutMapping("{userNid}")
    public Optional<User> updateUser(@PathVariable Long userNid, @RequestBody UpdateUserVo vo) {
        return userService.updateUser(userNid, vo);
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
    @GetMapping("/profile")
    public UserProfileVo getProfile(@RequestParam("userNid") Long userNid) {
        return userService.getProfile(userNid);
    }

    @ResponseBody
    @PostMapping("/profile")
    public ResponseForm uploadProfile(
            @RequestParam("file")MultipartFile file,
            @RequestParam("userNid") Long userNid) {
        try {
            return userService.uploadFile(userNid, file);
        } catch (IOException e) {
            return null;
        }
    }
}
