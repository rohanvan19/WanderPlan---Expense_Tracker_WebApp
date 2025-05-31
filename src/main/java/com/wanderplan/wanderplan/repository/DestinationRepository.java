package com.wanderplan.wanderplan.repository;

import com.wanderplan.wanderplan.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
    List<Destination> findByUserUserId(Long userId);
}
