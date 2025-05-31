package com.wanderplan.wanderplan.repository;

import com.wanderplan.wanderplan.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
