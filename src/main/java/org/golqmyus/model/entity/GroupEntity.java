package org.golqmyus.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "group")
public class GroupEntity extends BaseEntity {

    private String name;

    private LocalDate formation;

    private String genre;

    private String logoUrl;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<ArtistEntity> members;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<AlbumEntity> albums;

    public GroupEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFormation() {
        return formation;
    }

    public void setFormation(LocalDate formation) {
        this.formation = formation;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public List<ArtistEntity> getMembers() {
        return members;
    }

    public void setMembers(List<ArtistEntity> members) {
        this.members = members;
    }

    public List<AlbumEntity> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumEntity> albums) {
        this.albums = albums;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
