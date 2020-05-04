package chapter10.abstraction;

import chapter10.Call;
import chapter10.Money;

import java.util.ArrayList;
import java.util.List;

// 중복된 코드를 부모 클래스로 모음
public abstract class Phone {

    private List<Call> calls = new ArrayList<>();

    public Money calculateFee() {
        Money result = Money.ZERO;

        for(Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    abstract protected Money calculateCallFee(Call call);
}
