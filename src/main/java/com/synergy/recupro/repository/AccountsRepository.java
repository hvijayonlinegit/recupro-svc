package com.synergy.recupro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.synergy.recupro.model.Accounts;
@CrossOrigin(origins = "*")  
@PreAuthorize("hasAnyRole('RECRUITMENT_LEAD', 'ROLE_ADMIN')")
@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
}
