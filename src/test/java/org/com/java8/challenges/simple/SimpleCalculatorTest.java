package org.com.java8.challenges.simple;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {
    static SimpleCalculator simpleCalc;

    @BeforeAll
    static void setup() {
        simpleCalc = new SimpleCalculator();
    }

    @Test
    void twoPlusTwoEqualsFour() {
        assertEquals(4, simpleCalc.add(2, 2));
    }

    @Test
    void sevenPlusTwoEqualsNine() {
        assertEquals(9, simpleCalc.add(7, 2));
    }
}