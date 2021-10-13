package com.kuzmin.eliteclub.service;

import com.kuzmin.eliteclub.model.ClubDTO;

import java.util.List;

public interface EliteClubService {
    List<ClubDTO> getAll();

    List<ClubDTO> searchClub(String searchTerm);

    void addClub(String... clubNames);
}
