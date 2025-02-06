package com.example.AuthFinance.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AuthFinance.repository.UserRepository;

@Service
public class CustomUserDetailsService {

  @Autowired
  private UserRepository userRepository;
}
