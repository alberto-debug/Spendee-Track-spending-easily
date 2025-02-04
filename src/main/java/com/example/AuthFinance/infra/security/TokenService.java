package com.example.AuthFinance.infra.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.AuthFinance.domain.user.User;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private String secret;

    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while Authenticating");
        }


    }
}
