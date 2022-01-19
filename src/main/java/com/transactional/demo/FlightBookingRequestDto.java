package com.transactional.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequestDto {
	
	private FlightPassengerEntity flightPassengerEntity;
	
	private FlightPaymentEntity flightPaymentEntity;
}
