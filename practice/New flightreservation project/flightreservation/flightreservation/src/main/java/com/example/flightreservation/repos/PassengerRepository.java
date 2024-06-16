package com.example.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.flightreservation.entities.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    // You can define custom queries here if needed
}