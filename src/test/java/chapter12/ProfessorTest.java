package chapter12;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class ProfessorTest {

    @Test
    public void testCompileStatistics() {
        Professor professor = new Professor("다익스트라",
                new GradeLecture("알고리즘",
                        70,
                        Arrays.asList(
                        new Grade("A", 100, 95),
                        new Grade("B", 94, 80),
                        new Grade("C", 79, 70),
                        new Grade("D", 69, 50),
                        new Grade("F", 49, 0)),
                        Arrays.asList(81,95, 75, 50, 45)));
        String expected = "[다익스트라] Pass:3 Fail:2, A:1 B:1 C:1 D:1 F:1 - Avg: 69.2";
        String actual = professor.compileStatistics();
        assertThat(actual, is(expected));
    }

}