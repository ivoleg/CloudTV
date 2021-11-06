package testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import scoring.Missing;

/**
 * Test class for Missing class.
 * @author Oleg Ivannikov
 */
public class MissingTest {
    /**
     * Tests for all three Missing.doubleValue.
     */
    @Test
    public void doubleValueTest() {
        double epsilon = 0.000001d;

        Double nullValue = null;
        // tests for null value
        double nullResult1 = Missing.doubleValue(nullValue);
        assertEquals(0.0, nullResult1, epsilon);
        double nullResult2 = Missing.doubleValue(nullValue, 8.0);
        assertEquals(8.0, nullResult2, epsilon);
        double nullResult3 = Missing.doubleValue(nullValue, 1998.3107, 86.57);
        assertEquals(1998.3107, nullResult3, epsilon);
        //tests for zero value
        Double zeroValue = 0.0;
        double zeroResult1 = Missing.doubleValue(zeroValue);
        assertEquals(zeroValue, zeroResult1, epsilon);
        double zeroResult2 = Missing.doubleValue(zeroValue, -134.76);
        assertEquals(zeroValue, zeroResult2, epsilon);
        double zeroResult3 = Missing.doubleValue(zeroValue, 20.21, 5.7);
        assertEquals(20.21, zeroResult3, epsilon);
        double zeroResult4 = Missing.doubleValue(zeroValue, 20.21, 0.0);
        assertEquals(zeroValue, zeroResult4, epsilon);
        double zeroResult5 = Missing.doubleValue(zeroValue, 20.21, -5.0);
        assertEquals(zeroValue, zeroResult5, epsilon);
        //tests for positive value
        Double positiveValue = 4.66;
        double positiveResult1 = Missing.doubleValue(positiveValue);
        assertEquals(positiveValue, positiveResult1, epsilon);
        double positiveResult2 = Missing.doubleValue(positiveValue, 0.0213);
        assertEquals(positiveValue, positiveResult2, epsilon);
        double positiveResult3 = Missing.doubleValue(positiveValue, -35.98, 13.37);
        assertEquals(-35.98, positiveResult3, epsilon);
        double positiveResult4 = Missing.doubleValue(positiveValue, -35.98, 4.66);
        assertEquals(positiveValue, positiveResult4, epsilon);
        double positiveResult5 = Missing.doubleValue(positiveValue, -35.98, -12.56);
        assertEquals(positiveValue, positiveResult5, epsilon);
        //tests fro negative value
        Double negativeValue = -15.76656;
        double negativeResult1 = Missing.doubleValue(negativeValue);
        assertEquals(negativeValue, negativeResult1, epsilon);
        double negativeResult2 = Missing.doubleValue(negativeValue, 100.0);
        assertEquals(negativeValue, negativeResult2, epsilon);
        double negativeResult3 = Missing.doubleValue(negativeValue, 436.001, -8.7);
        assertEquals(436.001, negativeResult3, epsilon);
        double negativeResult4 = Missing.doubleValue(negativeValue, 436.001, -15.76656);
        assertEquals(negativeValue, negativeResult4, epsilon);
        double negativeResult5 = Missing.doubleValue(negativeValue, 436.001, -667.7);
        assertEquals(negativeValue, negativeResult5, epsilon);
    }
}
