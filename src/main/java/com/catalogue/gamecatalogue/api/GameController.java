package com.catalogue.gamecatalogue.api;

import com.catalogue.gamecatalogue.entity.Game;
import com.catalogue.gamecatalogue.model.CreateGameDTO;
import com.catalogue.gamecatalogue.model.GameResponse;
import com.catalogue.gamecatalogue.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("")
    public ResponseEntity<List<Game>> getAllGame() {
        return ResponseEntity.ok(gameService.getAllGames());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameResponse> getGame(@PathVariable long id) {
        return ResponseEntity.ok(gameService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable long id) {

    }

    @PutMapping("/{id}")
    public void updateGame(@PathVariable String id, @Valid @RequestBody CreateGameDTO dto) {

    }
}
