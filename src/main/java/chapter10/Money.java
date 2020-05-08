package chapter10;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
    public final static Money ZERO = Money.wons(0);

    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount.compareTo(new BigDecimal(0)) < 0 ? new BigDecimal(0) : amount.setScale(0, RoundingMode.DOWN);
    }

    public static Money wons(double amount) {
        return new Money(BigDecimal.valueOf(amount));
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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Money) {
            return ((Money) obj).amount.compareTo(this.amount) == 0;
        }
        return false;
    }
}
