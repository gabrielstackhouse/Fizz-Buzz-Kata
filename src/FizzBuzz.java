import java.util.*;

/**
 * Public API for a basic FizzBuzz implementation. It allows for three modes of
 * play: classic Fizz Buzz, Fizz Buzz Pop, and Fizz Buzz Custom, which allows
 * for user-defined substitutions.
 *
 * @author Gabriel Stackhouse
 */
public class FizzBuzz {

    // Instance variables
    private ArrayList<Substitution> substitutions;  // User-defined
                                                    // substitutions

    /**
     * Constructor with no parameters
     */
    public FizzBuzz() {
        substitutions = new ArrayList<Substitution>();
    }

    /**
     * Add a substitution to use when playing Fizz Buzz Custom.
     * If a substitution with the same divisor already exists, it will be
     * replaced with the new one.
     * @param divisor - divisor to check for multiples of
     * @param phrase - phrase to replace multiples of divisor with
     */
    public void addSubstitution(int divisor, String phrase) {
        addSubstitution(new Substitution(divisor, phrase));
    }

    /**
     * Add a substitution to use when playing Fizz Buzz Custom
     * @param sub - the Substitution to add
     */
    public void addSubstitution(Substitution sub) {

        // Check if Substitution with the same divisor already exists, and
        // remove it if it does
        int subIndex = substitutions.indexOf(sub);
        if(subIndex >= 0) {
            substitutions.remove(subIndex);
        }

        // Add substitution to list, then sort by divisors
        substitutions.add(sub);
        Collections.sort(substitutions);
    }

    /**
     * Given a divisor, returns the phrase that multiples will be replaced with
     * when playing Fizz Buzz Custom.
     * @param divisor - the divisor to look up
     * @return - the phrase that will replace, or null if substitution doesn't
     *           exist.
     */
    public String getSubstitutionPhrase(int divisor) {

        // Create dummy Substitution for ease of comparing
        Substitution sub = new Substitution(divisor, "");

        // Check if Substitution exists, and return its phrase if it does
        int subIndex = substitutions.indexOf(sub);
        if(subIndex >= 0) {
            return substitutions.get(subIndex).getPhrase();
        }
        return null;
    }

    /**
     * Takes any number and returns the correct answer for that number per the
     * rules of Fizz Buzz.
     * @param num - The number to play
     * @return "fizz" for multiples of 3, "buzz" for multiples of 5, "fizz
     *          buzz" for multiples of 3 and 5, or num otherwise.
     */
    public String playClassic(int num) {
        if(num % 3 == 0 && num % 5 == 0) {
            return "fizz buzz";
        }
        else if (num % 3 == 0) {
            return "fizz";
        }
        else if (num % 5 == 0) {
            return "buzz";
        }
        else {
            return Integer.toString(num);
        }
    }

    /**
     *
     * @param num
     * @return
     */
    public String playCustom(int num) {

        // Instantiate initial empty string
        String result = "";

        // Iterate through substitutions list, appending phrase to string
        // whenever a multiple is found
        for(int i = 0; i < substitutions.size(); i++) {

            // If it's a multiple and string is empty, simply add the phrase
            // to the string
            if(num % substitutions.get(i).getDivisor() == 0 &&
                    result.isEmpty()) {
                result += substitutions.get(i).getPhrase();
            }

            // If it's a multiple and the string already has phrases, we must
            // add a space first
            else if(num % substitutions.get(i).getDivisor() == 0) {
                result += " " + substitutions.get(i).getPhrase();
            }
        }

        // If string is empty, no multiples were found, so just return number
        if(result.isEmpty()) {
            return Integer.toString(num);
        }
        return result;
    }

    /**
     * Takes any number and returns the correct answer for that number per the
     * rules of Fizz Buzz Pop.
     * @param num - The number to play
     * @return "fizz" for multiples of 3, "buzz" for multiples of 5, "fizz
     *          buzz" for multiples of 3 and 5, or num otherwise.
     */
    public String playPop(int num) {
        if(num % 3 == 0 && num % 5 == 0 && num % 7 == 0) {
            return "fizz buzz pop";
        }
        else if (num % 3 == 0 && num % 7 == 0) {
            return "fizz pop";
        }
        else if (num % 5 == 0 && num % 7 == 0) {
            return "buzz pop";
        }
        else if (num % 7 == 0) {
            return "pop";
        }
        else {
            return Integer.toString(num);
        }
    }

    /**
     * Remove the substitution for the given divisor when playing Fizz Buzz
     * Custom.
     * @return - the substitution removed, or null if none were removed
     */
    public Substitution removeSubstitution(int divisor) {

        // Create dummy Substitution for ease of comparing
        Substitution sub = new Substitution(divisor, "");

        // Check if substitution exists, and remove if it does
        int subIndex = substitutions.indexOf(sub);
        if(subIndex >= 0) {
            return substitutions.remove(subIndex);
        }
        return null;
    }
}
