package chapter14.coop;

import chapter10.Money;
import chapter14.Call;

/**
 * 단위요금(feePerDuration)과 적용조건(feeCondtiion)을 저장하는 두 개의 인스턴스 변수로 구성됨
 */
public class FeeRule {
    private FeeCondition feeCondition;
    private FeePerDuration feePerDuration;

    public FeeRule(FeeCondition feeCondition, FeePerDuration feePerDuration) {
        this.feeCondition = feeCondition;
        this.feePerDuration = feePerDuration;
    }

    public Money calculateFee(Call call) {
        return feeCondition.findTimeIntervals(call)
                .stream()
                .map(each -> feePerDuration.calculate(each))
                .reduce(Money.ZERO, (first, second) -> first.plus(second));
    }
}
