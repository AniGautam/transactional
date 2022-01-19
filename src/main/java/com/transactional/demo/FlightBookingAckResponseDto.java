package com.transactional.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingAckResponseDto {
	
	private String status;
	private String pnrno;
	private double totalfare;
	private FlightPassengerEntity flightPassengerEntity; 
}
