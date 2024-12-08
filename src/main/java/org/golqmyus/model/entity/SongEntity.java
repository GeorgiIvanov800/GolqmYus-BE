package org.golqmyus.model.entity;

import jakarta.persistence.*;

import java.time.Duration;
import java.util.List;

@Entity
@Table(name = "songs")
public class SongEntity extends BaseEntity {

    private String title;

    private Duration duration;

    @ManyToOne()
    private AlbumEntity album;

    @ManyToMany(mappedBy = "songs")
    private List<ArtistEntity> artist;

    //TODO timestamped the lyrics in the future to remove the fullLyricsText column
    @OneToMany
    @JoinColumn(name = "artist_id", nullable = false)
    private List<LyricsEntity> lyrics;

    @Column(nullable = true, length = 10000) // lyrics text
    private String fullLyricsText;

    public SongEntity() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public AlbumEntity getAlbum() {
        return album;
    }

    public void setAlbum(AlbumEntity album) {
        this.album = album;
    }

    public List<ArtistEntity> getArtist() {
        return artist;
    }

    public void setArtist(List<ArtistEntity> artist) {
        this.artist = artist;
    }

    public List<LyricsEntity> getLyrics() {
        return lyrics;
    }

    public void setLyrics(List<LyricsEntity> lyrics) {
        this.lyrics = lyrics;
    }

    public String getFullLyricsText() {
        return fullLyricsText;
    }

    public void setFullLyricsText(String fullLyricsText) {
        this.fullLyricsText = fullLyricsText;
    }
}
