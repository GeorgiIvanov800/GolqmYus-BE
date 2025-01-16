package org.golqmyus.model.dto;

public record LoginResponse(
        String token,
        String username,
        String imgUrl
) {
}
