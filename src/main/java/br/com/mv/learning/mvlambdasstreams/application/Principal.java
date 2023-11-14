package br.com.mv.learning.mvlambdasstreams.application;

import br.com.mv.learning.mvlambdasstreams.domain.EpisodesData;
import br.com.mv.learning.mvlambdasstreams.domain.SeasonData;
import br.com.mv.learning.mvlambdasstreams.domain.SeriesData;
import br.com.mv.learning.mvlambdasstreams.infrastructure.ConvertDataImplementation;
import br.com.mv.learning.mvlambdasstreams.model.Episodes;
import br.com.mv.learning.mvlambdasstreams.usecase.ApiConsumption;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal {
    private Scanner sc = new Scanner(System.in);
    private ApiConsumption apiConsumption = new ApiConsumption();
    private ConvertDataImplementation converter = new ConvertDataImplementation();
    private final String PATH = "http://www.omdbapi.com/?t=";

    private final String API_KEY = "&apikey=bb1a407d";

    public void exibeMenu() throws JsonProcessingException {
        System.out.println("Enter serie name");

        var serieName = sc.next();
        var json = apiConsumption.getApi(PATH, serieName.replace(" ", "+"), API_KEY);
        System.out.println(json);
        SeriesData seriesData = converter.getData(json, SeriesData.class);
        System.out.println(seriesData);

        List<SeasonData> season = new ArrayList<>();


        for (int i = 1; i <= seriesData.totalSeasons(); i++) {
            json = apiConsumption.getApiData(PATH, serieName.replace(" ", "+") + "&season=" + i, API_KEY);
            SeasonData seasonData = converter.getData(json, SeasonData.class);
            season.add(seasonData);
        }
        season.forEach(System.out::println);

        season.forEach(s -> s.episodesData().forEach(e -> System.out.println(e.title())));

        for (int i = 0; i < seriesData.totalSeasons(); i++) {
            List<EpisodesData> episodeSeasons = season.get(i).episodesData();
            System.out.println("\n ###### Season " + season.get(i).season() + " ######\n");
            for (EpisodesData episodeSeason : episodeSeasons) {
                System.out.println(episodeSeason.title());
            }
        }
        /*
        Recuperando dentro de lista de temporadas uma lista de episódios,
        e colocando dentro de uma unica lista "episodesData"
        por isso o uso do flatMap
         */
        List<EpisodesData> episodesData = season.stream()
                .flatMap(s -> s.episodesData().stream())
                .collect(Collectors.toList());

//        System.out.println("\n Top 10 episodes");

//        episodesData.stream()
//                .filter(e -> !e.imdbRating().equalsIgnoreCase("N/A"))
//                .peek(e -> System.out.println("FILTRANDO POR N/A " + e))
//                .sorted(Comparator.comparing(EpisodesData::imdbRating).reversed())
//                .peek(e -> System.out.println("ORDENAÇÃO " + e))
//                .limit(5)
//                .peek(e -> System.out.println("LIMITE " + e))
//                .map(e -> e.title().toUpperCase())
//                .peek(e -> System.out.println("MAPEAMENTO " + e))
//                .forEach(System.out::println);


        List<Episodes> episodes = season.stream()
                .flatMap(s -> s.episodesData().stream()
                        .map(ep -> new Episodes(s.season(), ep)))
                .collect(Collectors.toList());

        episodes.forEach(System.out::println);

//        System.out.println("Digite um trecho do titulo do episodio");
//
//        sc.nextLine();
//        var excerptFromEpisode = sc.nextLine();
//
//        Optional<Episodes> episodeSearched = episodes.stream()
//                .filter(e -> e.getTitle().toUpperCase().contains(excerptFromEpisode.toUpperCase()))
//                .findFirst();
//        if(episodeSearched.isPresent()){
//            System.out.println("Episodio encontrado");
//            System.out.println("Temporada " + episodeSearched.get().getSeason());
//        } else {
//            System.out.println("Episodio nao encontrado");
//        }
//
//        System.out.println("Qual ano gostaria de filtrar ?");
//
//        var year = sc.nextInt();
//        sc.nextLine();
//
//        LocalDate dateOfSearch = LocalDate.of(year, 1, 1);
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        episodes.stream()
//                .filter(e -> e.getReleaseDateOf() != null && e.getReleaseDateOf().isAfter(dateOfSearch))
//                .forEach(e -> System.out.println("Season: " + e.getSeason() + "Episode: " +
//                        e.getTitle() + " Release Date Of " + e.getReleaseDateOf().format(dtf)));


//        List<String> names = Arrays.asList("Tha", "Ma", "Zina", "Biel", "Zana", "Joao");
//
//        names.stream()
//                .sorted()
//                .filter(n -> n.startsWith("Z"))
//                .map(n -> n.toUpperCase())
//                .forEach(System.out::println);

        //Map<Integer, Double> evaluationBySeason  = episodes
          //      .stream()
          //      .filter(e -> e.getAssessment() > 0.0)
           //     .collect(Collectors.groupingBy(Episodes::getSeason,
             //           Collectors.averagingDouble(Episodes::getAssessment)));
        //System.out.println(evaluationBySeason);

        DoubleSummaryStatistics dss = episodes.stream()
                .filter(e -> e.getAssessment() > 0.0)
                .collect(Collectors.summarizingDouble(Episodes::getAssessment));
        System.out.println("Media geral: " + dss.getAverage() +
                "Nota maxima: " + dss.getMax() +
                "Nota minima: " + dss.getMin() +
                "Total de episódios: " + dss.getCount());

        Stream.iterate(0, n -> n + 1)
                .limit(10)
                .forEach(System.out::println);
//Neste exemplo, transformamos um Stream de List para um Stream de Strings.
        List<List<String>> list = List.of(
                List.of("a", "b"),
                List.of("c", "d")
        );

        Stream<String> stream = list.stream()
                .flatMap(Collection::stream);

        stream.forEach(System.out::println);

//Somando todos os numeros da lista utilizando o reduce
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Optional<Integer> result = numbers.stream().reduce(Integer::sum);
        result.ifPresent(System.out::println); //prints 15

    }
}

