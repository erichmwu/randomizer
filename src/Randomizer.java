/**
 * This example is from _Java Examples in a Nutshell_. (http://www.oreilly.com)
 * Copyright (c) 1997 by David Flanagan
 * This example is provided WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, modify, and distribute it for non-commercial purposes.
 * For any commercial use, see http://www.davidflanagan.com/javaexamples
 *
 * This class defines methods for computing pseudo-random numbers, and it defines
 * the state variable that needs to be maintained for use by those methods.
 */
public class Randomizer {
  // Carefully chosen constants from the book "Numerical Recipes in C".
  // All "static final" fields are constants.
  static final int MODULUS = 233280;    // the "modulus"
  static final int MULTIPLIER = 9301;   // the "multiplier"
  static final int INCREMENT = 49297;   // the "increment"

  // The state variable maintained by each Randomizer instance
  private long seed = 1;

  /**
   * The constructor for the Randomizer() class.  It must be passed some
   * arbitrary initial value or "seed" for its pseudo-randomness.
   *
   * @param seed a initial value used to create a pseudo-randomness for our randomizer.
   */
  public Randomizer(long seed) {
    this.seed = seed;
  }

  /**
   * This method computes a pseudo-random number between 0 and 1 using a very
   * simple algorithm.  Math.random() and java.util.Random are actually a lot
   * better at computing randomness.
   *
   * @return a pseudo-random number between 0 and 1.
   */
  public float randomFloat() {
    seed = (seed * MULTIPLIER + INCREMENT) % MODULUS;
    return (float) seed / (float) MODULUS;
  }

  /**
   * This method computes a pseudo-random integer between 0 and specified
   * maximum.  It uses randomFloat() above.
   *
   * @param max the maximum value for the method to generate a number to.
   * @return a pseudo-random integer from 0 to max.
   */
  public int randomInt(int max) {
    return Math.round(max * randomFloat());
  }

  /**
   * This nested class is a simple test program: it prints 10 random integers.
   * Note how the Randomizer object is seeded using the current time.
   */
  public static class Test {
    /**
     * A main method for testing our Randomizer class.
     *
     * @param args ignored.
     */
    public static void main(String[] args) {
      Randomizer r = new Randomizer(new java.util.Date().getTime());
      for (int i = 0; i < 10; i++) {
        System.out.println(r.randomInt(100));
      }
    }
  }
}