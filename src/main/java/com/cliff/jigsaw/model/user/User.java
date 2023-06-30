package com.cliff.jigsaw.model.user;

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
    private Long userNid;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_profile_nid")
    private UserProfile userProfile;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_favorite_nid")
    private UserFavorite userFavorite;
    private String email;
    private String phoneNumber;

    @Builder
    public User(CreateUserVo vo) {
        this.email = vo.getEmail();
        this.phoneNumber = vo.getPhoneNumber();
    }

}
