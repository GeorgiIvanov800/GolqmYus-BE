package org.golqmyus.service;

import org.golqmyus.model.dto.QuestionDTO;
import org.golqmyus.model.entity.QuestionEntity;

import java.util.List;

public interface QuestionService {

    List<QuestionDTO> getRandomQuestions();
    QuestionDTO getOneQuestion();
}
