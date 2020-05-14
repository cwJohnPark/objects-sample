package chapter13.liskov.dbc;

public class DiscountCondition {
    public boolean isSatisfiedBy(Screening screening) {
        return false;
    }
}
