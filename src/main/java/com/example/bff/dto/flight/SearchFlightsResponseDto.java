package com.example.bff.dto.flight;

import lombok.Data;
import java.util.List;

@Data
public class SearchFlightsResponseDto {
    private List<FlightDto> flights;
}
