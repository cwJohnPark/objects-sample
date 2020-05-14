package chapter13.liskov.dbc;

import chapter10.Money;

import java.time.LocalTime;

public class BrokenDiscountPolicy extends DiscountPolicy {

    public BrokenDiscountPolicy(DiscountCondition ...conditions) {
        super(conditions);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        checkPrecondition(screening); // 기존의 사전조건

        //checkStrongerPrecondition(screening); // 더 강화된 사전조건

        Money amount = screening.getMovieFee();

        checkPostcondition(amount); // 기존의 사후조건
        checkStrongerPostcondition(amount); // 더 강화된 사후조건
        //checkWeakerPostcondition(amount); // 더 약한 사후조건
        return amount;
    }

    /**
     * 서브타입에 더 약한 사후조건을 정의할 수 없다.
     */
    private void checkWeakerPostcondition(Money amount) {
        // 금액이 마이너스가 된다면?
        assert amount != null;
    }

    /**
     * 서브타입에 슈퍼타입과 같거나 더 강한 사후조건을 정의할 수 있다.
     */
    private void checkStrongerPostcondition(Money amount) {
        assert amount.isGreaterThanOrEqual(Money.wons(1000));
    }

    /**
     * 서브타입에 더 강력한 사전조건을 정의할 수 없다.
     */
    private void checkStrongerPrecondition(Screening screening) {
        assert screening.getEndTime().toLocalTime().isBefore(LocalTime.MIDNIGHT);
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
