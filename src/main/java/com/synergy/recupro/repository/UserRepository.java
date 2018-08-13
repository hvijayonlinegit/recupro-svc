package com.synergy.recupro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.synergy.recupro.model.User;

@CrossOrigin(origins = "*")
//@PreAuthorize(value = "")
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);

	Optional<User> findByUsernameOrEmail(String username, String email);

	List<User> findByIdIn(List<Long> userIds);

	//@PreAuthorize("hasAnyRole('USER', 'ADMIN','RECRUITMENT_LEAD')")
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	@PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER')")
	@Modifying
	@Transactional
	@Query(value = "UPDATE user_roles SET role_id =?1 WHERE user_id = ?2", nativeQuery = true)
	void updateUserRole(Long roleId, Long userId);


	@PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD')")
	@Override
	public List<User> findAll();

	//@PreAuthorize("hasAnyRole('USER', 'ADMIN','RECRUITMENT_LEAD')")
	@Override
	public Optional<User> findById(Long id);

	@PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD')")
	@Override
	public <S extends User> List<S> findAll(Example<S> example);

	@PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER','USER')")
	@Override
	public <S extends User> S save(S entity);

	@PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER','USER')")
	@Override
	public <S extends User> List<S> saveAll(Iterable<S> entities);

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void delete(User entity);

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void deleteAll();

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void deleteById(Long id);

}
