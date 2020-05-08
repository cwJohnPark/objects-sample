package chatper11.composition.additional;

import chapter10.Money;
import chatper11.composition.Phone;
import chatper11.composition.RatePolicy;

/**
 *  부가 정책
 */
public abstract class AdditionalRatePolicy implements RatePolicy {
    // 다른 요금 정책과 조합될 수 있도록 함
    private RatePolicy next;

    public AdditionalRatePolicy(RatePolicy next) {
        this.next = next;
    }

    @Override
    public Money calculateFee(Phone phone) {
        // 다른 요금 정책을 계산 후 부가 정책을 적용함
        Money fee = next.calculateFee(phone);
        return afterCalculated(fee);
    }

    abstract protected Money afterCalculated(Money fee);
}
