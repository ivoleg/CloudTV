package scoring;

import java.util.List;

/**
 * Class that calculates raw total for the given list of scores.
 * @author Oleg Ivannikov
 */
public class TotalSystem implements  ScoringSystem{
    /**
     * Default constructor.
     */
    public TotalSystem() {}

    /**
     * Calculates row total of the list that is given. Missing values are treated using the Missing class.
     * @param key used for better readability in the main program
     * @param scores list of Scores
     * @return raw total for the scores from the list
     * @throws SizeException because checkList can throw it in case of null or empty list
     */
    @Override
    public Score calculate(String key, List<Score> scores) throws SizeException{
        checkList(scores);
        double sum = 0.0;
        for (Score score : scores) {
            sum+=Missing.doubleValue(score.getValue());
        }
        return new Score(key, sum);
    }

    /**
     * Helper method for the calculate method. Used only to throw exceptions if something is wrong
     * with the list that is passed to it.
     * @param scores list of Scores
     * @throws SizeException in case if list is empty or null
     */
    public void checkList(List<Score> scores) throws SizeException{
        if (scores == null) {
            throw new SizeException("List must be not null.");
        }
        if (scores.isEmpty()) {
            throw new SizeException("List must be not empty.");
        }
    }
}
