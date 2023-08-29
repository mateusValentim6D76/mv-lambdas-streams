package br.com.mv.learning.mvlambdasstreams.domain;

import com.fasterxml.jackson.annotation.JsonAlias;

public record SeriesData(@JsonAlias("Title") String title,
                         @JsonAlias("totalSeasons") String totalSeasons,
                         @JsonAlias("imdbRating") String imdbRating) {
}
