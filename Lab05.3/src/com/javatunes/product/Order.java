/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import com.javatunes.billing.Location;
import com.javatunes.billing.TaxCalculator;
import com.javatunes.billing.TaxCalculatorFactory;

import java.util.Collection;

public class Order {
  private final String id;
  private double cartTotal;
  private final Location location;
  
  public Order(String id, Location location) {
    this.id = id;
    this.location = location;
  }

  //--------OPTION 1 LAB MANUAL PAGE 158
  public double getTax() { //THis method just delegates to other methods
    double result = 0.0;
    //coding by intention. If you had a tax calc factory,
    // you would call a static method on tax calc and get a tax calc back.
    //fetch the appropiate tax calculator based on location
    TaxCalculator calc = TaxCalculatorFactory.getTaxCalculator(getLocation());
    //delegate to the returned tax calculator to get the tax
    return calc.taxAmount(getCartTotal());
  }
  
  /**
   * DONE:
   * get the items from the cart and iterate over them, print each item's product code
   * get cart total and print
   */
  public void processCart(ShoppingCart<? extends Product> cart) {
    System.out.println("Order: " + getId() + " contains the following:");
    
    Collection<? extends Product> cartItems = cart.allItems();
    for (Product product : cartItems) {
      System.out.println(product.getCode());
    }
    System.out.println("Order Total: " + cart.total());
  }
  
  public String getId() {
    return id;
  }

  public Location getLocation() {
    return location;
  }

  public double getCartTotal() {
    return cartTotal;
  }
}