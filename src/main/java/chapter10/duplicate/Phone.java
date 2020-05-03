package chapter10.duplicate;

import chapter10.Call;
import chapter10.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 통화 요금을 계산할 객체
 */
public class Phone {
    private Money amount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    private double taxRate; // 통화 요금에 부과할 세금

    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
        this.taxRate = 0;
    }

    public Phone(Money amount, Duration seconds, double taxRate) {
        this.amount = amount;
        this.seconds = seconds;
        this.taxRate = taxRate;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for(Call call : calls) {
            result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
        }

        return result.plus(result.times(taxRate));
    }

}
