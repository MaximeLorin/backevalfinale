package com.zenika.academy.barbajavas.backFinalProject.domain.repositories;

import com.zenika.academy.barbajavas.backFinalProject.domain.model.questions.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, String> {
}
