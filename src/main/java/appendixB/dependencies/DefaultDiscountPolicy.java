package appendixB.dependencies;

import chapter10.Money;
import chapter13.liskov.dbc.DiscountCondition;
import chapter13.liskov.dbc.Screening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  인터페이스와 추상 클래스의 결합
 */
public abstract class DefaultDiscountPolicy implements DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(DiscountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        for(DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return screening.getMovieFee();
    }

    abstract protected Money getDiscountAmount(Screening screening);
}

