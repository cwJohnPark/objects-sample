package chapter13.liskov.dbc;

import chapter10.Money;

import java.time.LocalDateTime;
import java.util.List;

public abstract class DiscountPolicy {

    private DiscountCondition[] conditions;

    public DiscountPolicy(DiscountCondition[] conditions) {
        this.conditions = conditions;
    }

    public Money calculateDiscountAmount(Screening screening) {
        // 사전조건
        checkPrecondition(screening);

        Money amount = Money.ZERO;
        for(DiscountCondition each: conditions) {
            if(each.isSatisfiedBy(screening)) {
                amount = getDiscountAmount(screening);
                // 사후조건
                checkPostcondition(amount);
                return amount;
            }
        }

        return screening.getMovieFee();
    }

    protected void checkPrecondition(Screening screening) {
        assert screening != null && screening.getStartTime().isAfter(LocalDateTime.now());
    }

    protected void checkPostcondition(Money amount) {
        assert amount != null && amount.isGreaterThanOrEqual(Money.ZERO);
    }

    protected abstract Money getDiscountAmount(Screening screening);

}
