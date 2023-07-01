package com.cliff.jigsaw.model.user;

import com.cliff.jigsaw.model.profile.UserProfile;
import com.cliff.jigsaw.model.user.vo.CreateUserVo;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_nid")
    private Long userNid;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_profile_nid")
    private UserProfile userProfile;
    private String email;
    private String phoneNumber;
    private String type;

    @Builder
    public User(CreateUserVo vo) {
        this.email = vo.getEmail();
        this.phoneNumber = vo.getPhoneNumber();
        this.type = vo.getType();
    }

}
