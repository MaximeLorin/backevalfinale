package com.zenika.academy.barbajavas.backFinalProject.domain.application;

import com.zenika.academy.barbajavas.backFinalProject.domain.model.questions.Question;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.questions.QuestionTileToLongException;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.users.User;
import com.zenika.academy.barbajavas.backFinalProject.domain.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class QuestionService {
    public QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question newQuestion( String title, String content, String language,User user) throws QuestionTileToLongException {
        boolean flag=false;
        String qMark=" ?";
        ZoneId zone =ZoneId.of("Europe/Paris");
        Instant instant = Instant.now();
        ZonedDateTime zdt=instant.atZone(zone);

        Question question= new Question(UUID.randomUUID().toString(), zdt,title+qMark,content,flag,language,user);

        questionRepository.save(question);
        return question;
    }

    public  Optional<Question> findQuestionById(String id){
        return questionRepository.findById(id);
    }

    public List<Question> getAllQuestionsOrdered(){return (List<Question>) questionRepository.findAndOrdersArticles();}

    public List<Question> getQuestionsByPart(String titlePart){
        return questionRepository.findByTitlePart(titlePart);
    }

    public List<Question>getByLanguage(String language){
        return questionRepository.findByLanguageIs(language);
    }


    public List<Question> getByUserId(String user_id){
        return questionRepository.findByUserId(user_id);
    }

    public List<Question>getWhereNoAnswer(){
        return questionRepository.findWhereNoAnswer();
    }

    public Question flagQuestion(String id, boolean flag) throws Exception{
        Question question = questionRepository.findById(id).orElseThrow(Exception::new);

        question.setFlag(flag);
        questionRepository.save(question);
        return question;
    }
}
