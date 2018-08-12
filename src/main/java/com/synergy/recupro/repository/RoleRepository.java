package com.synergy.recupro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.synergy.recupro.model.Role;
import com.synergy.recupro.model.RoleName;
@CrossOrigin(origins = "*")  
@PreAuthorize("hasRole('ROLE_ADMIN')")
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
