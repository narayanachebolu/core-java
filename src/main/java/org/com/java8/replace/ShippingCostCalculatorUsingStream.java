package org.com.java8.replace;

import java.util.HashMap;
import java.util.Map;

public class ShippingCostCalculatorUsingStream {
    private static final Map<String, Double> shippingCostsPerUnit = new HashMap<>();

    private static final Map<String, Double> shippingDiscounts = Map.of(
            "STANDARD", 1.0,
            "EXPRESS", 2.0,
            "OVERNIGHT", 3.0,
            "SAME_DAY", 4.0,
            "INTERNATIONAL", 5.0
    );

    private static final Map<String, Double> shippingTaxes = Map.of(
            "US", 5.5,
            "EUROPE", 8.5,
            "ASIA", 6.5
    );

    private static final Map<String, Double> additionalFlatShippingCostForOverSized = Map.of(
            "STANDARD", 11.0,
            "EXPRESS", 22.0,
            "OVERNIGHT", 33.0,
            "SAME_DAY", 44.0,
            "INTERNATIONAL", 55.0
    );

    static {
        shippingCostsPerUnit.put("STANDARD", 10.0);
        shippingCostsPerUnit.put("EXPRESS", 20.0);
        shippingCostsPerUnit.put("OVERNIGHT", 30.0);
        shippingCostsPerUnit.put("SAME_DAY", 40.0);
        shippingCostsPerUnit.put("INTERNATIONAL", 50.0);
    }

    public static double calculateShippingCostsAfterTax(String shippingType, double weight, String region) {
        double shippingCostPerUnit = shippingCostsPerUnit.getOrDefault(shippingType, 0.0);

        Double shippingDiscount = shippingDiscounts.getOrDefault(shippingType, 0.0);

        Double shippingTax = shippingTaxes.getOrDefault(shippingType, 7.0);

        Double additionalFlatShippingCost = additionalFlatShippingCostForOverSized.getOrDefault(shippingType, 0.0);

        // apply discount if weight is over 10 units
        double shippingCostPerUnitAfterDiscount = weight > 10 ? shippingCostPerUnit - (shippingCostPerUnit * (shippingDiscount / 100)) : shippingCostPerUnit;

        double totalShippingCost = shippingCostPerUnitAfterDiscount * weight;

        // compute additional flat shipping cost for over-sized
        totalShippingCost = weight > 50 ? totalShippingCost + additionalFlatShippingCost : totalShippingCost;

        // compute regional tax
        return totalShippingCost + (totalShippingCost * (shippingTax / 100));
    }

    public static double calculateShippingCost(String shippingType, double weight) {
        return shippingCostsPerUnit.getOrDefault(shippingType, 0.0) * weight;
        /*shippingCostsPerUnit.entrySet().stream()
                .filter(entry -> entry.getKey().equalsIgnoreCase(shippingType))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(0.0)
                * weight;*/
    }

    public static void main(String[] args) {
        //ShippingCostCalculatorUsingStream calculator = new ShippingCostCalculatorUsingStream();

        double finalShippingCost = calculateShippingCostsAfterTax("STANDARD", 30, "US");
        System.out.println("Final shipping cost including taxes: " + finalShippingCost);

        var shippingType1 = "STANDARD";
        double shippingCost1 = calculateShippingCost(shippingType1, 11);
        System.out.println("Shipping cost for " + shippingType1 + " is " + shippingCost1);
        var shippingType2 = "SAME_DAY";
        double shippingCost2 = calculateShippingCost(shippingType2, 20);
        System.out.println("Shipping cost for " + shippingType2 + " is " + shippingCost2);
        var shippingType3 = "EXPRESS";
        double shippingCost3 = calculateShippingCost(shippingType3, 12);
        System.out.println("Shipping cost for " + shippingType3 + " is " + shippingCost3);
        long startTime = System.currentTimeMillis();
        var shippingType4 = "INTERNATIONAL";
        double shippingCost4 = calculateShippingCost(shippingType4, 15);
        System.out.println("Shipping cost for " + shippingType4 + " is " + shippingCost4);
        System.out.println("Time taken to perform the operation: " + (System.currentTimeMillis() - startTime));
        var shippingType5 = "OVERNIGHT";
        double shippingCost5 = calculateShippingCost(shippingType5, 25);
        System.out.println("Shipping cost for " + shippingType5 + " is " + shippingCost5);
        var shippingType6 = "INVALID";
        double shippingCost6 = calculateShippingCost(shippingType6, 25);
        System.out.println("Shipping cost for " + shippingType6 + " is " + shippingCost6);
        var shippingType7 = "NULL_TYPE";
        double shippingCost7 = calculateShippingCost(null, 25);
        System.out.println("Shipping cost for " + shippingType7 + " is " + shippingCost7);
    }
}
