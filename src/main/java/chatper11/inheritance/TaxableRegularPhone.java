package chatper11.inheritance;

import chapter10.Money;

import java.time.Duration;

/**
 * 기본 정책에 세금 정책 조합하기
 */
public class TaxableRegularPhone extends RegularPhone {
    private double taxRate;

    public TaxableRegularPhone(Money amount, Duration seconds, double taxRate) {
        super(amount, seconds);
        this.taxRate = taxRate;
    }

    @Override
    public Money calculateFee() {
        Money fee = super.calculateFee(); // 부모 클래스와의 결합도가 높아지고 만다.
        return fee.plus(fee.times(taxRate));
    }
}
