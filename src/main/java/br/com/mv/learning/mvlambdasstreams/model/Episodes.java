package br.com.mv.learning.mvlambdasstreams.model;

import br.com.mv.learning.mvlambdasstreams.domain.EpisodesData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class Episodes {
    private Integer season;
    private String title;
    private Integer numberEpisode;
    private Double assessment;

    private LocalDate releaseDateOf;

    public Episodes(Integer season, EpisodesData ep) {
        this.season = season;
        this.title = ep.title();
        this.numberEpisode = ep.number();
        try {
            this.assessment = Double.valueOf(ep.imdbRating());
        } catch (NumberFormatException e){
            this.assessment = 0.0;
        }
        try {
            this.releaseDateOf = LocalDate.parse(ep.released());
        }catch (DateTimeParseException e) {
            this.releaseDateOf = null;
        }
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumberEpisode() {
        return numberEpisode;
    }

    public void setNumberEpisode(Integer numberEpisode) {
        this.numberEpisode = numberEpisode;
    }

    public Double getAssessment() {
        return assessment;
    }

    public void setAssessment(Double assessment) {
        this.assessment = assessment;
    }

    public LocalDate getReleaseDateOf() {
        return releaseDateOf;
    }

    public void setReleaseDateOf(LocalDate releaseDateOf) {
        this.releaseDateOf = releaseDateOf;
    }
    @Override
    public String toString() {
        return "season=" + season +
                ", title='" + title + '\'' +
                ", numberEpisode=" + numberEpisode +
                ", assessment=" + assessment +
                ", releaseDateOf=" + releaseDateOf;
    }
}
