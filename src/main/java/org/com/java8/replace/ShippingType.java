package org.com.java8.replace;

public enum ShippingType {
    STANDARD {
        @Override
        public double getShippingCost(double weight){
            return weight * 5.0;
        }
    },
    EXPRESS {
        @Override
        public double getShippingCost(double weight) {
            return weight * 10.0;
        }
    },
    SAME_DAY {
        @Override
        public double getShippingCost(double weight) {
            return weight * 20.0;
        }
    },
    INTERNATIONAL {
        @Override
        public double getShippingCost(double weight) {
            return weight * 50.0;
        }
    },
    OVERNIGHT {
        @Override
        public double getShippingCost(double weight) {
            return weight * 30.0;
        }
    };

    public abstract double getShippingCost(double weight);
}
