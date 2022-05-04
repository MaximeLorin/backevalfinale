package com.zenika.academy.barbajavas.backFinalProject.domain.repositories;

import com.zenika.academy.barbajavas.backFinalProject.domain.model.answers.Answer;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.questions.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswerRepository extends CrudRepository<Answer, String> {
    @Query(nativeQuery = true,value = "SELECT * FROM answers WHERE question_id=?1")
    List<Answer> getEveryAnswersByQid(String question_id);
}
