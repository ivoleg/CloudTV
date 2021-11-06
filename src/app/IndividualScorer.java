package app;

import diving.*;
import scoring.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * An application that can be used to score the required program for one diver in a
 * sanctioned intra-departmental 1-meter springboard diving competition.
 * <p>
 * When running this application, the judges' 10 scores (one score from each of the five judges
 * for both dives) must be entered as command-line parameters.
 *
 * @author Annie Pro Grammer, CloudTV
 * @version H1
 */
public class IndividualScorer {
  private static final String[] COUNTRY = {"ALB", "BEL", "CAN", "DJI", "ESA"};
  private static final String[] REQUIRED = {"Forward Dive - Pike", "Forward Somersault - Tuck"};

  /**
   * The entry point of the application.
   *
   * @param args The command line arguments containing the 10 scores
   */
  public static void main(String[] args) {
    // Early exit
    if ((args == null) || (args.length != 11)) {
      System.err.println("You must enter all 10 scores "
        + "(five scores for each of the two required dives) followed by the diver's name.");
      System.exit(1);
    }

    // Setup the Map containing the degrees of difficulty
    Map<String, Double> difficulty = new DifficultyTable1mS();

    // Print the header
    System.out.printf("Results for %s\n\n", args[10]);
    System.out.printf("%30s", " ");
    for (int judge = 0; judge < 5; judge++) System.out.printf(" %5s", COUNTRY[judge]);
    System.out.printf(" | %4s\n", "Raw");


    List<Score> dives = new ArrayList<Score>();

    for (int dive = 0; dive < 2; dive++) {
      List<Score> scores = new ArrayList<Score>();
      System.out.printf("%30s", REQUIRED[dive]);

      // Create a list containing the judge's scores for the current dive
      for (int judge = 0; judge < 5; judge++) {
        Double value = null;
        String s = args[dive * 5 + judge];
        if (!s.equals("N/A")) value = Double.parseDouble(s);

        Score score = new Score(COUNTRY[judge], value);
        System.out.printf(" %s", score.toString());
        scores.add(score);
      }

      // Drop the highest and lowest scores and calculate (and display) the raw total
      Rule dropRule = new DropRule(true, true);
      ScoringSystem totalSystem = new TotalSystem();
      try {
        // Drop the high and the low
        List<Score> middle = dropRule.apply(scores);
        // Calculate the total of the others
        Score temp = totalSystem.calculate(REQUIRED[dive], middle);

        dives.add(temp);

        System.out.printf(" | %4.1f\n", temp.getValue());
      } catch (SizeException se) {
        System.out.printf("There are scores missing for dive %d\n", dive + 1);
      }
    }

    // Calculate (and display) the weighted total for this diver
    ScoringSystem dodSystem = new WeightedTotalSystem(difficulty);
    try {
      Score total = dodSystem.calculate("Points", dives);
      System.out.printf("%30s", total.toString(true));
    } catch (SizeException se) {
      System.out.println("This diver didn't complete either of the two required dives!");
    }

  }

}
