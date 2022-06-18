package string_calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private static final String DELIMITERS_REGEX = "[,\\n]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_TO_NUMBERS_DELIMITER = "\\n";

    public int add(String numbers) {
        if (numbers == null || numbers.isBlank()) {
            return 0;
        }
        List<Integer> numberList = getNumberList(numbers);
        return numberList.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    /**
     * Parse the string input and converts it to a List of Integers
     *
     * @param input the non-blank input string containing the numbers and optionally a header with a custom delimiter
     * @return the List constructed form the input String
     */
    private List<Integer> getNumberList(String input) {
        String delimiter = DELIMITERS_REGEX;

        // Handle custom delimiter
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            String[] headerAndNumbers = input.split(CUSTOM_DELIMITER_TO_NUMBERS_DELIMITER, 2);
            // First element of the array is the custom delimiter preceded by `CUSTOM_DELIMITER_PREFIX`
            // It is quoted (by being surrounded by \Q and \E) in order to use it as an uninterpreted pattern in the
            // String.split() method
            delimiter = "\\Q" + headerAndNumbers[0].replaceFirst(CUSTOM_DELIMITER_PREFIX, "") + "\\E";
            // Second element of the array is the String containing numbers
            if (headerAndNumbers.length != 2) {
                throw new IllegalArgumentException("The list of numbers should be on a new line after the custom delimiter");
            }
            input = headerAndNumbers[1];
        }

        return Arrays.stream(input.split(delimiter))
                .map(Integer::parseInt)
                .toList();
    }

}
