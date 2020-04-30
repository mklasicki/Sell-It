package com.marcin;

import com.marcin.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperities.class)
public class ClientDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientDbApplication.class, args);

<<<<<<< HEAD

	}


	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
=======
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
	}
}
