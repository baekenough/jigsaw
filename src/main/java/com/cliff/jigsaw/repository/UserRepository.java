package com.cliff.jigsaw.repository;

import com.cliff.jigsaw.model.user.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
    @Query(value = "UPDATE cliff.user m set m.user_profile_nid =:user_profile_nid WHERE m.user_nid =:user_nid", nativeQuery = true)
    @Modifying
    @Transactional
    void updateUserProfileNid(@Param("user_profile_nid") Long userProfileNid, @Param("user_nid") Long userNid);
}
