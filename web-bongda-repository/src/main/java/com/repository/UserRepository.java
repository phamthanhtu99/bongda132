package com.repository;

import com.persisterce.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;




public interface UserRepository extends JpaRepository<UserEntity,Long> {
        UserEntity findAllByUsernameAndStatus(String name,int status);
        UserEntity findOneByUsername(String username);
}
