package com.zenika.academy.barbajavas.backFinalProject.domain.repositories;

import com.zenika.academy.barbajavas.backFinalProject.domain.model.questions.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, String> {
    @Query(nativeQuery = true,value = "SELECT * FROM questions ORDER BY question_date DESC")
    List<Question> findAndOrdersArticles();

    @Query(nativeQuery = true, value = "SELECT * FROM questions a WHERE SIMILARITY(title,?1) > 0.2")
    List<Question> findByTitlePart(String title);


    List<Question> findByLanguageIs(@Param("language") String language);

    List<Question> findByUserId(String user_id);

    @Query(nativeQuery = true, value = "SELECT * FROM questions WHERE NOT EXISTS (SELECT * FROM answers WHERE question_id = questions.id)")
    List<Question> findWhereNoAnswer();


}
