package br.com.mv.learning.mvlambdasstreams.application;

import br.com.mv.learning.mvlambdasstreams.domain.SeriesData;
import br.com.mv.learning.mvlambdasstreams.enums.ApiUrl;
import br.com.mv.learning.mvlambdasstreams.infrastructure.ConvertDataImplementation;
import br.com.mv.learning.mvlambdasstreams.usecase.ApiConsumption;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Scanner;

public class Principal {
    Scanner sc = new Scanner(System.in);
    private ApiConsumption apiConsumption = new ApiConsumption();
    private ConvertDataImplementation converter = new ConvertDataImplementation();
    private final String PATH = "https://www.omdbapi.com/?t=";

    private final String API_KEY = "&apikey=bb1a407d";

    public void exibeMenu() throws JsonProcessingException {
        System.out.println("Enter serie name");

        var serieName = sc.nextLine();
        String json = apiConsumption.getApi(PATH, serieName.replace(" ", "+"),API_KEY);
        System.out.println(json);
        SeriesData seriesData = converter.getData(json, SeriesData.class);
        System.out.println(seriesData);

    }
}
