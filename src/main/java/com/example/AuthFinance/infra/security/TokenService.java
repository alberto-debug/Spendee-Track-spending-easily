package com.example.AuthFinance.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.AuthFinance.domain.user.User;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.ExecutionException;


@Service
public class TokenService {
    private String Token;

    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(Token);
            String token = JWT.create()
                    .withIssuer("login-auth-api")
                    .withSubject(user.getEmail())
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);
            return token;

        }catch (JWTCreationException exception){
            throw new RuntimeException("Error while Authenticating");
        }
    }

    public String validateToken(User user){

    }


    private Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
