package org.golqmyus.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "questions")
public class QuestionEntity extends BaseEntity {

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private String correctOption;

    @Column(nullable= false)
    private int timeLimit;

    private String songReference;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OptionEntity> options;

    public QuestionEntity() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getSongReference() {
        return songReference;
    }

    public void setSongReference(String songReference) {
        this.songReference = songReference;
    }

    public List<OptionEntity> getOptions() {
        return options;
    }

    public void setOptions(List<OptionEntity> options) {
        this.options = options;
    }
}
