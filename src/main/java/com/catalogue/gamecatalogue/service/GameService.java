package com.catalogue.gamecatalogue.service;

import com.catalogue.gamecatalogue.dao.GameRepository;
import com.catalogue.gamecatalogue.entity.Game;
import com.catalogue.gamecatalogue.model.CreateGameDTO;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public long createGame(CreateGameDTO dto) {
        Game game = new Game();
        game.setName(dto.getName());
        // TODO

        gameRepository.save(game);
        return game.getId();
    }
}
