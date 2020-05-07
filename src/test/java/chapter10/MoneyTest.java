package chapter10;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MoneyTest {
    Money money;
    @Test
    public void testTimes() {
        money = new Money(new BigDecimal(10));
        Money money100 = money.times(10);
        assertThat(money100.getAmount(), is(new Money(new BigDecimal(100)).getAmount()));
    }
}