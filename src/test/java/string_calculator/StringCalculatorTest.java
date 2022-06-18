package string_calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

    @Test
    void emptyStringTest() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void oneNumberTest() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    void twoNumbersTest() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    void manyParamsTest() {
        // To test add method with many numbers we use a list of numbers from 0 to `max`
        StringBuilder numbers = new StringBuilder("0");
        int max = 42_000;
        for (int i = 1; i <= max; i++) {
            numbers.append(",").append(i);
        }
        int result = (max * (max + 1)) / 2; // Arithmetic progression sum formula

        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(result, stringCalculator.add(numbers.toString()));
    }

    @Test
    void newLinesTest() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    void testCustomDelimiter() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Test
    void testNewCustomDelimiter() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(7, stringCalculator.add("//:)\n4:)3"));
    }

}