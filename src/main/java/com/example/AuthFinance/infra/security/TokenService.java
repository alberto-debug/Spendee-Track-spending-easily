package com.example.AuthFinance.infra.security;

import com.example.AuthFinance.domain.user.User;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private String secret;

    public String generateToken(User user){
        
    }
}
