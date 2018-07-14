package com.synergy.recupro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.synergy.recupro.model.Candidate;
@CrossOrigin(origins = "*")  
@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
	List<Candidate> findByRequirementsId(Long req_id);
}
