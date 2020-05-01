/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.billing;

/**
 * Domestic orders have a graduated tax scheme:
 *  The first $20.00 is tax-free.
 *  Amount over $20.00 is taxed at 10.0%.
 *  
 * TODO: implement this algorithm.
 */
public class USATax implements TaxCalculator {

    public double taxAmount(double taxable) {
        double calculatedTaxes;
        double adjustedGrossIncome = taxable - 20.0;
        if (adjustedGrossIncome > 0.0) {
            calculatedTaxes = adjustedGrossIncome * 0.10;
        } else {
            calculatedTaxes = 0.0;
        }

        return calculatedTaxes;
    }

}