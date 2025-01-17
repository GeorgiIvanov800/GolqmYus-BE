package org.golqmyus.repository;

import org.golqmyus.model.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {

    @Query("SELECT q from QuestionEntity q ORDER BY RANDOM() LIMIT 4")
    List<QuestionEntity> findRandomQuestions();
}
