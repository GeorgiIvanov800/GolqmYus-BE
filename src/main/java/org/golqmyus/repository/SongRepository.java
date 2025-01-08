package org.golqmyus.repository;

import org.golqmyus.model.dto.SongDTO;
import org.golqmyus.model.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<SongEntity, Long> {

    List<SongDTO> findByAlbumId(Long albumId);
}
