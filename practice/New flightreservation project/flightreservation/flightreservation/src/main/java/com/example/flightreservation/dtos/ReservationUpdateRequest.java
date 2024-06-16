package com.example.flightreservation.dtos;

import lombok.Data;

@Data
public class ReservationUpdateRequest {

    private Long id;
    private boolean checkedIn;
    private int numberOfBags;

}
