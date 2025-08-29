package com.example.bff.client;

import com.example.flight.grpc.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

@Component
public class FlightGrpcClient {

    @GrpcClient("flight")
    private FlightServiceGrpc.FlightServiceBlockingStub flightStub;

    public SearchFlightsResponse searchFlights(SearchFlightsRequest request) {
        return flightStub.searchFlights(request);
    }

    public GetFlightDetailsResponse getFlightDetails(GetFlightDetailsRequest request) {
        return flightStub.getFlightDetails(request);
    }

    public CreateFlightResponse createFlight(CreateFlightRequest request) {
        return flightStub.createFlight(request);
    }

    public UpdateFlightResponse updateFlight(UpdateFlightRequest request) {
        return flightStub.updateFlight(request);
    }

    public void deleteFlight(DeleteFlightRequest request) {
        flightStub.deleteFlight(request);
    }
}
