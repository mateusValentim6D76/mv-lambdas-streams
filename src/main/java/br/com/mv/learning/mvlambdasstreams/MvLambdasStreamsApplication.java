package br.com.mv.learning.mvlambdasstreams;

import br.com.mv.learning.mvlambdasstreams.enums.ApiUrl;
import br.com.mv.learning.mvlambdasstreams.usecase.ApiConsumption;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MvLambdasStreamsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MvLambdasStreamsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumeApi = new ApiConsumption();
		var json = consumeApi.getApiData(ApiUrl.OMDB_API.getUrl());
		System.out.println(json);
	}
}
