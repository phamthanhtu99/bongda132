package com.repository;

import com.persisterce.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Team_userReository extends JpaRepository<Team_UserEntity, team_userkey> {
        @Query("SELECT DISTINCT userEntity FROM Team_UserEntity  ")
        List<UserEntity> findNonReferencedNames();
        @Query("select t from Team_UserEntity t where t.userEntity = :user and t.status_team_user= :status")
        Team_UserEntity finduserandstatus(@Param("user") UserEntity user,@Param("status") Team_statusEntity status);
        List<Team_UserEntity> findAllByTeamEntity(TeamEntity teamEntity);

}
