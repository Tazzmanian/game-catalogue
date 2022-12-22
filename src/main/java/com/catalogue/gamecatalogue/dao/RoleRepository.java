package com.catalogue.gamecatalogue.dao;

import com.catalogue.gamecatalogue.conf.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
