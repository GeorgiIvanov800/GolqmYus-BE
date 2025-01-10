package org.golqmyus.model.dto;

public record UserDTO(
        String email,
        String password,
        String firstName,
        String lastName,
        String username,
        String imageUrl
) {
}
