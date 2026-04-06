package uz.pdp.telegramclone.dto.base;

public record ApiResponse(
    Object data,
    String message
) {
}
