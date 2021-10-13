package com.kuzmin.eliteclub.controller;

import com.kuzmin.eliteclub.model.ClubDTO;
import com.kuzmin.eliteclub.service.EliteClubServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EliteClubController {
    private EliteClubServiceImpl eliteClubService;

    @Autowired
    public void setEliteClubService(EliteClubServiceImpl eliteClubService) {
        this.eliteClubService = eliteClubService;
    }

    @GetMapping(path = "/clubs", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClubDTO> clubs(Pageable pageable) {
        return eliteClubService.getAll(pageable);
    }

    @PostMapping(path = "/club", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createNewClub(@RequestBody ClubDTO clubDTO) {
        eliteClubService.addClub(clubDTO.getClubName());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping(path = "/club/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClubDTO> searchClub(@RequestParam String clubName, Pageable pageable) {
        return eliteClubService.searchClub(clubName, pageable);
    }

    @GetMapping(path = "/club/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClubDTO clubWithId(@PathVariable long id) {
        return eliteClubService.getByID(id);
    }

    @DeleteMapping(path = "/club/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteClub(@PathVariable long id) {
        eliteClubService.deleteClub(id);
    }

    @PutMapping(path = "/club/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClubDTO updateClub(@PathVariable long id, @RequestBody ClubDTO clubDTO) {
        return eliteClubService.updateClub(id, clubDTO);
    }
}
