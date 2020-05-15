package chapter14;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class DateTimeIntervalTest {

    DateTimeInterval interval;

    @Before
    public void setup() {

    }

    @Test
    public void of() {
        interval = DateTimeInterval.of(
                LocalDateTime.of(2000, 1, 1, 0, 0),
                LocalDateTime.of(2000, 1, 2, 0, 0)
        );
    }

    @Test
    public void toMidnight() {
    }

    @Test
    public void fromMidnight() {
    }

    @Test
    public void during() {
    }

    @Test
    public void duration() {
    }

    @Test
    public void getFrom() {
    }

    @Test
    public void getTo() {
    }

    @Test
    public void splitByDay() {
    }
}