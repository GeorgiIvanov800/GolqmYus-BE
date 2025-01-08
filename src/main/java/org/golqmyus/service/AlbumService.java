package org.golqmyus.service;

import org.golqmyus.model.dto.AlbumDTO;
import org.golqmyus.model.dto.AlbumDTOId;

import java.util.List;

public interface AlbumService {

    List<AlbumDTO> getAllAlbums();
    AlbumDTOId getAlbumById(Long id);
}
