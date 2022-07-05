package rpg;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import randomness.Pseudorandom;

class ViewRectangleTest {

    @Test
    void testConstructorRejectsSouthEastActuallySouthWestOfNorthWest() {
        int northwestNorth = Pseudorandom.nextInt(128);
        int northwestWest = Pseudorandom.nextInt(128);
        Position northwest = new Position(northwestNorth, northwestWest);
        int southeastSouth = northwestNorth + Pseudorandom.nextInt(128) + 1;
        int southeastEast = northwestWest - Pseudorandom.nextInt(64) - 1;
        Position southeast = new Position(southeastSouth, southeastEast);
        Throwable t = assertThrows(IllegalArgumentException.class, () -> {
            ViewRectangle badRectangle = new ViewRectangle(northwest, southeast);
            System.out.println("Made rectangle " + badRectangle
                    + " with northwest at " + northwest + " and southeast at "
                    + southeast);
        });
        String excMsg = t.getMessage();
        assert excMsg != null : "Message should not be null";
        System.out.println("\"" + excMsg + "\"");
    }

    @Test
    void testConstructorRejectsSouthEastActuallyNorthEastOfNorthWest() {
        int northwestNorth = Pseudorandom.nextInt(128);
        int northwestWest = Pseudorandom.nextInt(128);
        Position northwest = new Position(northwestNorth, northwestWest);
        int southeastSouth = northwestNorth - Pseudorandom.nextInt(64) - 1;
        int southeastEast = northwestWest + Pseudorandom.nextInt(128) + 1;
        Position southeast = new Position(southeastSouth, southeastEast);
        Throwable t = assertThrows(IllegalArgumentException.class, () -> {
            ViewRectangle badRectangle = new ViewRectangle(northwest, southeast);
            System.out.println("Made rectangle " + badRectangle
                    + " with northwest at " + northwest + " and southeast at "
                    + southeast);
        });
        String excMsg = t.getMessage();
        assert excMsg != null : "Message should not be null";
        System.out.println("\"" + excMsg + "\"");
    }

}
