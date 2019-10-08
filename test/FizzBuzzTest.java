import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {

    // Instance variables
    private FizzBuzz fizzbuzz;

    /**
     * Runs before each test, creating an empty Fizz Buzz game
     */
    @Before
    public void initialize() {
        fizzbuzz = new FizzBuzz();
    }

    /**
     * Test adding a substitution with a divisor that has already been added
     */
    @Test
    public void addDuplicateSubstitution() {
        fizzbuzz.addSubstitution(2, "Expelliarmus");
        assertEquals("Expelliarmus", fizzbuzz.getSubstitutionPhrase(2));
        fizzbuzz.addSubstitution(2, "Wingardium Leviosa");
        assertEquals("Wingardium Leviosa", fizzbuzz.getSubstitutionPhrase(2));
    }

    /**
     * Test addSubstitution method using two parameters
     */
    @Test
    public void addSubstitutionTwoParameters() {

        // Add substitutions
        fizzbuzz.addSubstitution(2, "Expelliarmus");
        fizzbuzz.addSubstitution(3, "Avada Kedavra");
        fizzbuzz.addSubstitution(1, "Confundus");

        // Test additions
        assertEquals("Expelliarmus", fizzbuzz.getSubstitutionPhrase(2));
        assertEquals("Avada Kedavra", fizzbuzz.getSubstitutionPhrase(3));
        assertEquals("Confundus", fizzbuzz.getSubstitutionPhrase(1));
        assertNull(fizzbuzz.getSubstitutionPhrase(4));
    }

    /**
     * Test addSubstitution method using one parameter
     */
    @Test
    public void addSubstitutionOneParameter() {
        Substitution sub = new Substitution(2, "Expelliarmus");
        fizzbuzz.addSubstitution(sub);
        assertEquals("Expelliarmus", fizzbuzz.getSubstitutionPhrase(2));
        assertNull(fizzbuzz.getSubstitutionPhrase(1));
    }

    /**
     * Test Fizz Buzz Classic with multiples of three
     */
    @Test
    public void playClassicMultiplesOfThree() {
        assertEquals("fizz", fizzbuzz.playClassic(3));
        assertEquals("fizz", fizzbuzz.playClassic(6));
        assertEquals("fizz", fizzbuzz.playClassic(336));
    }

    /**
     * Test Fizz Buzz Classic with multiples of five
     */
    @Test
    public void playClassicMultiplesOfFive() {
        assertEquals("buzz", fizzbuzz.playClassic(5));
        assertEquals("buzz", fizzbuzz.playClassic(10));
        assertEquals("buzz", fizzbuzz.playClassic(335));
    }

    /**
     * Test Fizz Buzz Classic with multiples of three and five
     */
    @Test
    public void playClassicMultiplesOfThreeAndFive() {
        assertEquals("fizz buzz", fizzbuzz.playClassic(15));
        assertEquals("fizz buzz", fizzbuzz.playClassic(30));
        assertEquals("fizz buzz", fizzbuzz.playClassic(1530));
    }

    /**
     * Test Fizz Buzz Classic when no multiples of three or five are found
     */
    @Test
    public void playClassicNoMultiples() {
        assertEquals("2", fizzbuzz.playClassic(2));
        assertEquals("7", fizzbuzz.playClassic(7));
    }

    /**
     * Test Fizz Buzz Custom where different rules are implemented
     */
    @Test
    public void playCustomWithDifferentRules() {

        // Add rules
        fizzbuzz.addSubstitution(4, "expelliarmus");
        fizzbuzz.addSubstitution(6, "accio");
        fizzbuzz.addSubstitution(7, "lumos");

        // Test rules with only one multiple
        assertEquals("expelliarmus", fizzbuzz.playCustom(4));
        assertEquals("accio", fizzbuzz.playCustom(6));
        assertEquals("lumos", fizzbuzz.playCustom(7));

        // Test chaining rules together with common multiples
        assertEquals("expelliarmus accio", fizzbuzz.playCustom(12));
        assertEquals("expelliarmus lumos", fizzbuzz.playCustom(28));
        assertEquals("accio lumos", fizzbuzz.playCustom(42));
        assertEquals("expelliarmus accio lumos", fizzbuzz.playCustom(84));

        // Test when no multiples are found
        assertEquals("3", fizzbuzz.playCustom(3));
        assertEquals("191", fizzbuzz.playCustom(191));
    }

    /**
     * Test Fizz Buzz Custom where the normal Fizz Buzz rules are implemented
     */
    @Test
    public void playCustomWithNormalRules() {

        // Define normal Fizz Buzz rules into our custom game
        fizzbuzz.addSubstitution(3, "fizz");
        fizzbuzz.addSubstitution(5, "buzz");

        // Test that Fizz Buzz Custom now plays exactly like Classic
        assertEquals("fizz", fizzbuzz.playCustom(3));
        assertEquals("buzz", fizzbuzz.playCustom(5));
        assertEquals("fizz buzz", fizzbuzz.playCustom(15));
        assertEquals("7", fizzbuzz.playCustom(7));
    }

    /**
     * Test that inserting rules out of order does not affect how they are
     * applied. They will always be applied in ascending order.
     */
    @Test
    public void playCustomWithNormalRulesReversed() {

        // Define normal Fizz Buzz rules into our custom game
        fizzbuzz.addSubstitution(5, "buzz");
        fizzbuzz.addSubstitution(3, "fizz");

        // Test that Fizz Buzz Custom now plays exactly like Classic
        assertEquals("fizz", fizzbuzz.playCustom(3));
        assertEquals("buzz", fizzbuzz.playCustom(5));
        assertEquals("fizz buzz", fizzbuzz.playCustom(15));
        assertEquals("7", fizzbuzz.playCustom(7));
    }

    /**
     * Test Fizz Buzz Pop with multiples of seven
     */
    @Test
    public void playPopMultiplesOfSeven() {
        assertEquals("pop", fizzbuzz.playPop(7));
        assertEquals("pop", fizzbuzz.playPop(14));
        assertEquals("pop", fizzbuzz.playPop(133));
    }

    /**
     * Test Fizz Buzz Pop with multiples of three and seven
     */
    @Test
    public void playPopMultiplesOfThreeAndSeven() {
        assertEquals("fizz pop", fizzbuzz.playPop(21));
        assertEquals("fizz pop", fizzbuzz.playPop(42));
        assertEquals("fizz pop", fizzbuzz.playPop(126));
    }

    /**
     * Test Fizz Buzz Pop with multiples of five and seven
     */
    @Test
    public void playPopMultiplesOfFiveAndSeven() {
        assertEquals("buzz pop", fizzbuzz.playPop(35));
        assertEquals("buzz pop", fizzbuzz.playPop(70));
        assertEquals("buzz pop", fizzbuzz.playPop(595));
    }

    /**
     * Test Fizz Buzz Pop with multiples of three, five, and seven
     */
    @Test
    public void playPopMultiplesOfThreeFiveAndSeven() {
        assertEquals("fizz buzz pop", fizzbuzz.playPop(105));
        assertEquals("fizz buzz pop", fizzbuzz.playPop(210));
        assertEquals("fizz buzz pop", fizzbuzz.playPop(2730));
    }

    /**
     * Test Fizz Buzz Pop when no multiples of three, five, or seven are found
     */
    @Test
    public void playPopNoMultiples() {
        assertEquals("2", fizzbuzz.playPop(2));
        assertEquals("137", fizzbuzz.playPop(137));
    }

    /**
     * Test removing a substitution from Fizz Buzz Custom
     */
    @Test
    public void removeSubstitution() {
        assertNull(fizzbuzz.getSubstitutionPhrase(2));
        fizzbuzz.addSubstitution(2, "Expelliarmus");
        assertEquals("Expelliarmus", fizzbuzz.getSubstitutionPhrase(2));
        fizzbuzz.removeSubstitution(2);
        assertNull(fizzbuzz.getSubstitutionPhrase(2));
    }

}
