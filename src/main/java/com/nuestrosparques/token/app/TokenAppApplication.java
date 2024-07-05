package com.nuestrosparques.token.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TokenAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TokenAppApplication.class, args);
    }

    // Este método se ejecutará después de que el bean haya sido construido
    @PostConstruct
    void init() {
        // Configura el timezone predeterminado a UTC
        TimeZone.setDefault(TimeZone.getTimeZone("America/Santiago"));
    }
}
