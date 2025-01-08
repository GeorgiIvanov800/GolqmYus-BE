package org.golqmyus.model.dto;
import java.time.LocalDate;

public record AlbumDTO(
        String id,
        String title,
        LocalDate releaseDate,
        String genre,
        String description,
        String imageUrl

) {
}
