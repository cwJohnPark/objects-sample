package chapter14;

import chapter10.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
