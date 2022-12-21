package com.catalogue.gamecatalogue.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class CreateGameDTO {
    @NotBlank
    @Size(min=1, max=255)
    private String name;
    @NotNull
    private List<Long> genres;
    @NotNull
    private List<Long> developers;
    @NotNull
    private List<Long> platforms;
}
