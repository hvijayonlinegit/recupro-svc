package com.synergy.recupro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/** An entity that stores file meta data into database */
@Entity
@Table(name = "documents")
public class Document {
	
	@Id
    @GeneratedValue(generator = "documents_generator")
    @SequenceGenerator(
            name = "documents_generator",
            sequenceName = "documents_sequence",
            initialValue = 1000
    )
	private Long id;

	@Column(name = "candidateid")
	private Long candidateId;

	@Column(name = "documentname")
	private String documentName;

	@Column(name = "documenttype")
	private String documentType;

	@Column(name = "documentsize")
	private long documentSize;

	public Long getId() {
		return id;
	}

	public Long getCandidateId() {
		return candidateId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public String getDocumentType() {
		return documentType;
	}

	public long getDocumentSize() {
		return documentSize;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public void setDocumentSize(long documentSize) {
		this.documentSize = documentSize;
	}



}
