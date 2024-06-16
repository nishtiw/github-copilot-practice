package com.example.flightreservation.controllers;

import com.example.flightreservation.dtos.ReservationRequest;
import com.example.flightreservation.entities.Flight;
import com.example.flightreservation.entities.Reservation;
import com.example.flightreservation.repos.FlightRepository;
import com.example.flightreservation.services.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, Model model) {
        Flight flight = flightRepository.findById(flightId).orElse(null);
        model.addAttribute("flight", flight);
        return "completeReservation"; // Return the name of the Thymeleaf template
    }

    @PostMapping("/completeReservation")
    public String completeReservation(ReservationRequest request, Model model) {
        Reservation reservation = reservationService.bookFlight(request);
        model.addAttribute("msg", "Reservation created successfully and the id is " + reservation.getId());
        model.addAttribute("reservation", reservation);
        return "reservationConfirmation"; // Return the name of the Thymeleaf template
    }
}