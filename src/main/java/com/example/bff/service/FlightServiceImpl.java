package com.example.bff.service;

import com.example.bff.client.FlightGrpcClient;
import com.example.bff.dto.flight.*;
import com.example.bff.mapper.FlightMapper;
import com.example.flight.grpc.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightGrpcClient flightGrpcClient;
    private final FlightMapper flightMapper;

    @Override
    public SearchFlightsResponseDto searchFlights(SearchFlightsRequestDto request) {
        SearchFlightsRequest grpcRequest = flightMapper.toGrpc(request);
        SearchFlightsResponse grpcResponse = flightGrpcClient.searchFlights(grpcRequest);
        return flightMapper.toDto(grpcResponse);
    }

    @Override
    public FlightDto getFlightDetails(String flightId) {
        GetFlightDetailsRequest request = GetFlightDetailsRequest.newBuilder()
            .setFlightId(flightId)
            .build();
        var response = flightGrpcClient.getFlightDetails(request);
        return flightMapper.toDto(response.getFlight());
    }

    @Override
    public FlightDto createFlight(FlightDto flight) {
        CreateFlightRequest request = CreateFlightRequest.newBuilder()
            .setFlight(flightMapper.toGrpc(flight))
            .build();
        var response = flightGrpcClient.createFlight(request);
        return flightMapper.toDto(response.getFlight());
    }

    @Override
    public FlightDto updateFlight(String flightId, FlightDto flight) {
        UpdateFlightRequest request = UpdateFlightRequest.newBuilder()
            .setFlightId(flightId)
            .setFlight(flightMapper.toGrpc(flight))
            .build();
        var response = flightGrpcClient.updateFlight(request);
        return flightMapper.toDto(response.getFlight());
    }

    @Override
    public void deleteFlight(String flightId) {
        DeleteFlightRequest request = DeleteFlightRequest.newBuilder()
            .setFlightId(flightId)
            .build();
        flightGrpcClient.deleteFlight(request);
    }

}
