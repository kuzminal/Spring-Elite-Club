package com.kuzmin.eliteclub.service;

import com.kuzmin.eliteclub.domain.EliteClub;
import com.kuzmin.eliteclub.model.ClubDTO;
import com.kuzmin.eliteclub.repository.EliteClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EliteClubService {
    private EliteClubRepository eliteClubRepository;

    @Autowired
    public void setEliteClubRepository(EliteClubRepository eliteClubRepository) {
        this.eliteClubRepository = eliteClubRepository;
    }

    public List<ClubDTO> getAll() {
        return eliteClubRepository.findAll().stream().map(c -> new ClubDTO(c.getClubName())).collect(Collectors.toList());
    }

    public void addClub(String... clubNames) {
        for (String clubName : clubNames) {
            EliteClub eliteClub = new EliteClub();
            eliteClub.setClubName(clubName);
            eliteClubRepository.save(eliteClub);
        }
    }
}
