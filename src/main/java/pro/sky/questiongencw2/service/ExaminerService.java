package pro.sky.questiongencw2.service;

import pro.sky.questiongencw2.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestion(int amount);
}
