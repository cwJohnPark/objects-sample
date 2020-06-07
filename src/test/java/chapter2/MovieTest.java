package chapter2;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class MovieTest {

    @Test
    public void testAmountDiscountPolicy() throws Exception {
        // given
        final int MOVIE_FEE = 10000;
        final int DISCOUNT_AMOUNT = 800;

        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(MOVIE_FEE),
                new AmountDiscountPolicy(Money.wons(DISCOUNT_AMOUNT), getDiscountConditionFixture()));

        // when
        // 기간 조건에 맞음
        // then
        Reservation reserve = getScreeningFixture(avatar).reserve(new Customer(), 2);
        Money actual = reserve.getFee();
        Money expected = Money.wons(MOVIE_FEE * 2 - DISCOUNT_AMOUNT * 2);
        assertThat(actual.getAmount(), is(expected.getAmount()));

    }

    @Test
    public void testPercentDiscountPolicy() throws Exception {
        // given
        final int MOVIE_FEE = 10000;

        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(MOVIE_FEE),
                new PercentDiscountPolicy(0.1, getDiscountConditionFixture()));
        // when
        Reservation reserve = getScreeningFixture(avatar).reserve(new Customer(), 2);

        // then
        Money actual = reserve.getFee();
        Money expected = Money.wons((MOVIE_FEE - ( MOVIE_FEE * 0.1)) * 2);

        assertThat(actual.getAmount(), is(expected.getAmount()));
    }

    @Test
    public void testNoneDiscountPolicy() throws Exception {
        // given
        final int MOVIE_FEE = 10000;
        Movie starWars = new Movie("스타워즈",
                Duration.ofMinutes(210),
                Money.wons(MOVIE_FEE),
                new NoneDiscountPolicy());
        // when
        Reservation reserve = getScreeningFixture(starWars).reserve(new Customer(), 3);

        // then
        Money actual = reserve.getFee();
        Money expected = Money.wons(MOVIE_FEE * 3);

        assertThat(actual.getAmount(), is(expected.getAmount()));
        
    }

    // FIXTURE
    private Screening getScreeningFixture(Movie movie) {
        return new Screening(
                movie,
                2,
                LocalDateTime.of(2020, 6, 8, 10, 0));

    }

    private DiscountCondition[] getDiscountConditionFixture() {
        return new DiscountCondition[] {
                new SequenceCondition(1),
                new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 0))
        };
    }
}