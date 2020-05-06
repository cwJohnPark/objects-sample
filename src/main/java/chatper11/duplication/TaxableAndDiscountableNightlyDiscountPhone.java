package chatper11.duplication;

import chapter10.Money;
import chatper11.abstraction.TaxableNightlyDiscountPhone;

import java.time.Duration;

/**
 * 심야 할인 요금제의 계산 결과에 세금 정책을 적용한 후 기본 요금 할인 정책을 이용
 */
public class TaxableAndDiscountableNightlyDiscountPhone extends TaxableNightlyDiscountPhone {
    private Money discountAmount;

    public TaxableAndDiscountableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate, Money discountAmount) {
        super(nightlyAmount, regularAmount, seconds, taxRate);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return super.afterCalculated(fee).minus(discountAmount);
    }
}
