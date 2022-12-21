package com.catalogue.gamecatalogue.api;

import com.catalogue.gamecatalogue.dao.GenreRepository;
import com.catalogue.gamecatalogue.entity.Genre;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("genres")
public class GenresController {

    private final GenreRepository genreRepository;

    public GenresController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @PostMapping("")
    public ResponseEntity<Long> addDeveloper(@Valid @RequestBody String name) {
        return ResponseEntity.ok(genreRepository.save(new Genre(name)).getId());
    }

    @GetMapping("")
    public ResponseEntity<List<Genre>> getAll() {
        return ResponseEntity.ok(genreRepository.findAll());
    }
}
