/**
 * Container class to hold a user-generated substitution for FizzBuzz. Pairs
 * the divisor and the phrase the number is to be replaced with.
 *
 * @author Gabriel Stackhouse
 */
public class Substitution implements Comparable<Substitution> {

    // Instance variables
    private int divisor;
    private String phrase;

    /**
     * Constructor to create a substitution
     * @param divisor - Number to look for multiples of
     * @param phrase - Phrase to use if multiples are found
     */
    public Substitution(int divisor, String phrase) {
        this.divisor = divisor;
        this.phrase = phrase;
    }

    /**
     * Get the divisor
     * @return - the divisor
     */
    public int getDivisor() {
        return divisor;
    }

    /**
     * Get the phrase
     * @return - the phrase
     */
    public String getPhrase() {
        return phrase;
    }

    /**
     * A Substitution gets compared by its divisor
     * @param other - the Substitution we are comparing
     * @return
     */
    @Override
    public int compareTo(Substitution other) {
        return this.getDivisor() - other.getDivisor();
    }

    /**
     * A Substitution is equal to another if both have the same divisor
     * @param o - the Substitution we are comparing
     * @return - true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {

        // Check if the object is itself
        if( o == this) {
            return true;
        }

        // Check if o is an instance of Substitution, and cast if it is
        if(!(o instanceof Substitution)) {
            return false;
        }
        Substitution other = (Substitution) o;

        // Check for equality of divisors
        return this.getDivisor() == other.getDivisor();
    }
}
