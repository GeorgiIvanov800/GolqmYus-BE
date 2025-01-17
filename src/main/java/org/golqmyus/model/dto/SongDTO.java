package org.golqmyus.model.dto;

public record SongDTO(
        Long id,
        String title,
        String duration,
        String fullLyricsText,
        String songUrl

){}
