package com.kuzmin.eliteclub.service;

import com.kuzmin.eliteclub.model.ClubDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EliteClubService {
    List<ClubDTO> getAll(Pageable pageable);

    List<ClubDTO> searchClub(String searchTerm, Pageable pageable);

    void addClub(String... clubNames);

    ClubDTO getByID(long clubId);

    void deleteClub(long clubId);

    ClubDTO updateClub(long clubId, ClubDTO updatedClub);
}
