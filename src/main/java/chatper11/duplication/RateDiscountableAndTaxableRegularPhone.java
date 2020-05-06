package chatper11.duplication;

import chapter10.Money;
import chatper11.abstraction.RateDiscountableRegularPhone;

import java.time.Duration;

/**
 * 표준 요금제에 기본 요금 할인정책을 적용한 후 세금을 적용
 */
public class RateDiscountableAndTaxableRegularPhone extends RateDiscountableRegularPhone {
    private double taxRate;

    public RateDiscountableAndTaxableRegularPhone(Money amount, Duration seconds, Money discountAmount, double taxRate) {
        super(amount, seconds, discountAmount);
        this.taxRate = taxRate;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return super.afterCalculated(fee).plus(fee.times(taxRate));
    }
}
