package com.tw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MoneyTest {
    //1st requirement
    @Test
    void shouldCheckMoneyIsAddedToWallet() {
        Money thirtyRupee = new Money(30, Money.Unit.RUPEES);
        Money twoDollars = new Money(2, Money.Unit.DOLLARS);
        Money hundredRupees = new Money(179.7, Money.Unit.RUPEES);
        Money walletMoney =thirtyRupee.addRupees(twoDollars);
        assertEquals(hundredRupees,walletMoney);
    }
    //2nd requirement
    @Test
    void shouldReturnSixtyFivePointEightFive() {
        Money oneRupee = new Money(1, Money.Unit.RUPEES);
        Money oneDollar = new Money(1, Money.Unit.DOLLARS);
        Money tenRupees = new Money(10, Money.Unit.RUPEES);
        Money totalWalletAmount = oneRupee.addRupees(oneDollar);
        Money walletBalance =totalWalletAmount.balance(tenRupees);
        Money sixtyFivePointEightFive = new Money(65.85, Money.Unit.RUPEES);
        assertEquals(sixtyFivePointEightFive, walletBalance);
    }

    //3rd requirement
    @Test
    void shouldReturnOneHundredTwentyFourPointEightFiveRupeesIfWalletHasFiftyRupeesAndOneDollar() {
        Money fiftyRupees = new Money(50, Money.Unit.RUPEES);
        Money oneDollar = new Money(1, Money.Unit.DOLLARS);
        Money oneHundredTwentyFourPointEightFiveRupees = new Money(124.85, Money.Unit.RUPEES);

        Money result = fiftyRupees.addRupees(oneDollar);

        assertEquals(oneHundredTwentyFourPointEightFiveRupees, result);
    }
    @Test
    void shouldReturnFourDollarIfWalletHasSeventyFourPointEightFiveRupeesAndOneDollarAndOneFortyNinePointSeven() {
        Money SeventyFourPointEightFiveRupees = new Money(74.85, Money.Unit.RUPEES);
        Money OneDollar = new Money(1, Money.Unit.DOLLARS);
        Money OneFortyNinePointSeven = new Money(149.7, Money.Unit.RUPEES);
        Money FourDollar = new Money(4, Money.Unit.DOLLARS);

        Money resultInDollars = SeventyFourPointEightFiveRupees.addDollars(OneDollar,OneFortyNinePointSeven);

        assertEquals(FourDollar, resultInDollars);
    }


}
