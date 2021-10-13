package com.kuzmin.eliteclub.repository;

import com.kuzmin.eliteclub.domain.EliteClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EliteClubRepository extends JpaRepository<EliteClub, Long> {
}
