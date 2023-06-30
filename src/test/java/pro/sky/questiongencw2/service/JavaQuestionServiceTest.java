package pro.sky.questiongencw2.service;

import pro.sky.questiongencw2.domain.Question;
import pro.sky.questiongencw2.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.questiongencw2.constants.ServiceConstants;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private final JavaQuestionService out = new JavaQuestionService();

    @BeforeEach
    void setUp() {
        out.add("question", "answer");
    }

    @Test
    void addByStringCorrect() {
        assertEquals(ServiceConstants.RANDOM_QUESTION, out.add("question", "answer"));
    }

    @Test
    void addByQuestionCorrect() {
        assertEquals(ServiceConstants.RANDOM_QUESTION, out.add(new Question("question", "answer")));
    }

    @Test
    void removeCorrect() {
        assertEquals(ServiceConstants.RANDOM_QUESTION, out.remove(new Question("question", "answer")));
    }

    @Test
    void removeInCorrect() {
        assertThrows(NotFoundException.class, () -> out.remove(new Question("que", "ans")));
    }

    @Test
    void getAllCorrect() {
        assertIterableEquals(ServiceConstants.RANDOM_SET, out.getAll());
    }

    @Test
    void getRandomQuestionCorrect() {
        assertEquals(ServiceConstants.RANDOM_QUESTION, out.getRandomQuestion());
    }

}