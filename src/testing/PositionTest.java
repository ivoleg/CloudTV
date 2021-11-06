package testing;

import diving.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Position enum.
 * @author Oleg Ivannikov
 */
public class PositionTest {
    /**
     * Tests for Position.fromCode.
     */
    @Test
    public void fromCodeTest() {
        assertEquals(Position.STRAIGHT, Position.fromCode('A'));
        assertEquals(Position.PIKE, Position.fromCode('B'));
        assertEquals(Position.TUCK, Position.fromCode('C'));
        assertEquals(Position.FREE, Position.fromCode('D'));
        assertEquals(Position.FLY, Position.fromCode('E'));
        assertNull(Position.fromCode('F'));
        assertNull(Position.fromCode('c'));
        assertNull(Position.fromCode(null));
    }
    /**
     * Tests for Position.fromDescription.
     */
    @Test
    public void fromDescriptionTest() {
        assertEquals(Position.STRAIGHT, Position.fromDescription("STRAIGHT"));
        assertEquals(Position.PIKE, Position.fromDescription("pike"));
        assertEquals(Position.TUCK, Position.fromDescription("TuCk"));
        assertEquals(Position.FREE, Position.fromDescription("fReE"));
        assertEquals(Position.FLY, Position.fromDescription("fly"));
        assertNull(Position.fromDescription("Freee"));
        assertNull(Position.fromDescription(""));
        assertNull(Position.fromDescription(null));
    }
    /**
     * Tests for Position.getCode.
     */
    @Test
    public void getCodeTest() {
        assertEquals('A',Position.STRAIGHT.getCode());
        assertEquals('B',Position.PIKE.getCode());
        assertEquals('C',Position.TUCK.getCode());
        assertEquals('D',Position.FREE.getCode());
        assertEquals('E',Position.FLY.getCode());
    }
    /**
     * Tests for Position.toString.
     */
    @Test
    public void toStringTest() {
        assertEquals("Straight",Position.STRAIGHT.toString());
        assertEquals("Pike",Position.PIKE.toString());
        assertEquals("Tuck",Position.TUCK.toString());
        assertEquals("Free",Position.FREE.toString());
        assertEquals("Fly",Position.FLY.toString());
    }
}
