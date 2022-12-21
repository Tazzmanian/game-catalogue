package com.catalogue.gamecatalogue.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Data
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "score_seq_gen")
    @SequenceGenerator(name = "score_seq_gen", sequenceName = "score_seq", allocationSize = 1)
    private long id;
    @Min(1)
    @Max(5)
    private short score;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
}
