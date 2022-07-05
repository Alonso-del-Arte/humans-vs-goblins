package rpg.points;

// TODO: Figure out elegant way to use type system so that HealthPoints and
//  MagicPoints don't need to implement Comparable or Summable directly
public abstract class BoundedRangePoints {

    final int points;

//    abstract Range getRange();

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
        return this.points == ((BoundedRangePoints) obj).points;
    }

    @Override
    public int hashCode() {
        return this.getClass().getSimpleName().hashCode() + this.points;
    }

    BoundedRangePoints(int pts) {
        this.points = pts;
    }

}
