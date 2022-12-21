package com.catalogue.gamecatalogue.api;

import com.catalogue.gamecatalogue.model.CreateGameDTO;
import com.catalogue.gamecatalogue.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("")
    public ResponseEntity<Long> createGame(@Valid @RequestBody CreateGameDTO dto) {
        return ResponseEntity.ok(gameService.createGame(dto));
    }

    @GetMapping("/{id}")
    public void getGame(@PathVariable long id) {

    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable long id) {

    }

    @PutMapping("/{id}")
    public void updateGame(@PathVariable long id) {

    }
}
