package chatper11.composition.additional;

import chapter10.Call;
import chapter10.Money;
import chatper11.composition.NightlyDiscountPolicy;
import chatper11.composition.Phone;
import chatper11.composition.RegularPolicy;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 *  기본 정책과 부가 정책 합성하기
 */
public class TaxablePolicyTest {

    /**
     * 기본 요금 + 세금 정책
     * ( 10초에 10원 ) * 1.05
     */
    @Test
    public void test_RegularPolicy_TaxablePolicy() {
        // given
        Phone phone = new Phone(new TaxablePolicy(0.05,
                                    new RegularPolicy(Money.wons(10), Duration.ofSeconds(10))));

        // when
        /// 10초 간 통화
        phone.getCalls().add(getCallStubs(10));
        Money actual = phone.calculateFee();
        Money expected = Money.wons(10 * 1.05);

        // then
        assertThat(actual, is(expected));
    }

    /**
     * 기본 정책 + 기본 요금 할인 정책 + 세금 정책
     * ((10초 x 10원) - 1000원) * 1.05
     */
    @Test
    public void test_RegularPolicy_RateDiscountablePolicy_TaxablePolicy() {
        // given
        Phone phone = new Phone(new TaxablePolicy(0.05,
                                    new RateDiscountablePolicy(Money.wons(10),
                                        new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)))));
        // when
        phone.getCalls().add(getCallStubs(100));
        Money actual = phone.calculateFee();
        Money expected = Money.wons(((10 * (100/ 10)) - 10) * 1.05);

        // then
        assertThat(actual, is(expected));
    }

    /**
     * 세금 정책과 기본 요금 할인 정책이 적용되는 순서 바꾸기
     */
    @Test
    public void test_RegularPolicy_TaxablePolicy_RateDiscountablePolicy() {
        // given
        Phone phone = new Phone(new RateDiscountablePolicy(Money.wons(10),
                                    new TaxablePolicy(0.05,
                                            new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)))));
        // when
        phone.getCalls().add(getCallStubs(100));
        Money actual = phone.calculateFee();
        Money expected = Money.wons( ( 10 * ( 100 / 10 )) * 1.05 - 10);

        // then
        assertThat(actual, is(expected));
    }

    /**
     * 심야 할인 요금 정책 + 세금 정책 + 기본 할인 요금 정책
     */
    @Test
    public void test_NightlyDiscountPolicy_TaxablePolicy_RateDiscountPolicy() {
        // given
        Phone phone = getNightlyTaxableRateDiscountPhoneStub();
        // when
        phone.getCalls().add(getNightlyCallStubs(100));
        Money actual = phone.calculateFee();
        Money expected = Money.wons( ( 5 * ( 100 / 10 )) * 1.05 - 10);

        // then
        assertThat(actual, is(expected));
    }

    /**
     * 일반 요금 + 심야 할인 요금 정책 + 세금 정책 + 기본 할인 요금 정책
     */
    @Test
    public void test_Nightly_Regular_TaxablePolicy_RateDiscountPolicy() {

        Phone phone = getNightlyTaxableRateDiscountPhoneStub();

        // 기본 + 심야
        phone.getCalls().add(getNightlyCallStubs(500));
        phone.getCalls().add(getCallStubs(100));

        Money actual2 = phone.calculateFee();
        Money expected2 = Money.wons( ( 5 * (500 / 10) + ( 10 * (100 / 10)) ) * 1.05 - 10);

        assertThat(actual2.getAmount(), is(expected2.getAmount()));
    }

    private Phone getNightlyTaxableRateDiscountPhoneStub() {
        return new Phone(
                        new RateDiscountablePolicy(Money.wons(10),
                                new TaxablePolicy(0.05,
                                        new NightlyDiscountPolicy(Money.wons(5), Money.wons(10), Duration.ofSeconds(10)))));
    }

    private Call getNightlyCallStubs(int secondsBy) {
        LocalDateTime someNight = LocalDateTime.of(2020, 5, 9, 22,0);
        return new Call(someNight, someNight.plusSeconds(secondsBy));
    }

    private Call getCallStubs(int secondsBy) {
        LocalDateTime now = LocalDateTime.of(2020, 5, 9, 9,0);
        return new Call(now, now.plusSeconds(secondsBy));
    }

}