package chapter10.abstraction.taxrate;


import chapter10.Call;
import chapter10.Money;
import chapter10.abstraction.taxrate.Phone;

import java.time.Duration;

/**
 * 부모 클래스와 자식 클래스가 모두 추상화에 의존하여 결합도를 낮춘다.
 */
public class RegularPhone extends Phone {
    private Money amount;
    private Duration seconds;

    // 자식 클래스 또한 수정해줘야 한다.
    public RegularPhone(Money amount, Duration seconds, double taxRate) {
        super(taxRate);
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }


}
