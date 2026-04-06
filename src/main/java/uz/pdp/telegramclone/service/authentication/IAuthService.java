package uz.pdp.telegramclone.service.authentication;

import uz.pdp.telegramclone.dto.auth.LoginRequest;
import uz.pdp.telegramclone.dto.auth.RegisterRequest;
import uz.pdp.telegramclone.dto.base.ApiResponse;

public interface IAuthService {
    ApiResponse register(RegisterRequest request);
    ApiResponse login(LoginRequest request);
}
