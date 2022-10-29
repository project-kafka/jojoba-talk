package kr.jojoba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JoJoBaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JoJoBaApplication.class, args);
    }
}
