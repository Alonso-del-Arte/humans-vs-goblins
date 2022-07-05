package rpg.points;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import randomness.Pseudorandom;

class HealthPointsTest {

    @Test
    void testGetNumber() {
        System.out.println("getNumber");
        int expected = Pseudorandom.nextInt(HealthPoints.MAXIMUM_POINTS);
        HealthPoints hp = new HealthPoints(expected);
        int actual = hp.getNumber();
        assertEquals(expected, actual);
    }

    @Test
    void testCompareTo() {
        System.out.println("compareTo");
        int capacity = 10;
        List<Integer> numbers = new ArrayList<>(capacity);
        List<HealthPoints> actual = new ArrayList<>(capacity);
        int halfMax = HealthPoints.MAXIMUM_POINTS / 2;
        for (int i = 0; i < capacity; i++) {
            int number = Pseudorandom.nextInt(HealthPoints.MAXIMUM_POINTS
                    - halfMax - i);
            numbers.add(number);
            actual.add(new HealthPoints(number));
        }
        Collections.sort(numbers);
        List<HealthPoints> expected = new ArrayList<>(capacity);
        for (int n : numbers) {
            expected.add(new HealthPoints(n));
        }
        Collections.sort(actual);
        assertEquals(expected, actual);
    }

    @Test
    void testPlus() {
        System.out.println("plus");
        int halfMax = HealthPoints.MAXIMUM_POINTS / 2;
        int pointsA = Pseudorandom.nextInt(halfMax);
        int pointsB = Pseudorandom.nextInt(halfMax);
        int sum = pointsA + pointsB;
        HealthPoints hpA = new HealthPoints(pointsA);
        HealthPoints hpB = new HealthPoints(pointsB);
        HealthPoints expectation = new HealthPoints(sum);
        int expected = expectation.getNumber();
        int actual = hpA.plus(hpB).getNumber();
        int commutative = hpB.plus(hpA).getNumber();
        String msg = "HP " + pointsA + " + HP " + pointsB + " should be HP "
                + sum + ", likewise HP " + pointsB + " + HP " + pointsA;
        assertEquals(expected, actual, msg);
        assertEquals(actual, commutative, msg);
    }

    @Test
    void testToString() {
        System.out.println("toString");
        int n = Pseudorandom.nextInt(HealthPoints.MAXIMUM_POINTS);
        HealthPoints points = new HealthPoints(n);
        String expected = "HP " + n;
        String actual = points.toString();
        assertEquals(expected, actual);
    }

    @Test
    void testConstructorRejectsNumberBelowMinimum() {
        int tooLowPoints = HealthPoints.MINIMUM_POINTS
                - Pseudorandom.nextInt(100) - 1;
        String msg = "Should not be able to instantiate with " + tooLowPoints
                + " points, below minimum of " + HealthPoints.MINIMUM_POINTS;
        Throwable t = assertThrows(IllegalArgumentException.class, () -> {
            HealthPoints badPoints = new HealthPoints(tooLowPoints);
            System.out.println("Should not have instantiated " + badPoints
                    + " with " + tooLowPoints + " points");
        }, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Message should not be null";
        System.out.println("\"" + excMsg + "\"");
    }

    @Test
    void testConstructorRejectsNumberAboveMaximum() {
        int tooHighPoints = HealthPoints.MAXIMUM_POINTS
                + Pseudorandom.nextInt(100) + 1;
        String msg = "Should not be able to instantiate with " + tooHighPoints
                + " points, above maximum of " + HealthPoints.MAXIMUM_POINTS;
        Throwable t = assertThrows(IllegalArgumentException.class, () -> {
            HealthPoints badPoints = new HealthPoints(tooHighPoints);
            System.out.println("Should not have instantiated " + badPoints
                    + " with " + tooHighPoints + " points");
        }, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Message should not be null";
        System.out.println("\"" + excMsg + "\"");
    }

}
