package chapter14.coop;

import chapter10.Money;
import chapter14.DateTimeInterval;

import java.time.Duration;

/**
 * 단위 시간당 요금
 */
public class FeePerDuration {
    private Money fee;
    private Duration duration;

    public FeePerDuration(Money fee, Duration duration) {
        this.fee = fee;
        this.duration = duration;
    }

    public Money calculate(DateTimeInterval interval) {
        return fee.times(interval.duration().getSeconds() / duration.getSeconds());
    }
}
