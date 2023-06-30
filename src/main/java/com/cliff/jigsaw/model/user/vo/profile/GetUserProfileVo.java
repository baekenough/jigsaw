package com.cliff.jigsaw.model.user.vo.profile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetUserProfileVo {

    Long userProfileNid;
    String profileImage;
    String nickName;
    String introduceOneLine;
    String jobGroup;
    String skill;

}
