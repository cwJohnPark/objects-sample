package chatper11.composition;

import chapter10.Call;
import chapter10.Money;

import java.util.ArrayList;
import java.util.List;

public class Phone {
    private RatePolicy ratePolicy; // 합성 관계
    private List<Call> calls = new ArrayList<>();

    public Phone(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
    }

    public List<Call> getCalls() {
        return calls;
    }
    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }
}
