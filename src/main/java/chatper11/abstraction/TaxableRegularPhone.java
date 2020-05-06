package chatper11.abstraction;

import chapter10.Money;

import java.time.Duration;

/**
 * 세금 계산 부가 정책
 */
public class TaxableRegularPhone extends RegularPhone {
    private double taxRate;

    public TaxableRegularPhone(Money amount, Duration seconds, double taxRate) {
        super(amount, seconds);
        this.taxRate = taxRate;
    }

    /**
     * 훅 메소드를 오버라이드하여 새로 구현함
     */
    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.times(taxRate));
    }
}
