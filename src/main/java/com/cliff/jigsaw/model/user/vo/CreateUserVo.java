package com.cliff.jigsaw.model.user.vo;

import lombok.Data;

@Data
public class CreateUserVo {
    String email;
    String phoneNumber;
    String jobGroup;
    String skill;
    String field;
    String type;
}
