package com.cliff.jigsaw.model.user.vo.profile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUserProfileVo {

    Long userNid;
    String profileImage;
    String nickName;
    String introduceOneLine;
    String jobGroup;
    String skill;

}
