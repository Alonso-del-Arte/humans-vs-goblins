package rpg.points;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import randomness.Pseudorandom;

class MagicPointsTest {

    @Test
    void testGetNumber() {
        System.out.println("getNumber");
        int expected = Pseudorandom.nextInt(MagicPoints.MAXIMUM_POINTS);
        MagicPoints mp = new MagicPoints(expected);
        int actual = mp.getNumber();
        assertEquals(expected, actual);
    }

    @Test
    void testCompareTo() {
        System.out.println("compareTo");
        int capacity = 10;
        List<Integer> numbers = new ArrayList<>(capacity);
        List<MagicPoints> actual = new ArrayList<>(capacity);
        int halfMax = MagicPoints.MAXIMUM_POINTS / 2;
        for (int i = 0; i < capacity; i++) {
            int number = Pseudorandom.nextInt(MagicPoints.MAXIMUM_POINTS
                    - halfMax - i);
            numbers.add(number);
            actual.add(new MagicPoints(number));
        }
        Collections.sort(numbers);
        List<MagicPoints> expected = new ArrayList<>(capacity);
        for (int n : numbers) {
            expected.add(new MagicPoints(n));
        }
        Collections.sort(actual);
        assertEquals(expected, actual);
    }

    @Test
    void testPlus() {
        System.out.println("plus");
        int halfMax = MagicPoints.MAXIMUM_POINTS / 2;
        int pointsA = Pseudorandom.nextInt(halfMax);
        int pointsB = Pseudorandom.nextInt(halfMax);
        int sum = pointsA + pointsB;
        MagicPoints mpA = new MagicPoints(pointsA);
        MagicPoints mpB = new MagicPoints(pointsB);
        MagicPoints expectation = new MagicPoints(sum);
        int expected = expectation.getNumber();
        int actual = mpA.plus(mpB).getNumber();
        int commutative = mpB.plus(mpA).getNumber();
        String msg = "MP " + pointsA + " + MP " + pointsB + " should be MP "
                + sum + ", likewise MP " + pointsB + " + MP " + pointsA;
        assertEquals(expected, actual, msg);
        assertEquals(actual, commutative, msg);
    }

    @Test
    void testToString() {
        System.out.println("toString");
        int n = Pseudorandom.nextInt(MagicPoints.MAXIMUM_POINTS);
        MagicPoints points = new MagicPoints(n);
        String expected = "MP " + n;
        String actual = points.toString();
        assertEquals(expected, actual);
    }

    @Test
    void testConstructorRejectsNumberBelowMinimum() {
        int tooLowPoints = MagicPoints.MINIMUM_POINTS
                - Pseudorandom.nextInt(100) - 1;
        String msg = "Should not be able to instantiate with " + tooLowPoints
                + " points, below minimum of " + MagicPoints.MINIMUM_POINTS;
        Throwable t = assertThrows(IllegalArgumentException.class, () -> {
            MagicPoints badPoints = new MagicPoints(tooLowPoints);
            System.out.println("Should not have instantiated " + badPoints
                    + " with " + tooLowPoints + " points");
        }, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Message should not be null";
        System.out.println("\"" + excMsg + "\"");
    }

    @Test
    void testConstructorRejectsNumberAboveMaximum() {
        int tooHighPoints = MagicPoints.MAXIMUM_POINTS
                + Pseudorandom.nextInt(100) + 1;
        String msg = "Should not be able to instantiate with " + tooHighPoints
                + " points, above maximum of " + MagicPoints.MAXIMUM_POINTS;
        Throwable t = assertThrows(IllegalArgumentException.class, () -> {
            MagicPoints badPoints = new MagicPoints(tooHighPoints);
            System.out.println("Should not have instantiated " + badPoints
                    + " with " + tooHighPoints + " points");
        }, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Message should not be null";
        System.out.println("\"" + excMsg + "\"");
    }

}
