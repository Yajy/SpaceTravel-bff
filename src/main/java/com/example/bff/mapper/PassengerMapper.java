package com.example.bff.mapper;

import com.example.bff.dto.*;
import com.example.demo.grpc.*;
import org.springframework.stereotype.Component;

@Component
public class PassengerMapper {

    public CreatePassengerRequest toGrpc(SignupRequest dto) {
        return CreatePassengerRequest.newBuilder()
                .setName(dto.getName())
                .setEmail(dto.getEmail())
                .setPassword(dto.getPassword())
                .setPhone(dto.getPhone())
                .setAddress(dto.getAddress())
                .setAge(dto.getAge())
                .build();
    }

    public AuthenticatePassengerRequest toGrpc(SigninRequest dto) {
        return AuthenticatePassengerRequest.newBuilder()
                .setEmail(dto.getEmail())
                .setPassword(dto.getPassword())
                .build();
    }

    public LogoutRequest toGrpc(LogoutDto dto) {
        return LogoutRequest.newBuilder()
                .setEmail(dto.getEmail())
                .build();
    }

    public SignupResponse toDto(CreatePassengerResponse grpc) {
        return new SignupResponse(grpc.getSuccess(), grpc.getErrorMessage());
    }

    public SigninResponse toDto(AuthenticatePassengerResponse grpcRes) {
        return new SigninResponse(grpcRes.getSuccess(), grpcRes.getErrorMessage());
    }

    public LogoutResponseDto toDto(LogoutResponse grpcRes) {
        return new LogoutResponseDto(grpcRes.getSuccess(), grpcRes.getErrorMessage());
    }
}
