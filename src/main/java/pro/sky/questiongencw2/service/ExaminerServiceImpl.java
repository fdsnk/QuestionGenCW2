package pro.sky.questiongencw2.service;

import pro.sky.questiongencw2.domain.Question;
import pro.sky.questiongencw2.exceptions.NotExistException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;

    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new NotExistException();
        }
        final Set<Question> questionSet = new HashSet<>();

        while (questionSet.size() != amount) {
            questionSet.add(questionService.getRandomQuestion());
        }
        return Collections.unmodifiableSet(questionSet);
    }
}
