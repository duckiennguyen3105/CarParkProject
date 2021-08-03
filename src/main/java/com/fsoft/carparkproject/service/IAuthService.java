package com.fsoft.carparkproject.service;

import com.fsoft.carparkproject.dto.LoginDTO;

public interface IAuthService {
    void login(LoginDTO loginDTO);
}
