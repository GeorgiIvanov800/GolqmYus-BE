package org.golqmyus.model.entity;

import jakarta.persistence.*;
//TODO after the lyrics are timestamped use this class for the lyrics and for the quiz question generator
@Entity
@Table(name = "lyrics")
public class LyricsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "song_id", nullable = false)
    private SongEntity song;

    @Column(nullable = false)
    private int lineNumber; // Line number for ordering

    @Column(nullable = false, length = 1000)
    private String lineText; //Text of the lyrics line

    @Column(nullable = false)
    private Double startTime; //Timestamp when this line starts in seconds

    @Column(nullable = false)
    private Double endTime; // Timestamp when this line ends in seconds

    public LyricsEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SongEntity getSong() {
        return song;
    }

    public void setSong(SongEntity song) {
        this.song = song;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getLineText() {
        return lineText;
    }

    public void setLineText(String lineText) {
        this.lineText = lineText;
    }

    public Double getStartTime() {
        return startTime;
    }

    public void setStartTime(Double startTime) {
        this.startTime = startTime;
    }

    public Double getEndTime() {
        return endTime;
    }

    public void setEndTime(Double endTime) {
        this.endTime = endTime;
    }
}
