package com.cliff.jigsaw.service.impl;

import com.cliff.jigsaw.common.exception.exception.CustomErrorCode;
import com.cliff.jigsaw.common.exception.exception.CustomException;
import com.cliff.jigsaw.model.profile.ProfileComment;
import com.cliff.jigsaw.model.profile.vo.comment.CreateProfileCommentVo;
import com.cliff.jigsaw.model.profile.vo.comment.UpdateProfileCommentVo;
import com.cliff.jigsaw.repository.ProfileCommentRepository;
import com.cliff.jigsaw.repository.UserProfileRepository;
import com.cliff.jigsaw.service.ProfileService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileCommentRepository profileCommentRepository;
    private final UserProfileRepository userProfileRepository;

    @Override
    public List<ProfileComment> findProfileCommentList(Long profileNid) {
        return profileCommentRepository.findProfileCommnetListByProfileNid(profileNid);
    }

    @Override
    public ProfileComment createProfileComment(Long ProfileNid, CreateProfileCommentVo commentVo) {
        ProfileComment comment = new ProfileComment();
        comment.setProfileNid(ProfileNid);
        comment.setUserProfileNid(userProfileRepository.findById(commentVo.getUserProfileNid()).orElseThrow(
                () -> new CustomException(CustomErrorCode.USER_NOT_FOUND_ERROR)
        ));
        comment.setContent(commentVo.getContent());
        return profileCommentRepository.saveAndFlush(comment);
    }

    @Override
    public ProfileComment updateProfileComment(Long profileCommentNid, UpdateProfileCommentVo vo) {
        profileCommentRepository.findById(profileCommentNid)
                .map(comment -> {
                    comment.setContent(vo.getContent());
                    return profileCommentRepository.saveAndFlush(comment);
                }).orElseThrow(() -> new CustomException(CustomErrorCode.COMMENT_NOT_FOUND_ERROR));
        return profileCommentRepository.findById(profileCommentNid).orElseThrow(
                () -> new CustomException(CustomErrorCode.COMMENT_NOT_FOUND_ERROR)
        );
    }

    @Override
    public String deleteProfileComment(Long profileCommentNid) {
        if (profileCommentRepository.findById(profileCommentNid).isPresent()) {
            profileCommentRepository.deleteById(profileCommentNid);
            return "코멘트를 삭제하였습니다.";
        }
        else {
            return "코멘트를 찾을 수 없습니다.";
        }
    }
}
