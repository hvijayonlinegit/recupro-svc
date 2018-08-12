package com.synergy.recupro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.synergy.recupro.model.User;
@CrossOrigin(origins = "*") 
//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);

	Optional<User> findByUsernameOrEmail(String username, String email);

	List<User> findByIdIn(List<Long> userIds);

	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	@Modifying
	@Transactional
	@Query(value = "UPDATE user_roles SET role_id =?1 WHERE user_id = ?2", nativeQuery = true)
	void updateUserRole(Long roleId, Long userId);

}
