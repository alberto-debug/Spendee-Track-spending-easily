package com.example.loginauthapi.validation;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidationService {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&.])[A-Za-z\\d@$!%*?&.]{8,}$");

    public void validateEmail(String email) throws ValidationException {
        if (email == null || email.isEmpty()) {
            throw new ValidationException("Email cannot be null or empty");
        }

        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new ValidationException("Invalid email format");
        }
    }

    public void validatePassword(String password) throws ValidationException {
        if (password == null || password.isEmpty()) {
            throw new ValidationException("Password cannot be null or empty");
        }

        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new ValidationException(
                    "Password must be at least 8 characters long, include an uppercase letter, a lowercase letter, a digit, and a special character"
            );
        }
    }
}