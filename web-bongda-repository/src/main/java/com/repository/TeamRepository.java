package com.repository;

import com.persisterce.TeamEntity;
import com.persisterce.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamRepository extends JpaRepository<TeamEntity,Long> {
    List<TeamEntity> findAllByStatus(int status, Pageable pageable);

}
