package com.synergy.recupro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synergy.recupro.model.Document;

/**
 * A JPA repository used to perform crud operations on file meta data records in
 * database
 */

public interface DocumentRepository extends JpaRepository<Document, Long> {
	
	@Query(value = "select * from Documents where candidateId = ?1 and documentName= ?2", nativeQuery = true)
	Document findBydocumentType(Long Id, String docName);
}