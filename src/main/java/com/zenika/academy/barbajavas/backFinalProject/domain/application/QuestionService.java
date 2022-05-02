package com.zenika.academy.barbajavas.backFinalProject.domain.application;

import com.zenika.academy.barbajavas.backFinalProject.domain.model.questions.Question;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.questions.QuestionTileToLongException;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.users.User;
import com.zenika.academy.barbajavas.backFinalProject.domain.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.UUID;

@Service
public class QuestionService {
    public QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question newQuestion( String title, String content, User user) throws QuestionTileToLongException {
        boolean flag=false;
        String qMark=" ?";
        ZoneId zone =ZoneId.of("Europe/Paris");
        Instant instant = Instant.now();
        ZonedDateTime zdt=instant.atZone(zone);

        Question question= new Question(UUID.randomUUID().toString(), zdt,title+qMark,content,flag,user);

        questionRepository.save(question);
        return question;
    }
}
