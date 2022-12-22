package com.catalogue.gamecatalogue.dao;

import com.catalogue.gamecatalogue.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByValidIsTrueAndEmailOrValidIsTrueAndUsername(String username, String username1);
    Optional<User> findByUsername(String username);
}
