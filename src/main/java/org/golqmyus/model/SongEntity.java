package org.golqmyus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
}
