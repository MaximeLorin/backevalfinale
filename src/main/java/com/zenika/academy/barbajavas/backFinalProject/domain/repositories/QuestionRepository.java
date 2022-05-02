package com.zenika.academy.barbajavas.backFinalProject.domain.repositories;

import com.zenika.academy.barbajavas.backFinalProject.domain.model.questions.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, String> {
    @Query(nativeQuery = true,value = "SELECT * FROM questions ORDER BY question_date")
    List<Question> findAndOrdersArticles();

    @Query(nativeQuery = true, value = "SELECT * FROM questions a WHERE SIMILARITY(title,?1) > 0.2")
    List<Question> findByTitlePart(String title);
}
