package com.cliff.jigsaw.model.user;

import com.cliff.jigsaw.model.user.vo.profile.CreateUserProfileVo;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userProfileNid;
    private Long userNid;
    private String profileImage;
    private String nickName;
    private String introduceOneLine;
    private String jobGroup;
    private String skill;

    @Builder
    public UserProfile(CreateUserProfileVo vo) {
        this.userNid = vo.getUserNid();
        this.profileImage = vo.getProfileImage();
        this.nickName = vo.getNickName();
        this.introduceOneLine = vo.getIntroduceOneLine();
        this.jobGroup = vo.getJobGroup();
        this.skill = vo.getSkill();
    }

}
