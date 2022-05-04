package com.zenika.academy.barbajavas.backFinalProject.domain.application;

import com.zenika.academy.barbajavas.backFinalProject.domain.model.answers.Answer;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.answers.AnswerToLongException;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.questions.Question;
import com.zenika.academy.barbajavas.backFinalProject.domain.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnswerService {
    public AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer newAnswer(String content, Question question) throws AnswerToLongException {
        boolean flag=false;

        ZoneId zone =ZoneId.of("Europe/Paris");
        Instant instant = Instant.now();
        ZonedDateTime zdt=instant.atZone(zone);

        Answer answer= new Answer(UUID.randomUUID().toString(), zdt,content,flag,question);

        answerRepository.save(answer);
        return answer;
    }

    public List<Answer> getAnswersByQid(String id){
        return this.answerRepository.getEveryAnswersByQid(id);
    }
}
