package br.com.mv.learning.mvlambdasstreams.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesData(@JsonAlias("Title") String titulo,
                         @JsonAlias("totalSeasons") String temporadas,
                         @JsonAlias("imdbRating") String nota) {
    public SeriesData {
    }
}

