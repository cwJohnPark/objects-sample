package chatper11.composition;

import chapter10.Call;
import chapter10.Money;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class PhoneTest {

    Phone phone;

    @Test
    public void testRegularPolicy_10WonsFor10seconds() {
        // given
        /// 20초 동안 통화를 함
        Call call = getCallStub(20);

        // when
        /// 10초에 10원
        phone = new Phone(new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)));
        phone.getCalls().add(call);

        // then
        /// 10원 * ( 20초 / 10초) = 20원
        Money callFee20 = phone.calculateFee();
        Money expected20 = Money.wons(20);
        assertEquals(expected20.getAmount(), callFee20.getAmount());
    }

    private Call getCallStub(int secondsBy) {
        LocalDateTime now = LocalDateTime.now();
        return new Call(now, now.plusSeconds(secondsBy));
    }

    @Test
    public void testNightlyDiscountPolicy_10WonsFor10Seconds() {
        // given
        /// 22시 이후, 10초 동안 통화를 함
        Call call = getNightCallStub(10);
        // when
        /// 22시 이후의 통화료는 10초에 5원
        phone = new Phone(new NightlyDiscountPolicy(Money.wons(5), Money.wons(10), Duration.ofSeconds(10)));
        phone.getCalls().add(call);

        // then
        /// 5원 * ( 10 / 10 ) = 5원
        Money actual5wons = phone.calculateFee();
        Money expected5wons = Money.wons(5);

        assertThat(actual5wons.getAmount(), is(expected5wons.getAmount()));

    }

    private Call getNightCallStub(int secondsBy) {
        return new Call(
                LocalDateTime.of(2020, 5, 8, 22,0),
                LocalDateTime.of(2020, 5,8,22,0,secondsBy));
    }

}