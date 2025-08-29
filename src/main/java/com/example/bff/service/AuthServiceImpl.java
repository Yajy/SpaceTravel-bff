package com.example.bff.service;

import com.example.bff.client.PassengerGrpcClient;
import com.example.bff.dto.*;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final PassengerGrpcClient passengerClient;

    public AuthServiceImpl(PassengerGrpcClient passengerClient) {
        this.passengerClient = passengerClient;
    }

    @Override
    public SignupResponse signup(SignupRequest req) {
        return passengerClient.signup(req);
    }

    @Override
    public SigninResponse signin(SigninRequest req) {
        return passengerClient.signin(req);
    }

    @Override
    public LogoutResponseDto logout(LogoutDto req) {
        return passengerClient.logout(req);
    }
}
