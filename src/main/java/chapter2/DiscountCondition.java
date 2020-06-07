package chapter2;

/**
 * 할인 조건
 * 할인이 가능한지 불가능한지에 대해 판단한다.
 */
public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening) ;
}
