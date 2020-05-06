package chatper11.abstraction;

import chapter10.Call;
import chapter10.Money;

import java.util.ArrayList;
import java.util.List;

/**
 * 기본 정책에 세금 정책 조합하기
 */
public abstract class Phone {
    private List<Call> calls = new ArrayList<>();

    public Money calculateFee() {
        Money result = Money.ZERO;

        for(Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return afterCalculated(result);
    }

    protected abstract Money calculateCallFee(Call call);

    // 세금 계산을 위해 명세를 기술함
    //protected abstract Money afterCalculated(Money fee);

    // 모든 추상 메소드의 구현이 똑같으므로, 기본 구현을 제공(Hook method)
    protected Money afterCalculated(Money fee) {
        return fee;
    }
}
