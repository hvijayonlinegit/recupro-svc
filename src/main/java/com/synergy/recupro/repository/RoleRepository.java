package com.synergy.recupro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.synergy.recupro.model.Role;
import com.synergy.recupro.model.RoleName;
@CrossOrigin(origins = "*")  
@PreAuthorize("hasRole('ADMIN')")
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
    Optional<Role> findByName(RoleName roleName);
    
    @PreAuthorize("hasRole('ADMIN')")
	@Override
	public List<Role> findAll();

    @PreAuthorize("hasRole('ADMIN')")
	@Override
	public Optional<Role> findById(Long id);

    @PreAuthorize("hasRole('ADMIN')")
	@Override
	public <S extends Role> List<S> findAll(Example<S> example);

	@PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER','USER')")
	@Override
	public <S extends Role> S save(S entity);

	@PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER','USER')")
	@Override
	public <S extends Role> List<S> saveAll(Iterable<S> entities);

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void delete(Role entity);

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void deleteAll();

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void deleteById(Long id);
}
