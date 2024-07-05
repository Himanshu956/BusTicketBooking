package com.wipro.bus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.bus.entities.BusRoute;

public interface BusRouteRepository extends JpaRepository<BusRoute, Long> {
    // Custom query methods (if any) can be added here
	List<BusRoute> findByOriginAndDestination(String origin, String destination);
}