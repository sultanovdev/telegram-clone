package uz.pdp.telegramclone.service.authentication;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.telegramclone.dto.auth.LoginRequest;
import uz.pdp.telegramclone.dto.auth.RegisterRequest;
import uz.pdp.telegramclone.dto.base.ApiResponse;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService{
    @Override
    public ApiResponse register(RegisterRequest request) {


        return null;
    }

    @Override
    public ApiResponse login(LoginRequest request) {
        return null;
    }

    private String validatePassword(String password) {
        if (password == null || password.length() < 8)
            return "Password must be at least 8 characters long";
        if (!password.matches(".*[A-Z].*"))
            return "Password must contain at least one uppercase letter";
        if (!password.matches(".*[a-z].*"))
            return "Password must contain at least one lowercase letter";
        if (!password.matches(".*[0-9].*"))
            return "Password must contain at least one number";
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*"))
            return "Password must contain at least one special character";
        return null;
    }

    private String validateEmail(String email) {
        if (email == null || email.trim().isEmpty())
            return "Email must not be empty";
        if (email.contains(" "))
            return "Email must not contain spaces";

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (!email.matches(emailRegex))
            return "Email format is invalid";
        return null;
    }

}