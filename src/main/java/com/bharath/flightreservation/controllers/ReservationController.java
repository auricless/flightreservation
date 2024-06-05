package com.bharath.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bharath.flightreservation.dtos.ReservationRequest;
import com.bharath.flightreservation.entities.Flight;
import com.bharath.flightreservation.entities.Reservation;
import com.bharath.flightreservation.repos.FlightRepository;
import com.bharath.flightreservation.repos.ReservationRepository;
import com.bharath.flightreservation.services.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationRepository repository;
	
	@Autowired
	ReservationService service;
	
	@GetMapping("showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") long id, ModelMap modelMap) {
		Flight flight = flightRepository.findById(id).get();
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}

	@PostMapping("completeReservation")
	public String completeReservation(@ModelAttribute ReservationRequest request, ModelMap modelMap) {
		Reservation reservation = service.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created succesfully and the reservation id " + reservation.getId());
		return "reservationConfirmation";
	}
}
