package com.javatunes.product;

import com.javatunes.billing.*;

import java.sql.Date;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import com.javatunes.billing.Location;

public class OrderFactory {
    // prevent direct instantiation - this is an all-static factory class
    private OrderFactory() {
    }

    /**
     * TODO: given the input map, create and return the correct object (with its properties set).
     * If the input map's "type" value is not "HE" or "SE", throw IllegalArgumentException with a suitable message.
     */
    public static Order createOrder(Location location, String orderID)
            throws IllegalArgumentException {
        // return value
        Order order = null;

        // create a calculator variable that we will instantiate in the If-else loop
        TaxCalculator calculator;

        if (location.equals(Location.EUROPE)) {
            // create an order with an European Tax Calculator
            calculator = new EuropeTax();
            order = new Order(orderID);
            order.setCalc(calculator);

        } else if (location.equals(Location.USA)) {
            // create an order with a US Tax Calculator
            calculator = new USATax();
            order = new Order(orderID);
            order.setCalc(calculator);

        } else if (location.equals(Location.ONLINE)) {
            // create an order with an Online Calculator
            calculator = new OnlineTax();
            order = new Order(orderID);
            order.setCalc(calculator);

        } else {
            throw new IllegalArgumentException("Invalid Location: " + location);
        }

        return order;
    }
}