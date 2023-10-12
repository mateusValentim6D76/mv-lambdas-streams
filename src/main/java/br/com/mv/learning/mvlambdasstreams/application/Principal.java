package br.com.mv.learning.mvlambdasstreams.application;

import br.com.mv.learning.mvlambdasstreams.domain.EpisodesData;
import br.com.mv.learning.mvlambdasstreams.domain.SeasonData;
import br.com.mv.learning.mvlambdasstreams.domain.SeriesData;
import br.com.mv.learning.mvlambdasstreams.infrastructure.ConvertDataImplementation;
import br.com.mv.learning.mvlambdasstreams.usecase.ApiConsumption;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner sc = new Scanner(System.in);
    private ApiConsumption apiConsumption = new ApiConsumption();
    private ConvertDataImplementation converter = new ConvertDataImplementation();
    private final String PATH = "http://www.omdbapi.com/?t=";

    private final String API_KEY = "&apikey=bb1a407d";

    public void exibeMenu() throws JsonProcessingException {
        System.out.println("Enter serie name");

        var serieName = sc.next();
        var json = apiConsumption.getApi(PATH, serieName.replace(" ", "+"),API_KEY);
        System.out.println(json);
        SeriesData seriesData = converter.getData(json, SeriesData.class);
        System.out.println(seriesData);

        List<SeasonData> season = new ArrayList<>();


        for (int i = 1; i<=seriesData.totalSeasons(); i++){
            json =  apiConsumption.getApiData(PATH, serieName.replace(" ", "+") +"&season=" + i,API_KEY);
            SeasonData seasonData = converter.getData(json, SeasonData.class);
            season.add(seasonData);
        }
        season.forEach(System.out::println);

        season.forEach(s-> s.episodesData().forEach(e-> System.out.println(e.title())));

//        for (int i =0; i<seriesData.totalSeasons(); i++){
//            List<EpisodesData> episodeSeasons = season.get(i).episodesData();
//            System.out.println("\n ###### Season "+ season.get(i).season() + " ######\n");
//            for (EpisodesData episodeSeason : episodeSeasons) {
//                System.out.println(episodeSeason.title());
//            }
//        }
    }

}
