package testing;

import org.junit.jupiter.api.Test;
import scoring.Score;
import scoring.SizeException;
import scoring.TotalSystem;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Test class for TotalSystem class.
 * @author Oleg Ivannikov
 */
public class TotalSystemTest {
    /**
     * Tests for TotalSystem.calculate.
     * @throws SizeException because calculate throws it
     */
    @Test
    public void calculateTest() throws SizeException {
        double epsilon = 0.000001d;
        TotalSystem ts = new TotalSystem();
        String key = "result";

        List<Score> threeMissingList = new ArrayList<>();
        Score nullScore = new Score("f", null);
        for (int i = 0; i < 3; i++) {
            threeMissingList.add(nullScore);
        }
        assertEquals(0.0, ts.calculate(key, threeMissingList).getValue(), epsilon);

        List<Score> twoMissingList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            twoMissingList.add(nullScore);
        }
        twoMissingList.add(new Score("f", 7.5));
        assertEquals(7.5, ts.calculate(key, twoMissingList).getValue(), epsilon);

        List<Score> oneMissingList = new ArrayList<>();
        twoMissingList.add(nullScore);
        oneMissingList.add(new Score("f", 7.5));
        oneMissingList.add(new Score("s", 8.5));
        assertEquals(16.0, ts.calculate(key, oneMissingList).getValue(), epsilon);

        List<Score> noMissingList = new ArrayList<>();
        noMissingList.add(new Score("f", 5.5));
        noMissingList.add(new Score("s", 6.5));
        noMissingList.add(new Score("t", 4.0));
        assertEquals(16.0, ts.calculate(key, noMissingList).getValue(), epsilon);
    }
    /**
     * Tests for TotalSystem.checkList.
     */
    @Test
    public void checkListTest() {
        TotalSystem ts = new TotalSystem();
        List<Score> nullList = null;
        assertThrows(SizeException.class, () -> {
            ts.checkList(nullList);
        });
        List<Score> emptyList = new ArrayList<>();
        assertThrows(SizeException.class, () -> {
            ts.checkList(emptyList);
        });
    }
}
