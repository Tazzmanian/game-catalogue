package com.catalogue.gamecatalogue.dao;

import com.catalogue.gamecatalogue.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}
