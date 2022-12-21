package com.catalogue.gamecatalogue.dao;

import com.catalogue.gamecatalogue.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
