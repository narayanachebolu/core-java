package org.com.java8.replace;

// use Enum to replace the statements if-else
public class ShippingCostCalculator {
    public double calculateShippingCostUsingIf(String shippingType, double weight) {
        if (shippingType.equals("STANDARD")) {
            return weight * 5.0;
        } else if (shippingType.equals("EXPRESS")) {
            return weight * 10.0;
        } else if (shippingType.equals("SAME_DAY")) {
            return weight * 20.0;
        } else if (shippingType.equals("INTERNATIONAL")) {
            return weight * 50.0;
        } else if (shippingType.equals("OVERNIGHT")) {
            return weight * 30.0;
        }
        return 0;
    }

    public double calculateShippingCost(ShippingType shippingType, double weight) {
        return shippingType.getShippingCost(weight);
    }

    public static void main(String[] args) {
        var calculator = new ShippingCostCalculator();
        long start = System.currentTimeMillis();
        System.out.println(ShippingType.INTERNATIONAL + " shipping cost is: " + calculator.calculateShippingCost(ShippingType.INTERNATIONAL, 12));
        System.out.println("Time taken to perform the operation: " + (System.currentTimeMillis() - start));
    }
}
