package com.transactional.demo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transactional.exceptions.InsufficentFundInAccountException;

@Service
public class FlightBookingService {

	@Autowired
	private FlightPassengerRepository flightPassengerRepository;

	@Autowired
	private FlightPaymentRepository flightPaymentRepository;

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = InsufficentFundInAccountException.class )
	public FlightBookingAckResponseDto bookFlightTicket(FlightBookingRequestDto flightBookingRequestDto) {
			FlightPassengerEntity flightPassengerEntity = flightBookingRequestDto.getFlightPassengerEntity();
			flightPassengerRepository.save(flightPassengerEntity);
			
			FlightPaymentEntity flightPaymentEntity = flightBookingRequestDto.getFlightPaymentEntity();

			FlightPaymentUtils.validateCreditLimit(flightPaymentEntity.getAccountno(), flightPassengerEntity.getFair());
						
			
			flightPaymentEntity.setPassengerid(flightPassengerEntity.getId());
			flightPaymentEntity.setAmount(flightPassengerEntity.getFair());
			flightPaymentRepository.save(flightPaymentEntity);
			
			return new FlightBookingAckResponseDto("SUCCESS", UUID.randomUUID().toString(), flightPassengerEntity.getFair(), flightPassengerEntity);
		
	}
}
