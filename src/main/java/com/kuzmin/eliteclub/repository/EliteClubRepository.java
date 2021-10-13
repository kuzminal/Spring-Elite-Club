package com.kuzmin.eliteclub.repository;

import com.kuzmin.eliteclub.domain.EliteClub;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EliteClubRepository extends PagingAndSortingRepository<EliteClub, Long> {
    Page<EliteClub> findAllByClubNameContainingIgnoreCaseAndRatingGreaterThanOrderByRatingDesc(String searchTerm, short rating, Pageable pageable);
}
