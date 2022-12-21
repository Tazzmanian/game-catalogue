package com.catalogue.gamecatalogue.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Genre {

    public Genre(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_seq_gen")
    @SequenceGenerator(name = "genre_seq_gen", sequenceName = "genre_seq", allocationSize = 1)
    private long id;
    @NotBlank
    @Size(min=1, max=255)
    @Column(unique=true)
    private String name;
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "game_genres",
            joinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id")
    )
    private List<Game> games;
}
