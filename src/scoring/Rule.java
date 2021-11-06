package scoring;

import java.util.List;

/**
 * Interface for the DropRule class.
 * @author Oleg Ivannikov
 */
public interface Rule {
    List<Score> apply(List<Score> scores) throws SizeException;
}
