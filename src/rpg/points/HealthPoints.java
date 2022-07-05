package rpg.points;

import arithmetic.Summable;

public class HealthPoints extends BoundedRangePoints
        implements Comparable<HealthPoints>, Summable<HealthPoints> {

    /**
     * Minimum health points (maximum deduction).
     */
    public static final int MINIMUM_POINTS = -100;

    /**
     * Minimum health for a player to be considered alive (active) in the game.
     */
    public static final int MINIMUM_POINTS_FOR_ALIVE = 1;

    /**
     * Maximum health points.
     */
    public static final int MAXIMUM_POINTS = 100;

    public int getNumber() {
        return this.points;
    }

    @Override
    public int compareTo(HealthPoints hp) {
        return Integer.compare(this.points, hp.points);
    }

    @Override
    public HealthPoints plus(HealthPoints addend) {
        return new HealthPoints(this.points + addend.points);
    }

    @Override
    public String toString() {
        return "HP " + this.points;
    }

    public HealthPoints(int pts) {
        super(pts);
        if (pts < MINIMUM_POINTS || pts > MAXIMUM_POINTS) {
            String excMsg = pts + " is outside the range " + MINIMUM_POINTS
                    + " to " + MAXIMUM_POINTS;
            throw new IllegalArgumentException(excMsg);
        }
    }

}
