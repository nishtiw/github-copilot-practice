package com.example.flightreservation.controllers;

import com.example.flightreservation.dtos.ReservationUpdateRequest;
import com.example.flightreservation.entities.Reservation;
import com.example.flightreservation.repos.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
@CrossOrigin
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable("id") Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
        Reservation reservation = reservationRepository.findById(request.getId()).get();
        reservation.setId(request.getId());
        reservation.setCheckedIn(request.isCheckedIn());
        reservation.setNumberOfBags(request.getNumberOfBags());
        return reservationRepository.save(reservation);
    }
}