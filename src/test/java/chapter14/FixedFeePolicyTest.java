package chapter14;

import chapter10.Money;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FixedFeePolicyTest {

    FixedFeePolicy policy;
    Call call;
    @Before

    @Test
    public void whenCall30SecondsAndPolicyIs10wonsFor10secondsThen30wons() {
        // given
        // 30초 동안 통화를 함
        call = new Call(
                LocalDateTime.of(2000, 1, 1, 0, 0, 0),
                LocalDateTime.of(2000, 1, 1, 0, 0, 30)
        );
        // 요금 정책이 10 초당 10원 일 때
        policy = new FixedFeePolicy(Money.wons(10), Duration.ofSeconds(10));
        // when
        Money resultFee = policy.calculateCallFee(call);
        // then
        assertThat(resultFee, is(Money.wons(30)));
    }

}