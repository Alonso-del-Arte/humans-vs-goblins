package randomness;

import java.util.Random;

// TODO: Write static wrappers for Pseudorandomness's functions

/**
 * Provides an easy way to access <code>Pseudorandomness</code> functions
 * without having to create a new instance each time.
 * @author Alonso del Arte
 */
public class Pseudorandom {

    private static final Random RANDOM = new Random();

    // TODO: Write tests for this
    public static int nextInt() {
        return 0;
    }

    // TODO: Change this to use external API through Pseudorandomness
    public static int nextInt(int bound) {
        return RANDOM.nextInt(bound);
    }

    public static CoinSide flipCoin() {
        if (RANDOM.nextInt() % 2 == 0) {
            return CoinSide.HEADS;
        } else {
            return CoinSide.TAILS;
        }
    }

}
