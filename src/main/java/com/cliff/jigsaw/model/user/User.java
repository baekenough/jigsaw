package com.cliff.jigsaw.model.user;

import com.cliff.jigsaw.model.user.vo.CreateUserVo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNid;
    private String email;
    private String phoneNumber;
    private String jobGroup;
    private String skill;
    private String field;
    private String type;

    @Builder
    public User(CreateUserVo vo) {
        this.email = vo.getEmail();
        this.phoneNumber = vo.getPhoneNumber();
        this.jobGroup = vo.getJobGroup();
        this.skill = vo.getSkill();
        this.field = vo.getField();
        this.type = vo.getType();
    }

}
