package com.nuestrosparques.token.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TokenAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TokenAppApplication.class, args);
    }

}
