package mx.edu.utez.centro_pokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CentroPokemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentroPokemonApplication.class, args);
	}

}
