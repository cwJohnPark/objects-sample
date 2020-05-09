package chapter12;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GradeLectureTest {

    @Test
    public void test70ScoreGradeLecture() {
        Lecture lecture = new GradeLecture("객체지향 프로그래밍", 70,
                Arrays.asList(
                        new Grade("A", 100, 95),
                        new Grade("B", 94, 80),
                        new Grade("C", 79, 70),
                        new Grade("D", 69, 50),
                        new Grade("F", 49, 0)),
                Arrays.asList(81, 95, 75, 50, 45));

        String result = lecture.evaluate();

        assertThat("Pass:3 Fail:2, A:1 B:1 C:1 D:1 F:1", is(result));

    }
}