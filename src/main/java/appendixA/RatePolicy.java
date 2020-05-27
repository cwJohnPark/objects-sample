package appendixA;

import chapter10.Money;

import java.util.List;

public interface RatePolicy {
    Money calculateFee(List<Call> calls);
}
