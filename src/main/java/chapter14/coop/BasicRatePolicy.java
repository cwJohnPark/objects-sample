package chapter14.coop;

import chapter10.Money;
import chapter14.Call;
import chapter14.Phone;
import chapter14.RatePolicy;

import java.util.ArrayList;
import java.util.List;

public class BasicRatePolicy implements RatePolicy {
    private List<FeeRule> feeRules = new ArrayList<>();

    public BasicRatePolicy(List<FeeRule> feeRules) {
        this.feeRules = feeRules;
    }

    @Override
    public Money calculateFee(Phone phone) {
        return phone.getCalls()
                    .stream()
                    .map(call -> calculate(call))
                    .reduce(Money.ZERO, (first, second) -> first.plus(second));
    }

    private Money calculate(Call call) {
        return feeRules
                    .stream()
                    .map(rule -> rule.calculateFee(call))
                    .reduce(Money.ZERO, (first, second) -> first.plus(second));
    }
}
