package com.synergy.recupro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.synergy.recupro.exception.ResourceNotFoundException;
import com.synergy.recupro.model.Candidate;
import com.synergy.recupro.repository.CandidateRepository;
import com.synergy.recupro.repository.RequirementRepository;

@RestController
public class CandidateController {

    @Autowired
    private RequirementRepository requirementRepository;

    @Autowired
    private CandidateRepository candidatesRepository;
    @CrossOrigin(origins = "*")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN','RECRUITMENT_LEAD')")
    @GetMapping("/requirements/{reqId}/candidates")
    public List<Candidate> getCandidatesByRequirementId(@PathVariable Long reqId) {
        return candidatesRepository.findByRequirementsId(reqId);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/requirements/{reqId}/candidates")
    @PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER','USER')")
    public Candidate addCandidate(@PathVariable Long reqId,
                            @Valid @RequestBody Candidate candidatebody) {
    		//candidatesRepository.deleteAllInBatch();
    		//List<Requirements> setreq= new ArrayList<>();
        return requirementRepository.findById(reqId)
                .map(requirement -> {
                	
                	//	setreq.add(requirement);
                		candidatebody.getRequirements().add(requirement);
                		//candidatebody.setRequirements(setreq);
                
               	
                    return candidatesRepository.save(candidatebody);
                }).orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + reqId, null, candidatebody));
    }
}
