package com.kuzmin.eliteclub.service;

import com.kuzmin.eliteclub.domain.EliteClub;
import com.kuzmin.eliteclub.model.ClubDTO;
import com.kuzmin.eliteclub.repository.EliteClubRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EliteClubServiceImpl implements EliteClubService{
    private static final Logger LOG = LoggerFactory.getLogger(EliteClubServiceImpl.class);
    private EliteClubRepository eliteClubRepository;

    @Autowired
    public void setEliteClubRepository(EliteClubRepository eliteClubRepository) {
        this.eliteClubRepository = eliteClubRepository;
    }

    public List<ClubDTO> getAll() {
        return eliteClubRepository.findAll(PageRequest.of(0, 3, Sort.by("rating").descending()))
                .stream()
                .map(c -> new ClubDTO(c.getClubName(), c.getRating()))
                .collect(Collectors.toList());
    }

    public void addClub(String... clubNames) {
        for (String clubName : clubNames) {
            EliteClub eliteClub = new EliteClub();
            eliteClub.setClubName(clubName);
            eliteClubRepository.save(eliteClub);
        }
    }

    public List<ClubDTO> searchClub(String searchTerm) {
        LOG.info("Searching term {}", searchTerm);
        List<ClubDTO> result = eliteClubRepository.findClubs(buildLikePattern(searchTerm))
                .stream()
                .map(c -> new ClubDTO(c.getClubName(), c.getRating()))
                .collect(Collectors.toList());
        LOG.info("Search Result: {} ", result);
        return result;
    }

    private String buildLikePattern(String searchTerm) {
        return searchTerm.toLowerCase() + "%";
    }
}
