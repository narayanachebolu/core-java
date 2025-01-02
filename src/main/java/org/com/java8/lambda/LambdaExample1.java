package org.com.java8.lambda;

@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

@FunctionalInterface
interface EvenOddEvaluator {
    void evaluate(int number);
}

public class LambdaExample1 {
    public static void main(String[] args) {
        Greeting greeting = (name) -> System.out.println("Hello " + name);

        greeting.sayHello("Naren");

        EvenOddEvaluator evenOddEvaluator = (number -> System.out.println(number + " is " + (number%2 == 0 ? "even" : "odd")));
        evenOddEvaluator.evaluate(8);
        evenOddEvaluator.evaluate(9);
    }
}
