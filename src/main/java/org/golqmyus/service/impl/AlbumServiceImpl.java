package org.golqmyus.service.impl;

import org.golqmyus.model.dto.AlbumDTO;
import org.golqmyus.model.dto.AlbumDTOId;
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
        return albumRepository.findAllAlbumsForGroup();
    }

    @Override
    public AlbumDTOId getAlbumById(Long id) {
        return albumRepository.findAlbumById(id);
    }

    @Override
    public List<AlbumDTOId> getAlbumByArtist(Long id) {

        return albumRepository.findAlbumByArtistsId(id);
    }
}
