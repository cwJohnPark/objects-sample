package chapter12;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LectureTest {

    /**
     *  이수 기준이 70점인 객체지향 프로그래밍 과목의 수강생 5명에 대한 성적 통계
     */
    @Test
    public void test70PassScore() {
        Lecture lecture = new Lecture("객체지향 프로그래밍", 70, Arrays.asList(81, 95, 75, 50, 45));
        String evaluation = lecture.evaluate();

        assertThat("Pass:3 Fail:2", is(evaluation));
    }

}