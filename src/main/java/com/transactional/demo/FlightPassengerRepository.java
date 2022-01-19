package com.transactional.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightPassengerRepository extends JpaRepository<FlightPassengerEntity, Long>{

}
