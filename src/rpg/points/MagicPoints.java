package rpg.points;

import arithmetic.Summable;

public class MagicPoints extends BoundedRangePoints
        implements Comparable<MagicPoints>, Summable<MagicPoints> {

    /**
     * Minimum magic points (maximum deduction).
     */
    public static final int MINIMUM_POINTS = -100;

    /**
     * Minimum magic for a player to be able to use magic.
     */
    public static final int MINIMUM_POINTS_FOR_MAGIC = 1;

    /**
     * Maximum magic points.
     */
    public static final int MAXIMUM_POINTS = 100;

    public int getNumber() {
        return this.points;
    }

    @Override
    public int compareTo(MagicPoints mp) {
        return Integer.compare(this.points, mp.points);
    }

    @Override
    public MagicPoints plus(MagicPoints addend) {
        return new MagicPoints(this.points + addend.points);
    }

    @Override
    public String toString() {
        return "MP " + this.points;
    }

    public MagicPoints(int pts) {
        super(pts);
        if (pts < MINIMUM_POINTS || pts > MAXIMUM_POINTS) {
            String excMsg = pts + " is outside the range " + MINIMUM_POINTS
                    + " to " + MAXIMUM_POINTS;
            throw new IllegalArgumentException(excMsg);
        }
    }

}
