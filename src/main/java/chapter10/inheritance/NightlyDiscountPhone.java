package chapter10.inheritance;

import chapter10.Call;
import chapter10.Money;
import chapter10.duplicate.Phone;

import java.time.Duration;

/**
 *  상속을 이용하여 중복 코드 제거하기
 */
public class NightlyDiscountPhone extends Phone {
    private static final int LATE_NIGHT_HOUR = 22;
    private Money nightlyAmount;

    public NightlyDiscountPhone(Money nightlyAmount,Money regulatAmount, Duration seconds) {
        super(regulatAmount, seconds);
        this.nightlyAmount = nightlyAmount;
    }

    @Override
    public Money calculateFee() {
        // 부모 클래스의 calculateFee 호출
        Money result = super.calculateFee();

        Money nightlyFee = Money.ZERO;
        for(Call call : getCalls()) {
            if(call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                nightlyFee = nightlyFee.plus(
                        getAmount().minus(nightlyAmount).times(
                                call.getDuration().getSeconds() / getSeconds().getSeconds()));
            }
        }
        return result.minus(nightlyFee);
    }
}
