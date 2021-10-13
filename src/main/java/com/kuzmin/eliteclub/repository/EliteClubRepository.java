package com.kuzmin.eliteclub.repository;

import com.kuzmin.eliteclub.domain.EliteClub;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EliteClubRepository extends PagingAndSortingRepository<EliteClub, Long> {
    Page<EliteClub> findAllByClubNameContainingIgnoreCase(@Param("searchTerm") String searchTerm, Pageable pageable);
}
