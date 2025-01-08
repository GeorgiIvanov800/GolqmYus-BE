package org.golqmyus.repository;

import org.golqmyus.model.dto.AlbumDTO;
import org.golqmyus.model.dto.AlbumDTOId;
import org.golqmyus.model.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {

//    @Query("SELECT new org.golqmyus.model.dto.AlbumDTO" +
//            "(a.title, a.releaseDate, a.genre, a.description, a.imageUrl) " +
//            "FROM AlbumEntity a")
//    List<AlbumDTO> findAllAlbumDto();

//    @Query("SELECT new org.golqmyus.model.dto.AlbumDTO" +
//            "(a.id ,a.title, a.releaseDate, a.genre, a.description, a.imageUrl) " +
//            "FROM AlbumEntity a WHERE a.group.id = 1")
//    List<AlbumDTO> findAllAlbumsForGroup();

    @Query("SELECT new org.golqmyus.model.dto.AlbumDTO (CAST(a.id as string ), a.title," +
            "a.releaseDate, a.genre,a.description, a.imageUrl) from AlbumEntity a where a.group.id = 1")
    List<AlbumDTO> findAllAlbumsForGroup();

    AlbumDTOId findAlbumById(Long id);
}
