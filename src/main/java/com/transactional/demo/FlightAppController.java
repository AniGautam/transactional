package com.transactional.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightAppController {
	
	@Autowired
	private FlightBookingService flightBookingService;
	
	@PostMapping("/bookFlightTicket")
	public FlightBookingAckResponseDto bookFlightTicket(@RequestBody FlightBookingRequestDto request) {
		return flightBookingService.bookFlightTicket(request);
	}
}
/*
 * { "flightPassengerEntity":{ "name":"Aniket",
 * "email":"aniketgautam1985@gmail.com", "source":"Pune", "destinaton":"JBP",
 * "traveldate":"10-01-2022", "fair":18000 }, "flightPaymentEntity":{
 * "accountno":"accno1", "cardtype":"sbidebit" } }
 */