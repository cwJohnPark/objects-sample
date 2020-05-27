package appendixB.ducktyping;

import chapter10.Money;

public class SalariedEmployee implements Employee {
    private String name;
    private Money basePay;

    public SalariedEmployee(String name, Money basePay) {
        this.name = name;
        this.basePay = basePay;
    }

    public Money calculatePay(double taxRate) {
        return basePay.minus(basePay.times(taxRate));
    }
}
