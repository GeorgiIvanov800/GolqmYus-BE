package org.golqmyus.service.impl;

import org.golqmyus.model.dto.AlbumDTO;
import org.golqmyus.repository.AlbumRepository;
import org.golqmyus.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<AlbumDTO> getAllAlbums() {
        return albumRepository.findAllAlbumDto();
    }
}
