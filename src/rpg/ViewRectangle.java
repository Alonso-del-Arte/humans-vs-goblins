package rpg;

public class ViewRectangle {

    // TODO: Write test for this
    public Position getNorthwest() {
        return new Position(Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    // TODO: Write test for this
    public Position getSoutheast() {
        return new Position(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public ViewRectangle(Position northwest, Position southeast) {
        int diffEastWest = southeast.coordY - northwest.coordY;
        int diffSouthNorth = southeast.coordX - northwest.coordX;
        if (diffEastWest <= 0 || diffSouthNorth <= 0) {
            String excMsg = "Southeast " + southeast
                    + " should be southeast of northwest " + northwest;
            throw new IllegalArgumentException(excMsg);
        }
    }

}
