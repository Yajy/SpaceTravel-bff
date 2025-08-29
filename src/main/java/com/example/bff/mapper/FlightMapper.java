package com.example.bff.mapper;

import com.example.bff.dto.flight.*;
import com.example.flight.grpc.*;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {

    public SearchFlightsRequest toGrpc(SearchFlightsRequestDto dto) {
        return SearchFlightsRequest.newBuilder()
                .setSourceName(dto.getSourceName())
                .setDestinationName(dto.getDestinationName())
                .setDepartureDate(dto.getDepartureDate())
                .build();
    }

    public SearchFlightsResponseDto toDto(SearchFlightsResponse response) {
        SearchFlightsResponseDto dto = new SearchFlightsResponseDto();
        dto.setFlights(response.getFlightsList().stream()
                .map(this::toDto)
                .toList());
        return dto;
    }

    public Flight toGrpc(FlightDto dto) {
        return Flight.newBuilder()
                .setId(dto.getId())
                .setFlightName(dto.getFlightName())
                .setSourceName(dto.getSourceName())
                .setDestinationName(dto.getDestinationName())
                .setPrice(dto.getPrice())
                .setTotalSeats(dto.getTotalSeats())
                .setAvailableSeats(dto.getAvailableSeats())
                .setSeatType(dto.getSeatType())
                .setDepartureDate(dto.getDepartureDate())
                .setArrivalDate(dto.getArrivalDate())
                .setDepartureTime(dto.getDepartureTime())
                .setArrivalTime(dto.getArrivalTime())
                .setAvailability(dto.getAvailability())
                .setAdditionalInfo(dto.getAdditionalInfo())
                .setStatus(dto.getStatus())
                .build();
    }

    public FlightDto toDto(Flight flight) {
        FlightDto dto = new FlightDto();
        dto.setId(flight.getId());
        dto.setFlightName(flight.getFlightName());
        dto.setSourceName(flight.getSourceName());
        dto.setDestinationName(flight.getDestinationName());
        dto.setPrice(flight.getPrice());
        dto.setTotalSeats(flight.getTotalSeats());
        dto.setAvailableSeats(flight.getAvailableSeats());
        dto.setSeatType(flight.getSeatType());
        dto.setDepartureDate(flight.getDepartureDate());
        dto.setArrivalDate(flight.getArrivalDate());
        dto.setDepartureTime(flight.getDepartureTime());
        dto.setArrivalTime(flight.getArrivalTime());
        dto.setAvailability(flight.getAvailability());
        dto.setAdditionalInfo(flight.getAdditionalInfo());
        dto.setStatus(flight.getStatus());
        return dto;
    }

    public GetFlightDetailsRequest toGrpc(String flightId) {
        return GetFlightDetailsRequest.newBuilder()
                .setFlightId(flightId)
                .build();
    }
}
