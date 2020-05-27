package appendixA;

import chapter10.Money;

import java.util.ArrayList;
import java.util.List;

public class Phone {
    private RatePolicy ratePolicy;
    private List<Call> calls = new ArrayList<>();

    public Phone(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
    }

    public List<Call> getCalls() {
        return calls;
    }

    public void call(Call call) {
        calls.add(call);
    }
    public Bill publishBill() {
        return new Bill(this, ratePolicy.calculateFee(calls));
    }
}
