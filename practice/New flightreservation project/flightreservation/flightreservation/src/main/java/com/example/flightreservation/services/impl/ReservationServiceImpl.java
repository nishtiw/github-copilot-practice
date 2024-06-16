package com.example.flightreservation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightreservation.dtos.ReservationRequest;
import com.example.flightreservation.entities.Flight;
import com.example.flightreservation.entities.Passenger;
import com.example.flightreservation.entities.Reservation;
import com.example.flightreservation.repos.FlightRepository;
import com.example.flightreservation.repos.PassengerRepository;
import com.example.flightreservation.repos.ReservationRepository;
import com.example.flightreservation.services.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation bookFlight(ReservationRequest request) {
        
        Flight flight = flightRepository.findById(request.getFlightId()).get();
        
        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getFirstName());
        passenger.setLastName(request.getLastName());
        passenger.setEmail(request.getEmail());
        passenger.setPhone(request.getPhone());

        Passenger savedPassenger = passengerRepository.save(passenger);
        
        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        Reservation savedReservation = reservationRepository.save(reservation);

        return savedReservation;
    }
    
}
