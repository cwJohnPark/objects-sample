package chatper11.abstraction;

import chapter10.Money;

import java.time.Duration;

/**
 *  심야 할인 요금제와 기본 요금 할인 정책 조합
 */
public class RateDiscountableNightlyDiscountPhone extends NightlyDiscountPhone {
    private Money discountAmount;

    public RateDiscountableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, Money discountAmount) {
        super(nightlyAmount, regularAmount, seconds);
        this.discountAmount = discountAmount;
    }

    /**
     * 중복 코드 !!!
     */
    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
