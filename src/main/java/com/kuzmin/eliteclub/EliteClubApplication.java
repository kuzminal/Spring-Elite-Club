package com.kuzmin.eliteclub;

import com.kuzmin.eliteclub.config.SwaggerConfig;
import com.kuzmin.eliteclub.service.EliteClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class EliteClubApplication implements ApplicationRunner {
    @Autowired
    private EliteClubService eliteClubService;

    public static void main(String[] args) {
        SpringApplication.run(EliteClubApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        eliteClubService.addClub("Billionaire", "Environmentalist", "Poker");
    }

}
