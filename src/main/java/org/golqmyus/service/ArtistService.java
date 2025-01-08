package org.golqmyus.service;


import org.golqmyus.model.dto.ArtistDTO;

import java.util.List;
import java.util.Optional;


public interface ArtistService {
    Optional<ArtistDTO> findById(Long id);

    List<ArtistDTO> getAllArtists();
}
