package org.com.java8.challenges.simple;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GraderTest {
    static Grader grader;

    @BeforeAll
    static void setup() {
        grader = new Grader();
    }

    @Test
    void negativeNumberShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> grader.determineLetterGrade(-11));
    }

    @Test
    void shouldThrowExceptionWithMessageNumberGradeCannotBeNegative() {
        // GIVEN, WHEN
        var exception = assertThrows(IllegalArgumentException.class, () -> grader.determineLetterGrade(-11));

        // THEN
        assertThat(exception).hasMessage("Number grade cannot be negative.");
    }

    @Test
    void fiftyNineShouldReturnF() {
        assertEquals('F', grader.determineLetterGrade(59));
    }

    @Test
    void sixtyShouldReturnD() {
        assertEquals('D', grader.determineLetterGrade(60));
    }

    @Test
    void sixtyNineShouldReturnD() {
        assertEquals('D', grader.determineLetterGrade(69));
    }

    @Test
    void seventyShouldReturnC() {
        assertEquals('C', grader.determineLetterGrade(70));
    }

    @Test
    void seventyNineShouldReturnC() {
        assertEquals('C', grader.determineLetterGrade(79));
    }

    @Test
    void eightyShouldReturnB() {
        assertEquals('B', grader.determineLetterGrade(80));
    }

    @Test
    void eightyNineShouldReturnB() {
        assertEquals('B', grader.determineLetterGrade(89));
    }

    @Test
    void ninetyNineShouldReturnA() {
        assertEquals('A', grader.determineLetterGrade(99));
    }

    @Test
    void ninetyShouldReturnA() {
        assertEquals('A', grader.determineLetterGrade(90));
    }
}