package com.catalogue.gamecatalogue.api;

import com.catalogue.gamecatalogue.dao.DevelopersRepository;
import com.catalogue.gamecatalogue.entity.Developer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("developers")
public class DeveloperController {

    private final DevelopersRepository developersRepository;

    public DeveloperController(DevelopersRepository developersRepository) {
        this.developersRepository = developersRepository;
    }

    @PostMapping("")
    public ResponseEntity<Long> addDeveloper(@Valid @RequestBody String name) {
        return ResponseEntity.ok(developersRepository.save(new Developer(name)).getId());
    }

    @GetMapping("")
    public ResponseEntity<List<Developer>> getAll() {
        return ResponseEntity.ok(developersRepository.findAll());
    }
}
