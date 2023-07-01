package com.cliff.jigsaw.controller;

import com.cliff.jigsaw.model.profile.ProfileComment;
import com.cliff.jigsaw.model.profile.vo.comment.CreateProfileCommentVo;
import com.cliff.jigsaw.model.profile.vo.comment.UpdateProfileCommentVo;
import com.cliff.jigsaw.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/{profileNid}")
    public List<ProfileComment> getProfileCommentList(@PathVariable Long profileNid) {
        return profileService.findProfileCommentList(profileNid);
    }

    @PostMapping("/{profileNid}")
    public ProfileComment createProfileComment(@PathVariable Long profileNid, @RequestBody CreateProfileCommentVo vo) {
        return profileService.createProfileComment(profileNid, vo);
    }

    @PutMapping("/comment/{profileCommentNid}")
    public ProfileComment updateProfileComment(@PathVariable Long profileCommentNid, @RequestBody UpdateProfileCommentVo vo) {
        return profileService.updateProfileComment(profileCommentNid, vo);
    }

    @DeleteMapping("/comment/{profileCommentNid}")
    public String deleteProfileComment(@PathVariable Long profileCommentNid) {
        return profileService.deleteProfileComment(profileCommentNid);
    }


}
