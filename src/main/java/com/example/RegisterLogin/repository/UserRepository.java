package com.example.RegisterLogin.repository;

import com.example.RegisterLogin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByRoles(String roles);

    Optional<User> findByName(String username);
}
