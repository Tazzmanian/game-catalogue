package com.catalogue.gamecatalogue.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Platform {

    public Platform(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "platform_seq_gen")
    @SequenceGenerator(name = "platform_seq_gen", sequenceName = "platform_seq", allocationSize = 1)
    private long id;
    @NotBlank
    @Size(min=1, max=255)
    @Column(unique=true)
    private String name;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinTable(name = "game_platform",
            joinColumns = @JoinColumn(name = "platform_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id")
    )
    private List<Game> games;
}
