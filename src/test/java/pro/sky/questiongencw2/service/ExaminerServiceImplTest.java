package pro.sky.questiongencw2.service;

import pro.sky.questiongencw2.domain.Question;
import pro.sky.questiongencw2.exceptions.NotExistException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.questiongencw2.constants.ServiceConstants;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionServiceMock;
    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    void getQuestionCorrect() {
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(ServiceConstants.RANDOM_QUESTION);
        when(javaQuestionServiceMock.getAll()).thenReturn(Collections.unmodifiableSet(ServiceConstants.RANDOM_SET));

        Set<Question> expected = new HashSet<>(Set.of(ServiceConstants.RANDOM_QUESTION));

        assertIterableEquals(Collections.unmodifiableSet(expected), out.getQuestion(1));
    }

    @Test
    void getQuestionInCorrect() {
        when(javaQuestionServiceMock.getAll()).thenReturn(Collections.unmodifiableSet(ServiceConstants.RANDOM_SET));

        assertThrows(NotExistException.class, () -> out.getQuestion(2));
    }

}