package string_calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private static final String SEPARATOR = ",";

    public int add(String numbers) {
        if (numbers == null || numbers.isBlank()) {
            return 0;
        }
        List<Integer> numberList = getNumberList(numbers);
        return switch (numberList.size()) {
            case 0 -> 0;
            case 1, 2 -> numberList.stream().mapToInt(Integer::intValue).sum();
            default -> throw new IllegalArgumentException("The input string should contain at most two numbers");
        };

    }

    /**
     * Parse the input string numbers and converts it to a List of Integers
     *
     * @param numbers the input string containing the numbers
     * @return the List constructed form the input String
     */
    private List<Integer> getNumberList(String numbers) {
        return Arrays.stream(numbers.split(SEPARATOR))
                .map(Integer::parseInt)
                .toList();
    }

}
