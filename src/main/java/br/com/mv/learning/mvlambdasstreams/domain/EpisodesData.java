package br.com.mv.learning.mvlambdasstreams.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EpisodesData(@JsonAlias("Title") String title,
                           @JsonAlias("Released") String released,
                           @JsonAlias("imdbRating") String imdbRating) {
    public EpisodesData{

    }
}
