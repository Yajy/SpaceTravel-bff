package com.example.bff.dto.flight;

import lombok.Data;

@Data
public class SearchFlightsRequestDto {
    private String sourceName;
    private String destinationName;
    private String departureDate;
}
