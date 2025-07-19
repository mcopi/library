package com.cop.library_membership.repositories;

import com.cop.library_membership.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsernameAndRoleRoleName(String username, String roleName);
}
