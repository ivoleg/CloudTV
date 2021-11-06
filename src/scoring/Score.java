package scoring;

/**
 * Class that represents scores as a pair of String key and Double value.
 * @author Oleg Ivannikov
 */
public class Score implements Comparable<Score> {
    private final Double value;
    private final String key;

    /**
     * Constructor that takes key and value.
     * @param key key for the score
     * @param value value of the score
     */
    public Score(String key, Double value) {
        checkString(key);
        this.key = key;
        this.value = value;
    }

    /**
     * Constructor that takes key and sets value equal to 0.0
     * @param key key for the score
     */
    public Score(String key) {
        checkString(key);
        this.key = key;
        this.value = 0.0;
    }

    /**
     * Helper method for the constructors. Used only to throw exceptions if something is wrong
     * with the key that is passed to them.
     * @param s string that is checked
     */
    private void checkString(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Key must be not null");
        }
        if (s.equals("")) {
            throw new IllegalArgumentException("Key must be a non-empty string");
        }
    }

    /**
     * Method that compares two Score objects by their values.
     * @param other another Score object
     * @return -1/0/1 if this value is less than/equal to/greater than other value
     */
    public int compareTo (Score other) {
        int result;
        if (this.value == null) {
            if (other.value == null) {
                result = 0;
            }
            else {
                result = -1;
            }
        }
        else {
            if (other.value == null) {
                result = 1;
            }
            else if (this.value < other.value) {
                result = -1;
            }
            else if (this.value > other.value) {
                result = 1;
            }
            else {
                result = 0;
            }
        }
        return result;
    }

    /**
     * Getter for the key of score object.
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * Getter for the value of score object.
     * @return value
     */
    public Double getValue() {
        return value;
    }

    /**
     * Returns value of this score as string.
     * @return value as string or "N/A" if value is null
     */
    public String toString() {
        String result;
        if (value != null) {result = String.format("  %.1f", value);}
        else {result = "  N/A";}
        return result;
    }

    /**
     * Returns description of the score object, depending on the verbose parameter.
     * @param verbose boolean that shows in which form we should return the description.
     * @return key value pair if verbose parameter is true, value otherwise, N/A is value is null
     */
    public String toString(boolean verbose) {
        String result;
        if (verbose) {
            if (value != null) {result = String.format(key + ": %.1f", value);}
            else {result = key + ":   N/A";}
        }
        else {
            if (value != null) {result = String.format("  %.1f", value);}
            else {result = "  N/A";}
        }
        return result;
    }
}
