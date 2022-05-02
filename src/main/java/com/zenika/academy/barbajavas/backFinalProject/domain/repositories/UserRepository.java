package com.zenika.academy.barbajavas.backFinalProject.domain.repositories;

import com.zenika.academy.barbajavas.backFinalProject.domain.model.users.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findByUsername(String username);
}
