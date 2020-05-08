package chatper11.composition.additional;

import chapter10.Money;
import chatper11.composition.RatePolicy;

/**
 *  세금 정책
 */
public class TaxablePolicy extends AdditionalRatePolicy {
    private double taxRatio;

    public TaxablePolicy(double taxRatio, RatePolicy next) {
        super(next);
        this.taxRatio = taxRatio;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.times(taxRatio));
    }
}
