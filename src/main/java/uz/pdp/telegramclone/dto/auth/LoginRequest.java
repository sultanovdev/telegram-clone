package uz.pdp.telegramclone.dto.auth;

public record LoginRequest(
        String email,
        String password
) {
}
