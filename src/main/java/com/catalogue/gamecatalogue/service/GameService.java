package com.catalogue.gamecatalogue.service;

import com.catalogue.gamecatalogue.dao.*;
import com.catalogue.gamecatalogue.entity.Game;
import com.catalogue.gamecatalogue.model.CreateGameDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final CommentRepository commentRepository;
    private final DevelopersRepository developersRepository;
    private final GenreRepository genreRepository;
    private final PlatformRepository platformRepository;
    private final ScoreRepository scoreRepository;

    public GameService(GameRepository gameRepository, CommentRepository commentRepository,
                       DevelopersRepository developersRepository, GenreRepository genreRepository,
                       PlatformRepository platformRepository, ScoreRepository scoreRepository) {
        this.gameRepository = gameRepository;
        this.commentRepository = commentRepository;
        this.developersRepository = developersRepository;
        this.genreRepository = genreRepository;
        this.platformRepository = platformRepository;
        this.scoreRepository = scoreRepository;
    }

    @Transactional
    public long createGame(CreateGameDTO dto) {
        if (gameRepository.existsByName(dto.getName())) {
            throw new RuntimeException("Game already exists");
        }
        Game game = new Game();
        game.setName(dto.getName());
        game.getDevelopers().addAll(developersRepository.findAllById(dto.getDevelopers()));
        game.getGenres().addAll(genreRepository.findAllById(dto.getGenres()));
        game.getPlatforms().addAll(platformRepository.findAllById(dto.getPlatforms()));

        gameRepository.save(game);
        return game.getId();
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }
}
