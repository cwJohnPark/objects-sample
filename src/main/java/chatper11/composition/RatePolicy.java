package chatper11.composition;

import chapter10.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
