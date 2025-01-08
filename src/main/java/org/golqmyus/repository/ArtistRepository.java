package org.golqmyus.repository;

import org.golqmyus.model.dto.ArtistDTO;
import org.golqmyus.model.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {

    @Override
    List<ArtistEntity> findAll();

    ArtistEntity findById(long id);
}
