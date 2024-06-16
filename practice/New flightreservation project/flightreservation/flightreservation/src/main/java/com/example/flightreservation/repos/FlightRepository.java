package com.example.flightreservation.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.flightreservation.entities.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("from Flight where departureCity=:from and arrivalCity=:to and dateOfDeparture=:departureDate")
    List<Flight> findFlights(@Param("from") String from, @Param("to") String to, @Param("departureDate") Date departureDate);
    // You can define custom queries here if needed
}