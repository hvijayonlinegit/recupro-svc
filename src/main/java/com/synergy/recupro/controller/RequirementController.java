package com.synergy.recupro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.synergy.recupro.exception.ResourceNotFoundException;
import com.synergy.recupro.model.Requirements;
import com.synergy.recupro.repository.AccountsRepository;
import com.synergy.recupro.repository.RequirementRepository;

@RestController
public class RequirementController {

	@Autowired
	private RequirementRepository requirementRepository;

	@Autowired
	private AccountsRepository accountsRepository;

	@CrossOrigin(origins = "*")
	@GetMapping("/requirements")
	@PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD')")
	public List<Requirements> getAccounts() {
		return requirementRepository.findAll();
	}
    @PreAuthorize("hasAnyRole('USER', 'ADMIN','RECRUITMENT_LEAD')")
	@GetMapping("/accounts/{accountsId}/requitements")
	public List<Requirements> getRquirementsByAccountsId(
			@PathVariable Long accountsId) {
		return requirementRepository.findByAccountsId(accountsId);
	}
    @PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER','USER')")
	@CrossOrigin(origins = "*")
	@PostMapping("/accounts/{accountsId}/requitements")
	public Requirements addRequirements(@PathVariable Long accountsId,
			@Valid @RequestBody Requirements requirement) {
		return accountsRepository
				.findById(accountsId)
				.map(accounts -> {
					requirement.setAccounts(accounts);
					return requirementRepository.save(requirement);
				})
				.orElseThrow(
						() -> new ResourceNotFoundException(
								"Question not found with id " + accountsId,
								"accountid", requirement));
	}
    @PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER','USER')")
	@PutMapping("/accounts/{accountsId}/requitements/{reqId}")
	public Requirements updateRequirements(@PathVariable Long accountsId,
			@PathVariable Long reqId,
			@Valid @RequestBody Requirements requirementRequest) {
		if (!accountsRepository.existsById(accountsId)) {
			throw new ResourceNotFoundException("Question not found with id "
					+ accountsId, null, requirementRequest);
		}

		return requirementRepository
				.findById(reqId)
				.map(requirements -> {
					requirements.setDescription(requirementRequest
							.getDescription());
					return requirementRepository.save(requirements);
				})
				.orElseThrow(
						() -> new ResourceNotFoundException(
								"Answer not found with id " + reqId, null,
								requirementRequest));
	}
    @PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/accounts/{accountsId}/requitements/{reqId}")
	public ResponseEntity<?> deleteRequirement(@PathVariable Long accountsId,
			@PathVariable Long reqId) {
		if (!accountsRepository.existsById(accountsId)) {
			throw new ResourceNotFoundException("Question not found with id "
					+ accountsId, null, reqId);
		}

		return requirementRepository
				.findById(reqId)
				.map(requirements -> {
					requirementRepository.delete(requirements);
					return ResponseEntity.ok().build();
				})
				.orElseThrow(
						() -> new ResourceNotFoundException(
								"Answer not found with id " + reqId, null,
								reqId));

	}
}
