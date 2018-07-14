package com.synergy.recupro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synergy.recupro.model.Document;

/**
 * A JPA repository used to perform crud operations on file meta data records in
 * database
 */

public interface DocumentRepository extends JpaRepository<Document, Long> {
/*	@Query("select d from Documents d where d.candidate.candidateId = ?1 and d.documentName= ?2")
	Document findBydocumentType(Long Id, String docName);*/
}