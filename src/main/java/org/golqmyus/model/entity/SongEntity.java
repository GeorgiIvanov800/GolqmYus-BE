package org.golqmyus.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

@Entity
@Table(name = "songs")
public class SongEntity extends BaseEntity {

    private String title;

    private String duration;

    @ManyToOne()
    private AlbumEntity album;

    @ManyToMany(mappedBy = "songs")
    private List<ArtistEntity> artist;

    //TODO timestamped the lyrics in the future to remove the fullLyricsText column
    @OneToMany
    @JoinColumn(name = "artist_id", nullable = false)
    private List<LyricsEntity> lyrics;

    @Column(columnDefinition = "TEXT")
    private String fullLyricsText;

    private String songUrl;

    public SongEntity() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
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

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }
}
