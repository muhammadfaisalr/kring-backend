package id.muhammadfaisal.kring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class KringApplication {

	public static void main(String[] args) {
		SpringApplication.run(KringApplication.class, args);
	}

}
