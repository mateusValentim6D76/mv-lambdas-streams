package br.com.mv.learning.mvlambdasstreams.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesData(@JsonAlias("titulo") String title,
                         @JsonAlias("sessoes") String totalSeasons,
                         @JsonAlias("nota") String imdbRating) {
}
