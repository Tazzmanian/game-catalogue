package com.catalogue.gamecatalogue.model;

import com.catalogue.gamecatalogue.entity.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameResponse {
    private long id;
    private String name;
    private List<Genre> genres = new ArrayList<>();
    private List<Developer> developers = new ArrayList<>();
    private List<Platform> platforms = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();
    private List<Score> scores = new ArrayList<>();
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date release_date;
}
