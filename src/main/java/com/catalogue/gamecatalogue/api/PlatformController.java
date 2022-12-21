package com.catalogue.gamecatalogue.api;

import com.catalogue.gamecatalogue.dao.PlatformRepository;
import com.catalogue.gamecatalogue.entity.Platform;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("platforms")
public class PlatformController {

    private final PlatformRepository platformRepository;

    public PlatformController(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    @PostMapping("")
    public ResponseEntity<Long> addDeveloper(@Valid @RequestBody String name) {
        return ResponseEntity.ok(platformRepository.save(new Platform(name)).getId());
    }

    @GetMapping("")
    public ResponseEntity<List<Platform>> getAll() {
        return ResponseEntity.ok(platformRepository.findAll());
    }
}
