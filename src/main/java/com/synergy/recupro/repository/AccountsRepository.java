package com.synergy.recupro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.synergy.recupro.model.Accounts;

@CrossOrigin(origins = "*")
@Repository
@PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER','USER')")
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
	@PreAuthorize("hasAnyRole('RECRUITMENT_LEAD', 'ADMIN')")
	@Override
	public List<Accounts> findAll();

	@PreAuthorize("hasAnyRole('RECRUITMENT_LEAD', 'ADMIN')")
	@Override
	public Optional<Accounts> findById(Long id);

	@PreAuthorize("hasAnyRole('RECRUITMENT_LEAD', 'ADMIN')")
	@Override
	public <S extends Accounts> List<S> findAll(Example<S> example);

	@PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER','USER')")
	@Override
	public <S extends Accounts> S save(S entity);

	@PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER','USER')")
	@Override
	public <S extends Accounts> List<S> saveAll(Iterable<S> entities);

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void delete(Accounts entity);

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void deleteAll();

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void deleteById(Long id);

}
