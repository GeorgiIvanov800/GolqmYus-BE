package org.golqmyus.model.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "artist")
public class ArtistEntity extends BaseEntity {

    private String nickname;

    private String firstName;

    private String lastName;

    private String bornDate;

    @Column(columnDefinition = "TEXT")
    private String biography;

    private String pictureURL;

    private String country;

    private String city;
    @ManyToMany
    @JoinTable(
            name = "songs_artist",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private List<SongEntity> songs;

    @ElementCollection
    @CollectionTable(name = "artist_social_media", joinColumns = @JoinColumn(name = "artist_id"))
    @MapKeyColumn(name = "platform")
    @Column(name = "link")
    private Map<String, String> socialMediaLinks = new HashMap<>();

    @ManyToOne
    private GroupEntity group;

    @ElementCollection
    @CollectionTable(name = "artist_awards", joinColumns = @JoinColumn(name = "artist_id"))
    @Column(name = "award" , columnDefinition = "TEXT")
    private List<String> awards = new ArrayList<>();

    //Fetching Strategy: By default,
    // @ManyToMany uses FetchType.LAZY. Change it to EAGER if you want related entities to be loaded immediately.
    @ManyToMany(mappedBy = "artists")
    private List<AlbumEntity> albums = new ArrayList<>();

    public ArtistEntity() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public List<SongEntity> getSongs() {
        return songs;
    }

    public void setSongs(List<SongEntity> songs) {
        this.songs = songs;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }

    public List<AlbumEntity> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumEntity> albums) {
        this.albums = albums;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Map<String, String> getSocialMediaLinks() {
        return socialMediaLinks;
    }

    public void setSocialMediaLinks(Map<String, String> socialMediaLinks) {
        this.socialMediaLinks = socialMediaLinks;
    }

    public List<String> getAwards() {
        return awards;
    }

    public void setAwards(List<String> awards) {
        this.awards = awards;
    }
}
