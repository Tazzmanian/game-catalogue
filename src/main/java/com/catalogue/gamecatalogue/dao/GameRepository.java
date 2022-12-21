package com.catalogue.gamecatalogue.dao;

import com.catalogue.gamecatalogue.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

    boolean existsByName(String name);
}
