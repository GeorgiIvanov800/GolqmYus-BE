package org.golqmyus.model.entity;


import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "reviews")
public class ReviewEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "album_id", nullable = false)
    private AlbumEntity album;

    @Column(nullable = false, length = 500)
    private String reviewText;

    @Column(nullable = false)
    private Instant createdAt;

    public ReviewEntity() {
        this.createdAt = Instant.now(); // Automatically set to current time when created
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public AlbumEntity getAlbum() {
        return album;
    }

    public void setAlbum(AlbumEntity album) {
        this.album = album;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
