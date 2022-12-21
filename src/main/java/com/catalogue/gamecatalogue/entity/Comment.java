package com.catalogue.gamecatalogue.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Size(min=5, max=1000)
    private String comment;
    @Basic
    private Date createdAt;
    @Basic
    private Date modifiedAt;
    @ManyToOne
    @JoinTable(name = "game_id")
    private Game game;
}
