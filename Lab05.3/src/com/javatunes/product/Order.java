/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import com.javatunes.billing.TaxCalculator;

import java.util.Collection;

public class Order {
  private String id;
  private double totalCost = 0.0;
  private TaxCalculator taxCalculator;
  
  public Order(String id) {
    this.id = id;
  }

  public Order() {
  }

  public void setCalc(TaxCalculator calc) {
    this.taxCalculator = calc;
  }

  public double getTax() {
      return taxCalculator.taxAmount(totalCost);
  }

    public void processCart(ShoppingCart<? extends Product> cart) {
      System.out.println("Order: " + getId() + " contains the following:");

      Collection<? extends Product> cartItems = cart.allItems();
      for (Product product : cartItems) {
        System.out.println(product.getCode());
      }
      double totalPlusTaxes = cart.total() + getTax();
      System.out.println("Order Total: " + totalPlusTaxes);
      totalCost = cart.total();
    }

    public String getId() {
      return id;
    }

    public double getTotalCost() {
      return totalCost;
    }

    public double doubleTax() {
      return 0.0;
    }
}