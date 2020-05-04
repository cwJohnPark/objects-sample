package chapter10.highlyCoupled;

import chapter10.Call;
import chapter10.Money;
import chapter10.highlyCoupled.Phone;

import java.time.Duration;

// 강하게 결합된 Phone과 NightlyDiscountPhone
public class NightlyDiscountPhone extends Phone {
    private static final int LATE_NIGHT_HOUR = 22;
    private Money nightlyAmount;

    public NightlyDiscountPhone(Money nightlyAmount,Money regulatAmount, Duration seconds, double taxRate) {
        super(regulatAmount, seconds, taxRate);
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
        return result.minus(nightlyFee.plus(nightlyFee.times(getTaxRate())));
    }
}

