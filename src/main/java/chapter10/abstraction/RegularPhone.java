package chapter10.abstraction;

import chapter10.Call;
import chapter10.Money;

import java.time.Duration;

/**
 * 부모 클래스와 자식 클래스가 모두 추상화에 의존하여 결합도를 낮춘다.
 */
public class RegularPhone extends Phone {
    private Money amount;
    private Duration seconds;


    public RegularPhone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }


}
