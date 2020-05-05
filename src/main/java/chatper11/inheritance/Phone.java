package chatper11.inheritance;

import chapter10.Call;
import chapter10.Money;

import java.util.ArrayList;
import java.util.List;

// 상속을 이용하여 기본 정책과 부가 정책을 구현함
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
