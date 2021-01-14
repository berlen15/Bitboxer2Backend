package com.example.formacionBitboxer2;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("entities")
@SpringBootApplication
public class FormacionBitboxer2Application {

	private static final Logger log = LoggerFactory.getLogger(FormacionBitboxer2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(FormacionBitboxer2Application.class, args);
	}

	/*@Bean
	public CommandLineRunner demo(ArticuloRepository repository){
		return (args) -> {
			repository.save(new Articulo(1, 1, "Producto 1", 2.3, 1));
			repository.save(new Articulo(2, 2, "Producto 2", 3.3, 1));

			//fetch all products
			log.info("findAll() of ArticuloRepository");
			log.info("-------------------------------");

			for(Articulo articulo: repository.findAll()){
				log.info(articulo.toString());
			}

			Articulo articulo = repository.findOneById(1);
			log.info("findOneByID of ArticuloRepository (id=1)");
			log.info("----------------------------------------");
			log.info(articulo.toString());
			log.info("");
		};
	}*/
}
