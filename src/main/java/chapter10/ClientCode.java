package chapter10;

import chapter10.duplicate.Phone;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class ClientCode {
    public static void main(String[] args) {
        Phone phone = new Phone(Money.wons(5), Duration.ofSeconds(10), 0);

        phone.call(new Call(LocalDateTime.of(2018, 1, 1, 12, 10, 0)
                , LocalDateTime.of(2018, 1, 1, 12, 11, 0)));
        phone.call(new Call(LocalDateTime.of(2018, 1, 1, 12, 10, 0)
                , LocalDateTime.of(2018, 1, 1, 12, 11, 0)));
        Money result = phone.calculateFee(); //=> Money.wons(60)
        assert result.getAmount() == new BigDecimal(60);
        System.out.println(result.getAmount());
    }
}
