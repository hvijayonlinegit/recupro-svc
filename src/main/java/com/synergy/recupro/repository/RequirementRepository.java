package com.synergy.recupro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.synergy.recupro.model.Requirements;
@CrossOrigin(origins = "*") 
@Repository
public interface RequirementRepository extends JpaRepository<Requirements, Long> {
	List<Requirements> findByAccountsId(Long account_id);
}
