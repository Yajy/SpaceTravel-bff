package com.example.bff.controller;

import com.example.bff.dto.flight.*;
import com.example.bff.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/search")
    public ResponseEntity<SearchFlightsResponseDto> searchFlights(@RequestBody SearchFlightsRequestDto request) {
        return ResponseEntity.ok(flightService.searchFlights(request));
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<FlightDto> getFlightDetails(@PathVariable String flightId) {
        return ResponseEntity.ok(flightService.getFlightDetails(flightId));
    }

    @PostMapping
    public ResponseEntity<FlightDto> createFlight(@RequestBody FlightDto request) {
        return ResponseEntity.ok(flightService.createFlight(request));
    }

    @PutMapping("/{flightId}")
    public ResponseEntity<FlightDto> updateFlight(@PathVariable String flightId, @RequestBody FlightDto request) {
        return ResponseEntity.ok(flightService.updateFlight(flightId, request));
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable String flightId) {
        flightService.deleteFlight(flightId);
        return ResponseEntity.ok().build();
    }
}
