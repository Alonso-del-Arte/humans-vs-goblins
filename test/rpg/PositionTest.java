package rpg;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import randomness.Pseudorandom;

class PositionTest {

    @Test
    void testGetX() {
        System.out.println("getX");
        int expected = Pseudorandom.nextInt(256);
        int y = Pseudorandom.nextInt(256);
        Position position = new Position(expected, y);
        int actual = position.getX();
        String msg = "x of " + position + " should be " + expected;
        assertEquals(expected, actual, msg);
    }

    @Test
    void testGetY() {
        System.out.println("getY");
        int x = Pseudorandom.nextInt(256);
        int expected = Pseudorandom.nextInt(256);
        Position position = new Position(x, expected);
        int actual = position.getY();
        String msg = "y of " + position + " should be " + expected;
        assertEquals(expected, actual, msg);
    }

    @Test
    void testToString() {
        System.out.println("toString");
        int x = Pseudorandom.nextInt(32) - 16;
        int y = Pseudorandom.nextInt(32) - 16;
        Position position = new Position(x, y);
        String expected = "(" + x + "," + y + ")";
        String actual = position.toString().replace(" ", "");
        assertEquals(expected, actual);
    }

    @Test
    void testReferentialEquality() {
        int x = Pseudorandom.nextInt(32) - 16;
        int y = Pseudorandom.nextInt(32) - 16;
        Position position = new Position(x, y);
        assertEquals(position, position);
    }

    @Test
    void testNotEqualsNull() {
        int x = Pseudorandom.nextInt(32) - 16;
        int y = Pseudorandom.nextInt(32) - 16;
        Position position = new Position(x, y);
        String msg = "Position " + position + " should not equal null";
        assert !position.equals(null) : msg;
    }

    @Test
    void testNotEqualsDiffClass() {
        int x = Pseudorandom.nextInt(32) - 16;
        int y = Pseudorandom.nextInt(32) - 16;
        Position absPos = new Position(x, y);
        RelativePosition relPos = new RelativePosition(x, y);
        assertNotEquals(absPos, relPos);
    }

    @Test
    void testNotEqualsDiffX() {
        int x = Pseudorandom.nextInt(32) - 16;
        int y = Pseudorandom.nextInt(32) - 16;
        Position positionA = new Position(x, y);
        Position positionB = new Position(x + 1, y);
        assertNotEquals(positionA, positionB);
    }

    @Test
    void testNotEqualsDiffY() {
        int x = Pseudorandom.nextInt(32) - 16;
        int y = Pseudorandom.nextInt(32) - 16;
        Position positionA = new Position(x, y);
        Position positionB = new Position(x, y + 1);
        assertNotEquals(positionA, positionB);
    }

    @Test
    void testEquals() {
        System.out.println("equals");
        int x = Pseudorandom.nextInt(32) - 16;
        int y = Pseudorandom.nextInt(32) - 16;
        Position somePosition = new Position(x, y);
        Position samePosition = new Position(x, y);
        assertEquals(somePosition, samePosition);
    }

    @Test
    void testHashCode() {
        System.out.println("hashCode");
        int firstX = -16;
        int firstY = -16;
        int boundX = 16;
        int boundY = 16;
        int capacity = (boundX - firstX) * (boundY - firstY);
        Set<Position> positions = new HashSet<>(capacity);
        Set<Integer> hashes = new HashSet<>(capacity);
        for (int x = firstX; x < boundX; x++) {
            for (int y = firstY; y < boundY; y++) {
                Position position = new Position(x, y);
                positions.add(position);
                hashes.add(position.hashCode());
            }
        }
        int expected = positions.size();
        int actual = hashes.size();
        String msg = "Collection of " + expected
                + " Position instances should have as many distinct hash codes";
        assertEquals(expected, actual, msg);
    }

    @Test
    void testOffset() {
        System.out.println("offset");
        int x = Pseudorandom.nextInt(32) - 16;
        int y = Pseudorandom.nextInt(32) - 16;
        Position position = new Position(x, y);
        int adjustX = Pseudorandom.nextInt(32) - 16;
        int adjustY = Pseudorandom.nextInt(32) - 16;
        RelativePosition adjustment = new RelativePosition(adjustX, adjustY);
        Position expected = new Position(x + adjustX, y + adjustY);
        Position actual = position.offset(adjustment);
        String msg = "Offsetting position " + position + " by " + adjustment
                + " should give " + expected;
        assertEquals(expected, actual, msg);
    }

}