package string_calculator;

import java.util.List;
import java.util.stream.Collectors;

public class NegativesNotAllowedException extends IllegalArgumentException {

    public NegativesNotAllowedException(String message, List<Integer> negatives) {
        super(message + negatives.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

}
