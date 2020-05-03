package chapter10.duplicate;

import chapter10.Call;
import chapter10.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 심야 할인 요금제
 * - 밤 10시 이후의 통화에 대해 요금을 할인한다.
 */
public class NightlyDiscountPhone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    private double taxRate; // 통화 요금에 부과할 세금

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
        this.taxRate = taxRate;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for(Call call : calls) {
            if(call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                result = result.plus(nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            } else {
                result = result.plus(regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            }
        }

        return result.minus(result.times(taxRate));
    }

}
