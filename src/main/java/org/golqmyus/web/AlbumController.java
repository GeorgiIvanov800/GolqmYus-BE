package org.golqmyus.web;

import org.golqmyus.service.AlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllAlbums() {

        return ResponseEntity.ok(albumService.getAllAlbums());
    }

}
