package com.fsoft.carparkproject.service.Impl;

import com.fsoft.carparkproject.dto.LoginDTO;
import com.fsoft.carparkproject.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class AuthService implements IAuthService {
    @Autowired
    AuthenticationManager authenticationManager;
    @Override
    public void login(LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getAccount(),loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

    }
}
