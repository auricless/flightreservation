package com.bharath.flightreservation.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharath.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	List<Flight> findFlights(String from, String to, Date departureDate);

}
