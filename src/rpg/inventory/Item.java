package rpg.inventory;

import rpg.Position;
import rpg.RelativePosition;
import rpg.points.HealthPoints;
import rpg.points.MagicPoints;

public abstract class Item {

    static final HealthPoints ZERO_HEALTH_POINTS = new HealthPoints(0);

    static final MagicPoints ZERO_MAGIC_POINTS = new MagicPoints(0);

    public boolean isOneTimeUse() {
        return true;
    }

    public HealthPoints prerequisiteHealth() {
        return ZERO_HEALTH_POINTS;
    }

    public MagicPoints prerequisiteMagic() {
        return ZERO_MAGIC_POINTS;
    }

    public HealthPoints additionalHealth() {
        return ZERO_HEALTH_POINTS;
    }

    public MagicPoints additionalMagic() {
        return ZERO_MAGIC_POINTS;
    }

    public HealthPoints deductHealthFromOpponent() {
        return ZERO_HEALTH_POINTS;
    }

    public MagicPoints deductMagicFromOpponent() {
        return ZERO_MAGIC_POINTS;
    }

}
