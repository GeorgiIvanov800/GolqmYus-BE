package org.golqmyus.service.impl;

import org.golqmyus.model.dto.OptionDTO;
import org.golqmyus.model.dto.QuestionDTO;
import org.golqmyus.model.entity.QuestionEntity;
import org.golqmyus.repository.QuestionRepository;
import org.golqmyus.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<QuestionDTO> getRandomQuestions() {

        List<QuestionEntity> randomQuestions = questionRepository.findRandomQuestions();

        return randomQuestions.stream()
                .map(oneQuestion -> {
                    List<OptionDTO> optionDTOS = oneQuestion.getOptions().stream()
                            .map(option -> new OptionDTO(option.getId(), option.getOptionText()))
                            .toList();
                    return new QuestionDTO(
                            oneQuestion.getId(),
                            oneQuestion.getQuestion(),
                            oneQuestion.getText(),
                            oneQuestion.getCorrectOption(),
                            oneQuestion.getTimeLimit(),
                            optionDTOS
                    );
                })
                .toList();

    }

    @Override
    public QuestionDTO getOneQuestion() {
        List<QuestionEntity> randomQuestions = questionRepository.findRandomQuestions();

        if (!randomQuestions.isEmpty()) {
            QuestionEntity oneQuestion = randomQuestions.getFirst();

            List<OptionDTO> optionDTOs = oneQuestion.getOptions().stream()
                    .map(option -> new OptionDTO(option.getId(),option.getOptionText()))
                    .toList();

            return new QuestionDTO(
                    oneQuestion.getId(),
                    oneQuestion.getQuestion(),
                    oneQuestion.getText(),
                    oneQuestion.getCorrectOption(),
                    oneQuestion.getTimeLimit(),
                    optionDTOs
            );
        }
        return null;
    }
}
