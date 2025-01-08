package org.golqmyus.service.impl;

import org.golqmyus.model.dto.SongDTO;
import org.golqmyus.model.entity.SongEntity;
import org.golqmyus.repository.SongRepository;
import org.golqmyus.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<SongDTO> findSongsByAlbumId(Long albumId) {
        return songRepository.findByAlbumId(albumId);
    }
}
