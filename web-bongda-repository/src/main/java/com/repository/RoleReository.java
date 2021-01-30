package com.repository;

import com.persisterce.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleReository  extends JpaRepository<RoleEntity,Long> {
    RoleEntity findOneByCode(String colde);

}
