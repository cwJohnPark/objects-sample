package chapter13.liskov.dbc;

import chapter10.Money;

import java.time.LocalDateTime;

public class Movie {
    private Money fee;
    private DiscountPolicy discountPolicy;

    /**
     * calculateDiscountAmount 메서드가 정의한 사전조건을 만족시키는 것은 Movie의 책임이다.
     * 따라서, Movie의 사전조건을 위반하는 screening을 전달해서는 안된다.
     */
    public Money calculateMovieFee(Screening screening) {
        if (screening == null || screening.getStartTime().isBefore(LocalDateTime.now())) {
            throw new InvalidScreeningException();
        }

        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
