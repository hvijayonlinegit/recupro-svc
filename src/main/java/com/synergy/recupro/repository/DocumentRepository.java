package com.synergy.recupro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.synergy.recupro.model.Document;

/**
 * A JPA repository used to perform crud operations on file meta data records in
 * database
 */
@CrossOrigin(origins = "*") 
@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
	
	@Query(value = "select * from Documents where candidateId = ?1 and documentName= ?2", nativeQuery = true)
	Document findBydocumentType(Long Id, String docName);
}