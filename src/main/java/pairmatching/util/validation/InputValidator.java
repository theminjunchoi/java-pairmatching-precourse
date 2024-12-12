package pairmatching.util.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import pairmatching.util.exception.FunctionException;

public class FunctionValidator {
    private static final Set<String> validOptions = new HashSet<>(Arrays.asList("1", "2", "3", "Q"));

    public static void validateChooseFuntion(String uncheckFunction) {
        if (!validOptions.contains(uncheckFunction)) {
            throw new IllegalArgumentException(FunctionException.INVALID_CHOOSE.getExceptionMessage());
        }
    }
}
