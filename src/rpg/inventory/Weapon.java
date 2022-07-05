package rpg.inventory;

public abstract class Weapon extends Item {

    @Override
    public boolean isOneTimeUse() {
        return false;
    }

}
