package br.com.noe.hydra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class HydraApplication {

    public static void main(String[] args) {
        SpringApplication.run(HydraApplication.class, args);
    }

}
