package org.golqmyus.model.dto;

import java.time.LocalDate;

public record AlbumDTOId(
        Long id,
        String title,
        LocalDate releaseDate,
        String genre,
        String description,
        String imageUrl

) {
}

