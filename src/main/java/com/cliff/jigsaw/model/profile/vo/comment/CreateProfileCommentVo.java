package com.cliff.jigsaw.model.profile.vo.comment;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateProfileCommentVo {

    Long userProfileNid;
    String content;

}
