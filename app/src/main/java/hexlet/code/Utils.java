package hexlet.code;

import java.security.SecureRandom;

public class Utils {
    private static final SecureRandom RND = new SecureRandom();

    public static int intRnd(int value1, int value2) {

        if (value1 == value2) {
            return value1;
        }

        int minValue = Integer.min(value1, value2);
        int maxValue = Integer.max(value1, value2);

        int range = maxValue - minValue + 1;

        return RND.nextInt(range) + minValue;
    }

    public static int intRnd(int value) {
        return intRnd(0, value);
    }
}
