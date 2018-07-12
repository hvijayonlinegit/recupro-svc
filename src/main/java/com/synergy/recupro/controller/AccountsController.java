package com.synergy.recupro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.synergy.recupro.exception.ResourceNotFoundException;
import com.synergy.recupro.model.Accounts;
import com.synergy.recupro.repository.AccountsRepository;

@RestController
public class AccountsController {

    @Autowired
    private AccountsRepository AccountsRepository;
    
    @CrossOrigin(origins = "*")
    @GetMapping("/accounts")
    public List<Accounts> getAccounts() {
        return AccountsRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/accounts")
    public Accounts createAccount(@Valid @RequestBody Accounts accounts) {
        return AccountsRepository.save(accounts);
    }

    @PostMapping("/accounts/{accountId}")
    public Accounts updateAccount(@PathVariable Long accountId,
                                   @Valid @RequestBody Accounts accountsRequest) {
        return AccountsRepository.findById(accountId)
                .map(accounts -> {
                	accounts.setName(accountsRequest.getName());
                	//accounts.setDescription(accountsRequest.getDescription());
                    return AccountsRepository.save(accounts);
                }).orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + accountId, null, accountsRequest));
    }


    @DeleteMapping("/accounts/{accountId}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountId) {
        return AccountsRepository.findById(accountId)
                .map(accounts -> {
                    AccountsRepository.delete(accounts);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + accountId, null, accountId));
    }
}
