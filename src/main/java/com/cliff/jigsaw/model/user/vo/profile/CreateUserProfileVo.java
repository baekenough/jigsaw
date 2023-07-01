package com.cliff.jigsaw.model.user.vo.profile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUserProfileVo {

    Long userNid;
    String profileImage;
    String name;
    String nickName;
    String job;
    String skill;
    String introduce;
    String projectField;
    String projectType;

}
