package com.transactional.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightPaymentRepository extends JpaRepository<FlightPaymentEntity, String> {

}
