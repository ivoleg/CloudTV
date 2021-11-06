package testing;

import org.junit.jupiter.api.Test;
import scoring.Score;
import scoring.SizeException;
import scoring.WeightedTotalSystem;
import diving.DifficultyTable1mS;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for WeightedTotalSystem class.
 * @author Oleg Ivannikov
 */
public class WeightedTotalSystemTest {
    /**
     * Tests for WeightedTotalSystem.calculate.
     * @throws SizeException because calculate throws it
     */
    @Test
    public void calculateTest() throws SizeException {
        double epsilon = 0.000001d;
        Map<String, Double> difficulty = new DifficultyTable1mS();
        WeightedTotalSystem wts = new WeightedTotalSystem(difficulty);
        String key = "result";

        List<Score> scores = new ArrayList<>();
        Score firstScore1 = new Score("Forward Dive - Tuck", 8.5);
        Score secondScore1 = new Score("Forward Double Somersault - Pike", 7.0);
        Score thirdScore1 = new Score("Forward 3 1/2 Somersault - Tuck", 8.0);
        scores.add(firstScore1);
        scores.add(secondScore1);
        scores.add(thirdScore1);
        assertEquals(50.3, wts.calculate(key, scores).getValue(), epsilon);

        scores.clear();

        Score firstScore2 = new Score("Forward Dive - Tuck", 8.5);
        Score secondScore2 = new Score("Forward Double Somersault - Pike", 7.0);
        Score thirdScore2 = new Score("Forward 3 1/2 Somersault - Tuck", 8.0);
        Score forthScore2 = new Score("Back Dive - Pike", 9.0);
        scores.add(firstScore2);
        scores.add(secondScore2);
        scores.add(thirdScore2);
        scores.add(forthScore2);
        assertEquals(59.3, wts.calculate(key, scores).getValue(), epsilon);

        scores.clear();

        Score firstScore3 = new Score("Dive A - Tuck", 8.5);
        Score secondScore3 = new Score("Dive B - Pike", 7.0);
        Score thirdScore3 = new Score("Dive C - Tuck", 8.0);
        scores.add(firstScore3);
        scores.add(secondScore3);
        scores.add(thirdScore3);
        assertEquals(23.5, wts.calculate(key, scores).getValue(), epsilon);

        scores.clear();

        Map<String, Double> difficultyWrongWeight = new DifficultyTable1mS();
        difficultyWrongWeight.put("Forward Dive - Tuck", 0.6);
        WeightedTotalSystem wtsWrongWeight = new WeightedTotalSystem(difficultyWrongWeight);
        Score firstScore4 = new Score("Forward Dive - Tuck", 8.5);
        Score secondScore4 = new Score("Forward Double Somersault - Pike", 7.0);
        Score thirdScore4 = new Score("Forward 3 1/2 Somersault - Tuck", 8.0);
        Score forthScore4 = new Score("Back Dive - Pike", 9.0);
        scores.add(firstScore4);
        scores.add(secondScore4);
        scores.add(thirdScore4);
        scores.add(forthScore4);
        assertEquals(57.6, wtsWrongWeight.calculate(key, scores).getValue(), epsilon);

        scores.clear();

        Score firstScore5 = new Score("Forward Dive - Tuck", 8.5);
        Score secondScore5 = new Score("Forward Double Somersault - Pike", 7.0);
        Score thirdScore5 = new Score("Forward 3 1/2 Somersault - Tuck", 8.0);
        Score forthScore5 = new Score("Forward Dive - Pike");
        scores.add(firstScore5);
        scores.add(secondScore5);
        scores.add(thirdScore5);
        scores.add(forthScore5);
        assertEquals(50.3, wts.calculate(key, scores).getValue(), epsilon);

        scores.clear();

        Score firstScore6 = new Score("Forward Dive - Tuck");
        Score secondScore6 = new Score("Forward Double Somersault - Pike");
        Score thirdScore6 = new Score("Forward 3 1/2 Somersault - Tuck");
        scores.add(firstScore6);
        scores.add(secondScore6);
        scores.add(thirdScore6);
        assertEquals(0.0, wts.calculate(key, scores).getValue(), epsilon);

        scores.clear();

        Score firstScore7 = new Score("Forward Dive - Tuck", 8.5);
        Score secondScore7 = new Score("Forward Double Somersault - Pike", 7.0);
        Score thirdScore7 = new Score("Forward 3 1/2 Somersault - Tuck", 8.0);
        Score forthScore7 = new Score("Back Dive - Pike");
        scores.add(firstScore7);
        scores.add(secondScore7);
        scores.add(thirdScore7);
        scores.add(forthScore7);
        assertEquals(50.3, wts.calculate(key, scores).getValue(), epsilon);
    }
}
