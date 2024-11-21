package dev.lunyov.idvizer_office;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "dev.lunyov.idvizer_office.repository")
@EntityScan(basePackages = "dev.lunyov.idvizer_office.entity")
public class IdvizerOfficeApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdvizerOfficeApplication.class, args);
	}

}
