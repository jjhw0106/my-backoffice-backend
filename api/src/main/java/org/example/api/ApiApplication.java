package org.example.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Level;

@SpringBootApplication
@Slf4j
public class ApiApplication {

    public static void main(String[] args) {
        log.info("ApiApplication started");
        SpringApplication.run(ApiApplication.class, args);
    }

}
