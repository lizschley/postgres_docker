package liz.postgres_demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			Student ronin = new Student(
					null,
					"Ronin",
					"Orange White",
					"ronin@amigoscode.edu",
					4
			);

			Student ninja = new Student(
					null,
					"Ninja",
					"Black",
					"ninja.jones@amigoscode.edu",
					null
			);

			Student sammy = new Student(
					null,
					"Sammy",
					"McLeod",
					"ahmed.ali@amigoscode.edu",
					22
			);

			studentRepository.saveAll(List.of(ronin, ninja, sammy));

		};
	}

}