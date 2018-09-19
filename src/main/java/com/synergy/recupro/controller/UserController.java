package com.synergy.recupro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synergy.recupro.exception.AppException;
import com.synergy.recupro.exception.ResourceNotFoundException;
import com.synergy.recupro.model.Role;
import com.synergy.recupro.model.User;
import com.synergy.recupro.payload.UserIdentityAvailability;
import com.synergy.recupro.payload.UserProfile;
import com.synergy.recupro.payload.UserSummary;
import com.synergy.recupro.repository.RoleRepository;
import com.synergy.recupro.repository.UserRepository;
import com.synergy.recupro.security.CurrentUser;
import com.synergy.recupro.security.UserPrincipal;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@GetMapping("/user/me")
	public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
		UserSummary userSummary = new UserSummary(currentUser.getId(),
				currentUser.getUsername(), currentUser.getName());
		return userSummary;
	}

	@GetMapping("/user/checkUsernameAvailability")
	public UserIdentityAvailability checkUsernameAvailability(
			@RequestParam(value = "username") String username) {
		Boolean isAvailable = !userRepository.existsByUsername(username);
		return new UserIdentityAvailability(isAvailable);
	}

	@GetMapping("/user/checkEmailAvailability")
	public UserIdentityAvailability checkEmailAvailability(
			@RequestParam(value = "email") String email) {
		Boolean isAvailable = !userRepository.existsByEmail(email);
		return new UserIdentityAvailability(isAvailable);
	}

	@PreAuthorize("hasAnyRole('USER', 'ADMIN','RECRUITMENT_LEAD')")
	@GetMapping("/users/{username}")
	public UserProfile getUserProfile(
			@PathVariable(value = "username") String username) {
		User user = userRepository.findByUsername(username).orElseThrow(
				() -> new ResourceNotFoundException("User", "username",
						username));

		UserProfile userProfile = new UserProfile(user.getId(),
				user.getUsername(), user.getName(), user.getCreatedAt());

		return userProfile;
	}

	@PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER')")
	@PutMapping("/users/{username}/role/{roleid}")
	public ResponseEntity<?> updateRole(@PathVariable String username,
			@PathVariable Long roleid) {
		Role role = roleRepository.findById(roleid).orElseThrow(
				() -> new AppException("Role Not Found"));
		User user = userRepository.findByUsername(username).orElseThrow(
				() -> new ResourceNotFoundException("User", "username",
						username));
		userRepository.updateUserRole(role.getId(), user.getId());
		return new ResponseEntity<>("User Role Updated Successfully",
				HttpStatus.OK);

	}

}
