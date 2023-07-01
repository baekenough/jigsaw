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
    private String name;
    private String nickName;
    private String job;
    private String skill;
    private String introduce;
    private String projectField;
    private String projectType;

    @Builder
    public UserProfile(CreateUserProfileVo vo) {
        this.userNid = vo.getUserNid();
        this.profileImage = vo.getProfileImage();
        this.name = vo.getName();
        this.nickName = vo.getNickName();
        this.job = vo.getJob();
        this.skill = vo.getSkill();
        this.introduce = vo.getIntroduce();
        this.projectField = vo.getProjectField();
        this.projectType = vo.getProjectType();
    }

}
