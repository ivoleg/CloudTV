package testing;

import org.junit.jupiter.api.Test;
import scoring.Score;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Score class.
 * @author Oleg Ivannikov
 */
public class ScoreTest {
    /**
     * Tests for both of the constructors and indirectly for Score.checkString
     */
    @Test
    public void testScore() {
        String nullString = null;

        assertThrows(IllegalArgumentException.class, () -> {
            Score score = new Score("");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Score score = new Score("", 56.9);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Score score = new Score(nullString);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Score score = new Score(nullString, 76.0);
        });
    }

    /**
     * Tests for Score.compareTo.
     */
    @Test
    public void compareToTest() {
        Score nullValueScore = new Score("null", null);
        Score AnotherNullValueScore = new Score("AnotherNull", null);
        Score positiveValueScore = new Score("positive", 14.87);
        Score negativeValueScore = new Score("negative", -67.43);
        Score zeroValueScore = new Score("zero", 0.0);
        assertEquals(0, nullValueScore.compareTo(AnotherNullValueScore));
        assertEquals(-1, nullValueScore.compareTo(positiveValueScore));
        assertEquals(-1, nullValueScore.compareTo(negativeValueScore));
        assertEquals(-1, nullValueScore.compareTo(zeroValueScore));
        assertEquals(1, positiveValueScore.compareTo(nullValueScore));
        assertEquals(1, positiveValueScore.compareTo(negativeValueScore));
        assertEquals(1, positiveValueScore.compareTo(zeroValueScore));
        assertEquals(1, negativeValueScore.compareTo(nullValueScore));
        assertEquals(-1, negativeValueScore.compareTo(positiveValueScore));
        assertEquals(-1, negativeValueScore.compareTo(zeroValueScore));
        assertEquals(1, zeroValueScore.compareTo(nullValueScore));
        assertEquals(-1, zeroValueScore.compareTo(positiveValueScore));
        assertEquals(1, zeroValueScore.compareTo(negativeValueScore));
    }

    /**
     * Tests for Score.getKey.
      */
    @Test
    public void getKeyTest() {
        assertEquals("test", new Score("test").getKey());
        assertEquals("TEST", new Score("TEST").getKey());
        assertEquals("   ", new Score("   ").getKey());
    }

    /**
     * Tests for Score.getValue
     */
    @Test
    public void getValueTest() {
        assertNull(new Score("f", null).getValue());
        assertEquals(0.0, new Score("s").getValue());
        assertEquals(5.7, new Score("t", 5.7).getValue());
    }

    /**
     * Tests for both Score.toString methods.
     */
    @Test
    public void toStringTest() {
        assertEquals("  7.3", new Score("a", 7.3).toString());
        assertEquals("  7.4", new Score("b", 7.373557).toString());
        assertEquals("  N/A", new Score("c", null).toString());
        assertEquals("d: 4.0", new Score("d", 4.0).toString(true));
        assertEquals("e: 9.1", new Score("e", 9.064776658599).toString(true));
        assertEquals("f:   N/A", new Score("f", null).toString(true));
        assertEquals("  10.3", new Score("g", 10.3).toString(false));
        assertEquals("  13.4", new Score("h", 13.38).toString(false));
        assertEquals("  N/A", new Score("i", null).toString(false));
    }
}
