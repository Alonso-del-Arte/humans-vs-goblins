package rpg;

import arithmetic.Summable;

public class RelativePosition implements Summable<RelativePosition> {

    final int offsetX, offsetY;

    @Override
    public String toString() {
        return "(" + this.offsetX + ", " + this.offsetY + ")";
    }

    // TODO: Write tests for this
    @Override
    public RelativePosition plus(RelativePosition addend) {
        return this;
    }

    public RelativePosition(int x, int y) {
        this.offsetX = x;
        this.offsetY = y;
    }

}
