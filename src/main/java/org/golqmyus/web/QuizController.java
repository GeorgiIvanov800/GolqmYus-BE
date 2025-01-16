package org.golqmyus.web;

import org.golqmyus.model.dto.QuestionDTO;
import org.golqmyus.model.entity.QuestionEntity;
import org.golqmyus.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/quiz")
public class QuizController {

    private final QuestionService questionService;

    public QuizController(QuestionService questionService) {
        this.questionService = questionService;
    }


//    @GetMapping("/questions")
//    public ResponseEntity<QuestionDTO> getQuestions() {
//        QuestionDTO question = questionService.getOneQuestion();
//        return new ResponseEntity<>(question, HttpStatus.OK);
//    }

    @GetMapping("/questions")
    public ResponseEntity<List<QuestionDTO>> getRandomQuestions() {
        List<QuestionDTO> questions = questionService.getRandomQuestions();
        return ResponseEntity.ok(questions);
    }
}
