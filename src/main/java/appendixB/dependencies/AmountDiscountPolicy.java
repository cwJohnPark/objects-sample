package appendixB.dependencies;

import chapter10.Money;
import chapter13.liskov.dbc.Screening;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return null;
    }
}
