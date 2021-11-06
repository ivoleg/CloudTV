package scoring;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that drops the lowest and highest element in the list of Scores.
 * @author Oleg Ivannikov
 */
public class DropRule implements Rule{
    private final boolean shouldDropHighest;
    private final boolean shouldDropLowest;

    /**
     * Default constructor.
     */
    public DropRule(){
        shouldDropHighest = true;
        shouldDropLowest = true;
    }

    /**
     * Constructor with parameters.
     * @param shouldDropLowest boolean that shows if we should drop the lowest element
     * @param shouldDropHighest boolean that shows if we should drop the highest element
     */
    public DropRule(boolean shouldDropLowest, boolean shouldDropHighest) {
        this.shouldDropHighest = shouldDropHighest;
        this.shouldDropLowest = shouldDropLowest;
    }

    /**
     * Method that drops needed number of elements.
     * @param scores list from which we are dropping elements
     * @return new list without dropped elements
     * @throws SizeException in case if list is null or if it has inappropriate size
     */
    @Override
    public List<Score> apply(List<Score> scores) throws SizeException {
        if (scores == null) {
            throw new SizeException("List must be not null");
        }
        this.checkListLength(scores);
        List<Score> result = new ArrayList<>();
        if (this.shouldDropLowest && this.shouldDropHighest) {
            Score min = findMinScore(scores);
            Score max = findMaxScore(scores);
            if (max.compareTo(min) == 0) {   //If min and max are equal, then all the values are equal and therefore min and max are both scores.get(0)
                max = scores.get(1);
            }
            for (Score score : scores) {
                if (!score.equals(min) & !score.equals(max)) {
                    result.add(score);
                }
            }
        }
         else if (this.shouldDropLowest) {
            Score min = findMinScore(scores);
            for (Score score : scores) {
                if (!score.equals(min)) {
                    result.add(score);
                }
            }
        }
        else if (this.shouldDropHighest) {
            Score max = findMaxScore(scores);
            for (Score score : scores) {
                if (!score.equals(max)) {
                    result.add(score);
                }
            }
        }
        else {
            if (scores.isEmpty()) {
                throw new SizeException("List is empty");
            }
            result = scores;
        }
        return result;
    }

    /**
     * Helper method fot the apply method.Used only to throw exceptions if something is wrong
     * with the list that is passed to it.
     * @param scores list of Scores
     * @throws SizeException if the list has got an inappropriate size
     */
    public void checkListLength(List<Score> scores) throws SizeException {
        SizeException se = new SizeException("List don't have enough scores to apply DropRule");
        if (this.shouldDropLowest && this.shouldDropHighest && scores.size() < 3) {throw se;}
        if (this.shouldDropLowest && scores.size() < 2) {throw se;}
        if (this.shouldDropHighest && scores.size() < 2) {throw se;}
    }

    /**
     * Helper method fot the apply method. Finds maximum value Score within the list.
     * @param scores list of Scores
     * @return Score which value is the maximum for this list
     */
    private Score findMaxScore(List<Score> scores) {
        Score max = scores.get(0);
        for (Score score : scores) {
            if (score.compareTo(max) > 0) {
                max = score;
            }
        }
        return max;
    }
    /**
     *
     * Helper method fot the apply method. Finds minimum value Score within the list.
     * @param scores list of Scores
     * @return Score which value is the minimum for this list
     */
    private Score findMinScore(List<Score> scores) {
        Score min = scores.get(0);
        for (Score score : scores) {
            if (score.compareTo(min) < 0) {
                min = score;
            }
        }
        return min;
    }
}
