package org.golqmyus.model.dto;

import java.util.Map;

public record ArtistDTO(
    Long id,
    String nickname,
    String firstName,
    String lastName,
    String bornDate,
    String biography,
    String pictureUrl,
    String city,
    Map<String, String> socialMediaLinks
) {}
