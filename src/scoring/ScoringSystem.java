package scoring;

import java.util.List;

/**
 * Interface for the TotalSystem and WeightedTotalSystem classes.
 * @author Oleg Ivannikov
 */
public interface ScoringSystem  {
     Score calculate(String key, List<Score> scores) throws SizeException;
}
