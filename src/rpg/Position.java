package rpg;

public class Position {

    private final int coordX, coordY;

    @Override
    public String toString() {
        return "(" + this.coordX + ", " + this.coordY + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }
        Position other = (Position) obj;
        return this.coordX == other.coordX && this.coordY == other.coordY;
    }

    @Override
    public int hashCode() {
        return (this.coordX << 16) + this.coordY;
    }

    public Position offset(RelativePosition adjustment) {
        return new Position(this.coordX + adjustment.offsetX,
                this.coordY + adjustment.offsetY);
    }

    public Position(int x, int y) {
        this.coordX = x;
        this.coordY = y;
    }

}
