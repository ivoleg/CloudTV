package scoring;

import java.util.List;
import java.util.Map;

/**
 * Class that calculates weighted total for the given list of scores.
 * @author Oleg Ivannikov
 */
public class WeightedTotalSystem extends TotalSystem{
    Map<String, Double> difficulty;

    /**
     * Default constructor.
     */
    public WeightedTotalSystem(){
        this.difficulty = null;
    }

    /**
     * Constructor with parameter.
     * @param difficulty Map with names and weights of the dives
     */
    public WeightedTotalSystem(Map<String, Double> difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Calculates weighted total of the list that is given.
     * Missing values and weights are treated using the Missing class.
     * @param key used for better readability in the main program
     * @param scores list of scores
     * @return weighted total of dives
     * @throws SizeException because checkList can throw it in case of null or empty list
     */
    @Override
    public Score calculate(String key, List<Score> scores) throws SizeException {
        checkList(scores);
        double sum = 0.0;
        for (Score score : scores) {
            double weight = Missing.doubleValue(this.difficulty.get(score.getKey()), 1.0, 1.0);
            double value = Missing.doubleValue(score.getValue());
            sum+=value * weight;
        }
        return new Score(key, sum);
    }
}
