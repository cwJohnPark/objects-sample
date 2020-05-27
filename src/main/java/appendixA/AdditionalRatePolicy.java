package appendixA;

import chapter10.Money;

import java.util.List;

public abstract class AdditionalRatePolicy implements RatePolicy {
    private RatePolicy next;

    public AdditionalRatePolicy(RatePolicy next) {
        this.next = next;
    }

    @Override
    public Money calculateFee(List<Call> calls) {
        // 사전조건
        assert calls != null;
        Money fee = next.calculateFee(calls);
        return afterCalculated(fee);
    }

    abstract protected Money afterCalculated(Money fee);
}
