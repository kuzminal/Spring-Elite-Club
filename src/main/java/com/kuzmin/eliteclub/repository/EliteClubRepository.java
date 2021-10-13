package com.kuzmin.eliteclub.repository;

import com.kuzmin.eliteclub.domain.EliteClub;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EliteClubRepository extends PagingAndSortingRepository<EliteClub, Long> {
    @Query("SELECT x from EliteClub x WHERE lower(x.clubName) LIKE :searchTerm order by x.clubName asc")
    List<EliteClub> findClubs(@Param("searchTerm") String searchTerm);
}
