package scoring;

/**
 * Class that deals with inappropriate(null) Double values
 * @author Oleg Ivannikov
 */
public final class Missing {
    private static final double DEFAULT_MISSING_VALUE = 0.0;
    /**
     * Missing is a utility class, so we don't need the default constructor.
     */
    private Missing(){
        throw new java.lang.UnsupportedOperationException();
    }

    /**
     * Returns the double value of the Double parameter unless it is null,
     * in which case it must return DEFAULT_MISSING_VALUE.
     * @param number Double
     * @return number, but if it is null, then DEFAULT_MISSING_VALUE
     */
    public static double doubleValue(Double number) {
        double result;
        if (number == null) {result = DEFAULT_MISSING_VALUE;}
        else {result = number;}
        return result;
    }

    /**
     * Returns the double value of the Double parameter unless it is null,
     * in which case it must return missingValue parameter.
     * @param number Double
     * @param missingValue double, that is used in case that number is null
     * @return number, but if it is null, then missingValue
     */
    public static double doubleValue(Double number, double missingValue) {
        double result;
        if (number == null) {result = missingValue;}
        else {result = number;}
        return result;
    }

    /**
     * Returns the double value of the Double parameter unless it is null or less than lowerBound parameter,
     * in which case it must return missingValue parameter.
     * @param number Double
     * @param missingValue double, that is used in case that number is null or lower than lowerBound parameter
     * @param lowerBound double
     * @return number, but if it is null or less than lowerBound, then missingValue
     */
    public static double doubleValue(Double number, double missingValue, double lowerBound) {
        double result;
        if (number == null) {result = missingValue;}
        else if (number < lowerBound) {result = missingValue;}
        else {result = number;}
        return result;
    }

}
