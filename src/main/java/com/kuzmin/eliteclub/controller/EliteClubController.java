package com.kuzmin.eliteclub.controller;

import com.kuzmin.eliteclub.model.ClubDTO;
import com.kuzmin.eliteclub.service.EliteClubServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EliteClubController {
    private EliteClubServiceImpl eliteClubService;

    @Autowired
    public void setEliteClubService(EliteClubServiceImpl eliteClubService) {
        this.eliteClubService = eliteClubService;
    }

    @GetMapping(path = "/clubs", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClubDTO> clubs() {
        return eliteClubService.getAll();
    }
}
