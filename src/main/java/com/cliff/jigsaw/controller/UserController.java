package com.cliff.jigsaw.controller;

import com.cliff.jigsaw.model.User;
import com.cliff.jigsaw.model.vo.CreateUserVo;
import com.cliff.jigsaw.model.vo.UpdateUserVo;
import com.cliff.jigsaw.model.vo.UserVo;
import com.cliff.jigsaw.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

}
