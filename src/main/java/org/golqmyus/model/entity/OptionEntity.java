package org.golqmyus.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "options")
public class OptionEntity extends BaseEntity{
    @Column(nullable = false)
    private String optionText;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private QuestionEntity question;

    public OptionEntity() {
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }
}
