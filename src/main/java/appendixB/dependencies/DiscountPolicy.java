package appendixB.dependencies;

import chapter10.Money;
import chapter13.liskov.dbc.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
