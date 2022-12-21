package com.catalogue.gamecatalogue.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    @Size(min=1, max=255)
    @Column(unique=true)
    private String name;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinTable(name = "game_genres",
            joinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id")
    )
    private List<Genre> genres = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinTable(name = "game_developer",
            joinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id", referencedColumnName = "id")
    )
    private List<Developer> developers = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinTable(name = "game_platform",
            joinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id", referencedColumnName = "id")
    )
    private List<Platform> platforms = new ArrayList<>();

    @OneToMany(mappedBy = "game")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "game")
    private List<Score> scores = new ArrayList<>();

}
