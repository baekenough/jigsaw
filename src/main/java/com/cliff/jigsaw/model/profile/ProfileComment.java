package com.cliff.jigsaw.model.profile;

import com.cliff.jigsaw.model.profile.vo.comment.CreateProfileCommentVo;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@DynamicInsert
public class ProfileComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileCommentNid;
    private Long profileNid;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_profile_nid")
    private UserProfile userProfileNid;
    private String content;
    private LocalDateTime createDtm;
    private LocalDateTime updateDtm;

    @Builder
    ProfileComment(UserProfile profile, CreateProfileCommentVo vo) {
        this.userProfileNid = profile;
        this.content = vo.getContent();
    }

}
