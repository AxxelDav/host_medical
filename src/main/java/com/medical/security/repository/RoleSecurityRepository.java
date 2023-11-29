package com.medical.security.repository;

import com.medical.security.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleSecurityRepository extends JpaRepository<RoleEntity, Long> {
}
