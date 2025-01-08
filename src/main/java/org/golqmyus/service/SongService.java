package org.golqmyus.service;

import org.golqmyus.model.dto.SongDTO;


import java.util.List;

public interface SongService {
    List<SongDTO> findSongsByAlbumId(Long albumId);
}
