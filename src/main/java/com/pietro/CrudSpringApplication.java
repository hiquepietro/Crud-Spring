package com.pietro;

import com.pietro.enums.Categoria;
import com.pietro.model.Curso;
import com.pietro.repository.CursoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);

	}
	@Bean
	CommandLineRunner initDatabase(CursoRepository cursoRepository) {
		return args -> {
			cursoRepository.deleteAll();

			Curso c = new Curso();
			c.setNome("ANGULAR COM SPRING BOOT");
			c.setCategoria(Categoria.FRONT_END);

			cursoRepository.save(c);
		};

	}
}
