package com.Registration.Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Registration.modal.User;

public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByUsername(String username);
}
