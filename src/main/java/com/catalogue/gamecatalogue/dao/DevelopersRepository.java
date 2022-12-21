package com.catalogue.gamecatalogue.dao;

import com.catalogue.gamecatalogue.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevelopersRepository extends JpaRepository<Developer, Long> {
}
