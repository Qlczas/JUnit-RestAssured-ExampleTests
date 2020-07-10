package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomGenerator {

    public static String RANDOM_LONG_TEXT = generateStringOfGivenLength(8);

    public static final String RANDOM_SHORT_TEXT = generateStringOfGivenLength(4);

    private static String generateStringOfGivenLength(int i) {
        return RandomStringUtils.randomAlphanumeric(i).toUpperCase();
    }
}
