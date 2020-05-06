package chatper11.duplication;

import chapter10.Money;
import chatper11.abstraction.TaxableRegularPhone;

import java.time.Duration;

/**
 * 일반 요금제의 계산 결과에 세금 정책을 조합 후 기본 요금 할인 정책을 추가
 */
public class TaxableAndRateDiscountableRegularPhone extends TaxableRegularPhone {
    private Money discountAmount;

    public TaxableAndRateDiscountableRegularPhone(Money amount, Duration seconds, double taxRate, Money discountAmount) {
        super(amount, seconds, taxRate);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return super.afterCalculated(fee).minus(discountAmount);
    }
}
