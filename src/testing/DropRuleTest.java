package testing;

import org.junit.jupiter.api.Test;
import scoring.DropRule;
import scoring.Score;
import scoring.SizeException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the DropRule class.
 *  @author Oleg Ivannikov
 */
public class DropRuleTest {
    /**
     * Tests for DropRule.apply, and also indirectly tests DropRule.checkListLength,
     * DropRule.findMaxScore and DropRule.findMinScore.
     * @throws SizeException because apply throws it
     */
    @Test
    public void applyTest() throws SizeException {
        DropRule dropBoth = new DropRule();
        DropRule dropHighest = new DropRule(false, true);
        DropRule dropLowest = new DropRule(true, false);
        DropRule dropNone = new DropRule(false, false);
        //tests for Empty List
        List<Score> emptyList = new ArrayList<>();
        assertThrows(SizeException.class, () -> {
            dropBoth.apply(emptyList);
        });
        assertThrows(SizeException.class, () -> {
            dropHighest.apply(emptyList);
        });
        assertThrows(SizeException.class, () -> {
            dropLowest.apply(emptyList);
        });
        assertThrows(SizeException.class, () -> {
            dropNone.apply(emptyList);
        });
        //tests for null List
        List<Score> nullList = null;
        assertThrows(SizeException.class, () -> {
            dropBoth.apply(nullList);
        });
        assertThrows(SizeException.class, () -> {
            dropHighest.apply(nullList);
        });
        assertThrows(SizeException.class, () -> {
            dropLowest.apply(nullList);
        });
        assertThrows(SizeException.class, () -> {
            dropNone.apply(nullList);
        });
        //tests for List with One Element
        List<Score> oneElementList = new ArrayList<>();
        oneElementList.add(new Score("key", 7.5));
        assertThrows(SizeException.class, () -> {
            dropBoth.apply(oneElementList);
        });
        assertThrows(SizeException.class, () -> {
            dropHighest.apply(oneElementList);
        });
        assertThrows(SizeException.class, () -> {
            dropLowest.apply(oneElementList);
        });
        assertEquals(oneElementList, dropNone.apply(oneElementList));
        //tests for List with Two Elements
        List<Score> twoElementList = new ArrayList<>();
        Score firstScore = new Score("first", 9.0);
        Score secondScore = new Score("second");
        twoElementList.add(firstScore);
        twoElementList.add(secondScore);

        assertThrows(SizeException.class, () -> {
            dropBoth.apply(twoElementList);
        });

        List<Score> twoDropLowResult = new ArrayList<>();
        twoDropLowResult.add(firstScore);
        assertEquals(twoDropLowResult, dropLowest.apply(twoElementList));

        List<Score> twoDropHighResult = new ArrayList<>();
        twoDropHighResult.add(secondScore);
        assertEquals(twoDropHighResult, dropHighest.apply(twoElementList));

        assertEquals(oneElementList, dropNone.apply(oneElementList));
        //tests for Small List with Unique Elements
        List<Score> smallUniqueList = new ArrayList<>();
        Score firstScoreSLU = new Score("first", 9.0);   //SLU - small list with unique elements
        Score secondScoreSLU = new Score("second", 6.1);
        Score thirdScoreSLU = new Score("third", 7.5);
        smallUniqueList.add(firstScoreSLU);
        smallUniqueList.add(secondScoreSLU);
        smallUniqueList.add(thirdScoreSLU);

        List<Score> smallUniqueDropBothResult = new ArrayList<>();
        smallUniqueDropBothResult.add(thirdScoreSLU);
        assertEquals(smallUniqueDropBothResult, dropBoth.apply(smallUniqueList));

        List<Score> smallUniqueDropLowResult = new ArrayList<>();
        smallUniqueDropLowResult.add(firstScoreSLU);
        smallUniqueDropLowResult.add(thirdScoreSLU);
        assertEquals(smallUniqueDropLowResult, dropLowest.apply(smallUniqueList));

        List<Score> smallUniqueDropHighResult = new ArrayList<>();
        smallUniqueDropHighResult.add(secondScoreSLU);
        smallUniqueDropHighResult.add(thirdScoreSLU);
        assertEquals(smallUniqueDropHighResult, dropHighest.apply(smallUniqueList));

        assertEquals(smallUniqueList, dropNone.apply(smallUniqueList));
        //tests for Small List with Duplicates
        List<Score> smallDuplicateList = new ArrayList<>();
        Score firstScoreSLD = new Score("first", 8.6);   //SLD - small list with duplicates
        Score secondScoreSLD = new Score("second", 6.1);
        Score thirdScoreSLD = new Score("third", 8.6);
        smallDuplicateList.add(firstScoreSLD);
        smallDuplicateList.add(secondScoreSLD);
        smallDuplicateList.add(thirdScoreSLD);

        List<Score> smallDuplicateDropBothResult = new ArrayList<>();
        smallDuplicateDropBothResult.add(thirdScoreSLD);
        assertEquals(smallDuplicateDropBothResult, dropBoth.apply(smallDuplicateList));

        List<Score> smallDuplicateDropLowResult = new ArrayList<>();
        smallDuplicateDropLowResult.add(firstScoreSLD);
        smallDuplicateDropLowResult.add(thirdScoreSLD);
        assertEquals(smallDuplicateDropLowResult, dropLowest.apply(smallDuplicateList));

        List<Score> smallDuplicateDropHighResult = new ArrayList<>();
        smallDuplicateDropHighResult.add(secondScoreSLD);
        smallDuplicateDropHighResult.add(thirdScoreSLD);
        assertEquals(smallDuplicateDropHighResult, dropHighest.apply(smallDuplicateList));

        assertEquals(smallDuplicateList, dropNone.apply(smallDuplicateList));
        //tests for Large List with Unique Elements
        List<Score> largeUniqueList = new ArrayList<>();
        Score firstScoreLLU = new Score("first", 4.0);    //LLU - large list with unique elements
        Score secondScoreLLU = new Score("second", 9.0);
        Score thirdScoreLLU = new Score("third", 7.5);
        Score forthScoreLLU = new Score("forth", 3.7);
        Score fifthScoreLLU = new Score("fifth", 4.145);
        largeUniqueList.add(firstScoreLLU);
        largeUniqueList.add(secondScoreLLU);
        largeUniqueList.add(thirdScoreLLU);
        largeUniqueList.add(forthScoreLLU);
        largeUniqueList.add(fifthScoreLLU);

        List<Score> largeUniqueDropBothResult = new ArrayList<>();
        largeUniqueDropBothResult.add(firstScoreLLU);
        largeUniqueDropBothResult.add(thirdScoreLLU);
        largeUniqueDropBothResult.add(fifthScoreLLU);
        assertEquals(largeUniqueDropBothResult, dropBoth.apply(largeUniqueList));

        List<Score> largeUniqueDropLowResult = new ArrayList<>();
        largeUniqueDropLowResult.add(firstScoreLLU);
        largeUniqueDropLowResult.add(secondScoreLLU);
        largeUniqueDropLowResult.add(thirdScoreLLU);
        largeUniqueDropLowResult.add(fifthScoreLLU);
        assertEquals(largeUniqueDropLowResult, dropLowest.apply(largeUniqueList));

        List<Score> largeUniqueDropHighResult = new ArrayList<>();
        largeUniqueDropHighResult.add(firstScoreLLU);
        largeUniqueDropHighResult.add(thirdScoreLLU);
        largeUniqueDropHighResult.add(forthScoreLLU);
        largeUniqueDropHighResult.add(fifthScoreLLU);
        assertEquals(largeUniqueDropHighResult, dropHighest.apply(largeUniqueList));

        assertEquals(largeUniqueList, dropNone.apply(largeUniqueList));
        //tests for Large List with Duplicates
        List<Score> largeDuplicateList = new ArrayList<>();
        Score firstScoreLLD = new Score("first", 9.0);    //LLD - large list with duplicates
        Score secondScoreLLD = new Score("second", 9.0);
        Score thirdScoreLLD = new Score("third", 7.5);
        Score forthScoreLLD = new Score("forth", 3.7);
        Score fifthScoreLLD = new Score("fifth", 3.7);
        largeDuplicateList.add(firstScoreLLD);
        largeDuplicateList.add(secondScoreLLD);
        largeDuplicateList.add(thirdScoreLLD);
        largeDuplicateList.add(forthScoreLLD);
        largeDuplicateList.add(fifthScoreLLD);

        List<Score> largeDuplicateDropBothResult = new ArrayList<>();
        largeDuplicateDropBothResult.add(secondScoreLLD);
        largeDuplicateDropBothResult.add(thirdScoreLLD);
        largeDuplicateDropBothResult.add(fifthScoreLLD);
        assertEquals(largeDuplicateDropBothResult, dropBoth.apply(largeDuplicateList));

        List<Score> largeDuplicateDropLowResult = new ArrayList<>();
        largeDuplicateDropLowResult.add(firstScoreLLD);
        largeDuplicateDropLowResult.add(secondScoreLLD);
        largeDuplicateDropLowResult.add(thirdScoreLLD);
        largeDuplicateDropLowResult.add(fifthScoreLLD);
        assertEquals(largeDuplicateDropLowResult, dropLowest.apply(largeDuplicateList));

        List<Score> largeDuplicateDropHighResult = new ArrayList<>();
        largeDuplicateDropHighResult.add(secondScoreLLD);
        largeDuplicateDropHighResult.add(thirdScoreLLD);
        largeDuplicateDropHighResult.add(forthScoreLLD);
        largeDuplicateDropHighResult.add(fifthScoreLLD);
        assertEquals(largeDuplicateDropHighResult, dropHighest.apply(largeDuplicateList));

        assertEquals(largeDuplicateList, dropNone.apply(largeDuplicateList));
        //tests for Small List with Identical Elements
        List<Score> smallIdenticalList = new ArrayList<>();
        Score firstScoreSIL = new Score("a", 10.8);   //SIL - small list with identical elements
        Score secondScoreSIL = new Score("b", 10.8);
        Score thirdScoreSIL = new Score("c", 10.8);
        Score forthScoreSIL = new Score("d", 10.8);
        Score fifthScoreSIL = new Score("e", 10.8);
        smallIdenticalList.add(firstScoreSIL);
        smallIdenticalList.add(secondScoreSIL);
        smallIdenticalList.add(thirdScoreSIL);
        smallIdenticalList.add(forthScoreSIL);
        smallIdenticalList.add(fifthScoreSIL);

        List<Score> smallIdenticalDropBothResult = new ArrayList<>();
        smallIdenticalDropBothResult.add(thirdScoreSIL);
        smallIdenticalDropBothResult.add(forthScoreSIL);
        smallIdenticalDropBothResult.add(fifthScoreSIL);
        assertEquals(smallIdenticalDropBothResult, dropBoth.apply(smallIdenticalList));

        List<Score> smallIdenticalDropLowResult = new ArrayList<>();
        smallIdenticalDropLowResult.add(secondScoreSIL);
        smallIdenticalDropLowResult.add(thirdScoreSIL);
        smallIdenticalDropLowResult.add(forthScoreSIL);
        smallIdenticalDropLowResult.add(fifthScoreSIL);
        assertEquals(smallIdenticalDropLowResult, dropLowest.apply(smallIdenticalList));

        List<Score> smallIdenticalDropHighResult = new ArrayList<>();
        smallIdenticalDropHighResult.add(secondScoreSIL);
        smallIdenticalDropHighResult.add(thirdScoreSIL);
        smallIdenticalDropHighResult.add(forthScoreSIL);
        smallIdenticalDropHighResult.add(fifthScoreSIL);
        assertEquals(smallIdenticalDropHighResult, dropHighest.apply(smallIdenticalList));

        assertEquals(smallIdenticalList, dropNone.apply(smallIdenticalList));
        //tests for Large List with Identical Elements
        List<Score> largeIdenticalList = new ArrayList<>();
        Score firstScoreLIL = new Score("a", 10.8);   //LIL - small list with identical elements
        Score secondScoreLIL = new Score("b", 10.8);
        Score thirdScoreLIL = new Score("c", 10.8);
        Score forthScoreLIL = new Score("d", 10.8);
        Score fifthScoreLIL = new Score("e", 10.8);
        largeIdenticalList.add(firstScoreLIL);
        largeIdenticalList.add(secondScoreLIL);
        largeIdenticalList.add(thirdScoreLIL);
        largeIdenticalList.add(forthScoreLIL);
        largeIdenticalList.add(fifthScoreLIL);

        List<Score> largeIdenticalDropBothResult = new ArrayList<>();
        largeIdenticalDropBothResult.add(thirdScoreLIL);
        largeIdenticalDropBothResult.add(forthScoreLIL);
        largeIdenticalDropBothResult.add(fifthScoreLIL);
        assertEquals(largeIdenticalDropBothResult, dropBoth.apply(largeIdenticalList));

        List<Score> largeIdenticalDropLowResult = new ArrayList<>();
        largeIdenticalDropLowResult.add(secondScoreLIL);
        largeIdenticalDropLowResult.add(thirdScoreLIL);
        largeIdenticalDropLowResult.add(forthScoreLIL);
        largeIdenticalDropLowResult.add(fifthScoreLIL);
        assertEquals(largeIdenticalDropLowResult, dropLowest.apply(largeIdenticalList));

        List<Score> largeIdenticalDropHighResult = new ArrayList<>();
        largeIdenticalDropHighResult.add(secondScoreLIL);
        largeIdenticalDropHighResult.add(thirdScoreLIL);
        largeIdenticalDropHighResult.add(forthScoreLIL);
        largeIdenticalDropHighResult.add(fifthScoreLIL);
        assertEquals(largeIdenticalDropHighResult, dropHighest.apply(largeIdenticalList));

        assertEquals(largeIdenticalList, dropNone.apply(largeIdenticalList));
    }
}
