package com.catalogue.gamecatalogue.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq_gen")
    @SequenceGenerator(name = "comment_seq_gen", sequenceName = "comment_seq", allocationSize = 1)
    private long id;
    @Size(min=5, max=1000)
    private String comment;
    @Basic
    private Date createdAt;
    @Basic
    private Date modifiedAt;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
}
