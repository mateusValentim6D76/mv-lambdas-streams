package br.com.mv.learning.mvlambdasstreams;

import br.com.mv.learning.mvlambdasstreams.application.Principal;
import br.com.mv.learning.mvlambdasstreams.domain.EpisodesData;
import br.com.mv.learning.mvlambdasstreams.domain.SeasonData;
import br.com.mv.learning.mvlambdasstreams.domain.SeriesData;
import br.com.mv.learning.mvlambdasstreams.enums.ApiUrl;
import br.com.mv.learning.mvlambdasstreams.infrastructure.ConvertDataImplementation;
import br.com.mv.learning.mvlambdasstreams.usecase.ApiConsumption;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.AliasFor;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MvLambdasStreamsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MvLambdasStreamsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}
