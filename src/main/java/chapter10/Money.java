package chapter10;

import java.math.BigDecimal;

public class Money {
    public final static Money ZERO = Money.wons(0);

    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount.setScale(0);
    }

    public static Money wons(double amount) {
        return new Money(BigDecimal.valueOf(amount).setScale(0));
    }

    public Money plus(Money amount) {
        return new Money(this.amount.add(amount.amount));
    }

    public Money times(double percent) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
    }

    public Money minus(Money amount) {
        return new Money(this.amount.subtract(amount.amount));
    }
    public boolean isLessThan(Money other) {
        return amount.compareTo(other.amount) < 0;
    }
    public boolean isGreaterThanOrEqual(Money other) {
        return amount.compareTo(other.amount) >= 0;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
