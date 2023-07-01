package com.cliff.jigsaw.model.profile.vo.profile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetUserProfileVo {

    Long userNid;
    Long userProfileNid;
    String profileImage;
    String name;
    String nickName;
    String job;
    String skill;
    String introduce;
    String projectField;
    String projectType;


}
