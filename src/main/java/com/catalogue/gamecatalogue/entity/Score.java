package com.catalogue.gamecatalogue.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Data
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Min(1)
    @Max(5)
    private short score;

    @ManyToOne
    @JoinTable(name = "game_id")
    private Game game;
}
