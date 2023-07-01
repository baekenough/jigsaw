package com.cliff.jigsaw.service;


import com.cliff.jigsaw.model.profile.ProfileComment;
import com.cliff.jigsaw.model.profile.vo.comment.CreateProfileCommentVo;
import com.cliff.jigsaw.model.profile.vo.comment.UpdateProfileCommentVo;

import java.util.List;

public interface ProfileService {

    List<ProfileComment> findProfileCommentList(Long profileNid);

    ProfileComment createProfileComment(Long userProfileNid, CreateProfileCommentVo commentVo);

    ProfileComment updateProfileComment(Long profileCommentNid, UpdateProfileCommentVo vo);

    String deleteProfileComment(Long profileCommentNid);
}
