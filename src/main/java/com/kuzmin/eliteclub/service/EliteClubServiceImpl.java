package com.kuzmin.eliteclub.service;

import com.kuzmin.eliteclub.domain.EliteClub;
import com.kuzmin.eliteclub.model.ClubDTO;
import com.kuzmin.eliteclub.repository.EliteClubRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

    public List<ClubDTO> getAll(Pageable pageable) {
        return eliteClubRepository.findAll(pageable)
                .stream()
                .map(c -> new ClubDTO(c.getClubName(), c.getRating()))
                .collect(Collectors.toList());
    }

    public List<ClubDTO> searchClub(String searchTerm, Pageable pageable) {
        LOG.info("Searching term {}", searchTerm);
        List<ClubDTO> result = eliteClubRepository.findAllByClubNameContainingIgnoreCase(searchTerm, pageable)
                .stream()
                .map(c -> new ClubDTO(c.getClubName(), c.getRating()))
                .collect(Collectors.toList());
        LOG.info("Search Result: {} ", result);
        return result;
    }

    public void addClub(String... clubNames) {
        for (String clubName : clubNames) {
            EliteClub eliteClub = new EliteClub();
            eliteClub.setClubName(clubName);
            eliteClubRepository.save(eliteClub);
        }
    }

    @Override
    public ClubDTO getByID(long clubId) {
        return eliteClubRepository.findById(clubId)
                .map(club -> new ClubDTO(club.getClubName(), club.getRating())).orElseGet(ClubDTO::new);
    }

    @Override
    public void deleteClub(long clubId) {
        eliteClubRepository.deleteById(clubId);
    }

    @Override
    public ClubDTO updateClub(long clubId, ClubDTO updatedClub) {
        EliteClub eliteClub = new EliteClub();
        eliteClub.setId(clubId);
        eliteClub.setClubName(updatedClub.getClubName());
        final EliteClub saved = eliteClubRepository.save(eliteClub);
        return new ClubDTO(saved.getClubName(), saved.getRating());
    }
}
