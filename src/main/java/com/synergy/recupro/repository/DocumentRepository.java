package com.synergy.recupro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergy.recupro.model.Document;

/**
 * A JPA repository used to perform crud operations on file meta data records in
 * database
 */

public interface DocumentRepository extends JpaRepository<Document, Long> {
}