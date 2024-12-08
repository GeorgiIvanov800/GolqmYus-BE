package org.golqmyus.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "albums")
public class AlbumEntity extends BaseEntity {

    private String title;

    private LocalDate releaseDate;

    private String genre;

    private String description;

    private String imageUrl;


    @ManyToMany
    @JoinTable(
            name = "album_artist",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name= "artist_id")
    )
    private List<ArtistEntity> artists;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<SongEntity> tacklist;

    @ManyToOne
    private GroupEntity group;


    public AlbumEntity() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<ArtistEntity> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistEntity> artists) {
        this.artists = artists;
    }

    public List<SongEntity> getTacklist() {
        return tacklist;
    }

    public void setTacklist(List<SongEntity> tacklist) {
        this.tacklist = tacklist;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }
}
