package com.example.bff.service;

import com.example.bff.dto.*;

public interface AuthService {
    SignupResponse signup(SignupRequest req);
    SigninResponse signin(SigninRequest req);
    LogoutResponseDto logout(LogoutDto req);
}
