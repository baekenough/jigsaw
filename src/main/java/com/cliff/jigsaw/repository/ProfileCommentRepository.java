package com.cliff.jigsaw.repository;

import com.cliff.jigsaw.model.profile.ProfileComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileCommentRepository extends JpaRepository<ProfileComment, Long> {

    List<ProfileComment> findProfileCommentListByProfileNid(Long profileNid);

}
