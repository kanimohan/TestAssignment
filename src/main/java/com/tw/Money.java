package com.tw;

import java.util.Objects;

public class Money {

    private final double value;
    private final Unit unit;

    public enum Unit {
        RUPEES(1), DOLLARS(74.85);
        private final double baseScale;

        Unit(double baseScale) {
            this.baseScale = baseScale;
        }
    }

    public Money(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Money balance(Money tenRupees) {
        double result = this.convertToRupees() - tenRupees.convertToRupees();

        return new Money(result, unit);
    }

    public Money addRupees(Money anotherMoney) {
        double result = this.convertToRupees() + anotherMoney.convertToRupees();

        return new Money(result, unit);

    }

    private double convertToRupees() {
        return value * unit.baseScale ;
    }

    public Money addDollars(Money oneDollar, Money oneFortyNinePointSeven) {

        double result = convertToDollars(this.convertToRupees() + oneDollar.convertToRupees() + oneFortyNinePointSeven.convertToRupees());

        System.out.println(this.convertToRupees() + oneDollar.convertToRupees() + oneFortyNinePointSeven.convertToRupees());

        return new Money((int) result, Unit.DOLLARS);
    }

    private double convertToDollars(double result) {
        return result / Unit.DOLLARS.baseScale ;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Money anotherMoney = (Money) obj;
        return this.convertToRupees() == anotherMoney.convertToRupees();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }


}
