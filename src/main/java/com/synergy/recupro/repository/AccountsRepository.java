package com.synergy.recupro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.synergy.recupro.model.Accounts;
@CrossOrigin(origins = "*")  

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
}
