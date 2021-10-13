package com.kuzmin.eliteclub;

import com.kuzmin.eliteclub.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class EliteClubApplication {
    public static void main(String[] args) {
        SpringApplication.run(EliteClubApplication.class, args);
    }
}
