package uz.pdp.telegramclone.dto.auth;

import uz.pdp.telegramclone.enums.UserStatus;

public record RegisterRequest(
        String userName,
        String email,
        String password,
        UserStatus status
) {
}
