package com.zenika.academy.barbajavas.backFinalProject.domain.repositories;

import com.zenika.academy.barbajavas.backFinalProject.domain.model.answers.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, String> {
}
