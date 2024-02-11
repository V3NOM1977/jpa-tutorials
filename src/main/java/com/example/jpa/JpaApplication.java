package com.example.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepo repo) {
		return args -> {
			for (var i = 0; i < 5; i++)
				repo.save(new User("User " + (i + 1)));
			Sort sort = Sort.by(
					Sort.Order.asc("name"),
					Sort.Order.desc("id"));
			Pageable pageable = PageRequest.of(0, 5, sort);
			System.out.println(repo.findAll(pageable).getContent());
		};
	}

}
