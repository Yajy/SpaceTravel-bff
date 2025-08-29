package com.example.bff.service;

import com.example.bff.dto.flight.*;

public interface FlightService {
    SearchFlightsResponseDto searchFlights(SearchFlightsRequestDto request);
    FlightDto getFlightDetails(String flightId);
    FlightDto createFlight(FlightDto flight);
    FlightDto updateFlight(String flightId, FlightDto flight);
    void deleteFlight(String flightId);
}
