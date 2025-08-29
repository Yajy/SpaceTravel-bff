package com.example.bff.dto.flight;

import lombok.Data;

@Data
public class FlightDto {
    private String id;
    private String flightName;
    private String sourceName;
    private String destinationName;
    private double price;
    private int totalSeats;
    private int availableSeats;
    private String seatType;
    private String departureDate;
    private String arrivalDate;
    private String departureTime;
    private String arrivalTime;
    private String availability;
    private String additionalInfo;
    private int status;
    private String createTime;
    private String updateTime;
}
