package com.bharath.flightreservation.services;

import com.bharath.flightreservation.dtos.ReservationRequest;
import com.bharath.flightreservation.entities.Reservation;

public interface ReservationService {
	
	Reservation bookFlight(ReservationRequest request);
	
}
