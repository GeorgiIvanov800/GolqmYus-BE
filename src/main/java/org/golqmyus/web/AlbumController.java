package org.golqmyus.web;

import org.golqmyus.service.AlbumService;
import org.golqmyus.service.SongService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {
    private final SongService songService;
    private final AlbumService albumService;

    public AlbumController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAlbumsOnlyGroupAlbums() {
        return ResponseEntity.ok(albumService.getAllAlbums());
    }

    @GetMapping("/{albumId}")
    public ResponseEntity<?> getAlbumById(@PathVariable Long albumId) {
        return ResponseEntity.ok(albumService.getAlbumById(albumId));
    }

    @GetMapping("/{albumId}/tracks")
    public ResponseEntity<?> getAllSongsByAlbum(@PathVariable Long albumId) {
        return ResponseEntity.ok(songService.findSongsByAlbumId(albumId));
    }
}
