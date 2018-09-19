package com.synergy.recupro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
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
@PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER','USER')")
@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@Query(value = "select * from Documents where candidateId = ?1 and documentName= ?2", nativeQuery = true)
	Document findBydocumentType(Long Id, String docName);

	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@Override
	public List<Document> findAll();

	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@Override
	public Optional<Document> findById(Long id);

	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@Override
	public <S extends Document> List<S> findAll(Example<S> example);

	@PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER','USER')")
	@Override
	public <S extends Document> S save(S entity);

	@PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER','USER')")
	@Override
	public <S extends Document> List<S> saveAll(Iterable<S> entities);

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void delete(Document entity);

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void deleteAll();

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void deleteById(Long id);

}