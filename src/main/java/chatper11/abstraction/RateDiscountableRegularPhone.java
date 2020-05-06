package chatper11.abstraction;

import chapter10.Money;

import java.time.Duration;

/**
 * 기본 정책에 기본 요금 할인 정책 조합
 */
public class RateDiscountableRegularPhone extends RegularPhone{
    // 매달 청구되는 요금에서 고정된 요금을 차감
    private Money discountAmount;

    public RateDiscountableRegularPhone(Money amount, Duration seconds, Money discountAmount) {
        super(amount, seconds);
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
