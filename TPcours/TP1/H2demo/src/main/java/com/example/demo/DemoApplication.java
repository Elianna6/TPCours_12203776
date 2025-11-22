package com.example.demo;

import com.example.demo.entities.Adherent;
import com.example.demo.repository.AdherentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    CommandLineRunner runner(AdherentRepository repository) {
        return args -> {
            repository.save(new Adherent(null,"A","B",29));
            repository.save(new Adherent(null,"A","B",29));
            repository.save(new Adherent(null,"A","B",29));
            repository.save(new Adherent(null,"A","B",29));
        };
    }

}
