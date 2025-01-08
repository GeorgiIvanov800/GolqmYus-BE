package org.golqmyus.web;

import org.golqmyus.service.SongService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/songs")
    public ResponseEntity<?> getAllSongsByAlbum(@RequestParam Long albumId) {
        return ResponseEntity.ok(songService.findSongsByAlbumId(albumId));
    }
}
