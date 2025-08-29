package com.example.bff.client;

import com.example.bff.dto.LogoutDto;
import com.example.bff.dto.LogoutResponseDto;
import com.example.bff.dto.SigninRequest;
import com.example.bff.dto.SigninResponse;
import com.example.bff.dto.SignupRequest;
import com.example.bff.dto.SignupResponse;
import com.example.bff.mapper.PassengerMapper;
import com.example.demo.grpc.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

@Component
public class PassengerGrpcClient {

    @GrpcClient("passenger")
    private PassengerServiceGrpc.PassengerServiceBlockingStub passengerStub;

    private final PassengerMapper mapper;

    public PassengerGrpcClient(PassengerMapper mapper) {
        this.mapper = mapper;
    }

    public SignupResponse signup(SignupRequest request) {
        CreatePassengerResponse res = passengerStub.createPassenger(mapper.toGrpc(request));
        return mapper.toDto(res);
    }

    public SigninResponse signin(SigninRequest request) {
        AuthenticatePassengerResponse res = passengerStub.authenticatePassenger(mapper.toGrpc(request));
        return mapper.toDto(res);
    }

    public LogoutResponseDto logout(LogoutDto request) {
        LogoutResponse res = passengerStub.logoutPassenger(mapper.toGrpc(request));
        return mapper.toDto(res);
    }
}
