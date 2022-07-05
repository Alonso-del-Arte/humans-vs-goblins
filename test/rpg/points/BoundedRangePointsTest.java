package rpg.points;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import randomness.Pseudorandom;

class BoundedRangePointsTest {

    @Test
    void testReferentialEquality() {
        int n = Pseudorandom.nextInt(100);
        BoundedRangePoints points = new BoundedRangePointsImpl(n);
        assertEquals(points, points);
    }

    private static Object wrappedNull() {
        return null;
    }

    @Test
    void testNotEqualsNull() {
        int n = Pseudorandom.nextInt(100);
        BoundedRangePoints points = new BoundedRangePointsImpl(n);
        assertNotEquals(points, wrappedNull());
    }

    @Test
    void testNotEqualsDiffClass() {
        int n = Pseudorandom.nextInt(100);
        BoundedRangePoints pointsImpl = new BoundedRangePointsImpl(n);
        BoundedRangePoints pointsAnon = new BoundedRangePoints(n) {

            @Override
            public String toString() {
                return "Anonymous points: " + this.points;
            }

        };
        assertNotEquals(pointsImpl, pointsAnon);
    }

    @Test
    void testNotEqualsDiffPoints() {
        int n = Pseudorandom.nextInt(100);
        BoundedRangePoints pointsA = new BoundedRangePointsImpl(n);
        BoundedRangePoints pointsB = new BoundedRangePointsImpl(n + 1);
        assertNotEquals(pointsA, pointsB);
    }

    @Test
    void testEquals() {
        System.out.println("equals");
        int n = Pseudorandom.nextInt(100);
        BoundedRangePoints somePoints = new BoundedRangePointsImpl(n);
        BoundedRangePoints samePoints = new BoundedRangePointsImpl(n);
        assertEquals(somePoints, samePoints);
    }

    @Test
    void testHashCode() {
        System.out.println("hashCode");
        int expected = 100;
        Set<Integer> hashes = new HashSet<>(expected);
        for (int i = 0; i < expected; i++) {
            hashes.add(new BoundedRangePointsImpl(i).hashCode());
        }
        int actual = hashes.size();
        String msg = "Distinct point objects should get distinct hash codes";
        assertEquals(expected, actual, msg);
    }

    @Test
    void testDiffHashCodeDiffClass() {
        int n = Pseudorandom.nextInt(100);
        BoundedRangePoints pointsImpl = new BoundedRangePointsImpl(n);
        BoundedRangePoints pointsAnon = new BoundedRangePoints(n) {

            @Override
            public String toString() {
                return "Points anonymous: " + this.points;
            }

        };
        String msg = pointsImpl + " should have a different hash code from "
                + pointsAnon + "'s hash code";
        assertNotEquals(pointsImpl.hashCode(), pointsAnon.hashCode(), msg);
    }

    private static class BoundedRangePointsImpl
            extends BoundedRangePoints {

        @Override
        public String toString() {
            return "Points implemented: " + this.points;
        }

        BoundedRangePointsImpl(int points) {
            super(points);
        }

    }

}
