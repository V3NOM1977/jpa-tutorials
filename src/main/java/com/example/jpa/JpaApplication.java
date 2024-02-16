package com.example.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;

// import com.example.jpa.models.Address;
// import com.example.jpa.models.User;
import com.example.jpa.repositories.UserRepo;
import com.example.jpa.repositories.UserRepoWithoutJpaRepo;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepo repo, UserRepoWithoutJpaRepo repoWithoutJpaRepo) {
		return args -> {
			// for (var i = 0; i < 5; i++)
			// 	repo.save(new User("User " + (i + 1), new Address("121004")));
			// Sort sort = Sort.by(
			// 		Sort.Order.asc("userName"),
			// 		Sort.Order.desc("id"));
			// Pageable pageable = PageRequest.of(0, 5, sort);
			// System.out.println(repo.findAll(pageable).getContent());
			// System.out.println("-----------------------------------------");
			// System.out.println(repoWithoutJpaRepo.findAll());
		};
	}

}
