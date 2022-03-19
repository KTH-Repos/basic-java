package sieve;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.lang.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


/**
 * Test class the Sieve class.
 *
 * @author Tomas
 * @version 2020-11-11
 */

public class SieveTest {
    private Sieve sieve;
    private static final int HARDLIMIT = (int) Math.pow(2, 26);

    /**
     * Instantiate a sieve.
     */
    @Before
    public void setUp() {
        sieve = new Sieve();
    }

    /**
     * Test that the lowest boundary is prime
     */
    @Test
    public void isPrimeTrueWhenNumberIsTwo() {
        assertTrue(sieve.isPrime(2));
    }

    /**
     * Test that some prime numbers are prime
     */
    @Test
    public void isPrimeTrueWhenNumberIsPrime() {
        boolean threeIsPrime = sieve.isPrime(3);
        boolean ninetySevenIsPrime = sieve.isPrime(97);
        boolean sevenIsPrime = sieve.isPrime(7);
        boolean fiveIsPrime = sieve.isPrime(5);

        assertTrue(threeIsPrime);
        assertTrue(ninetySevenIsPrime);
        assertTrue(sevenIsPrime);
        assertTrue(fiveIsPrime);
    }

    /**
     * Test that composite numbers are not prime.
     */
    @Test
    public void isPrimeFalseWhenNumberIsComposite() {
        boolean fourIsPrime = sieve.isPrime(4);
        boolean nineHundredThreeIsPrime = sieve.isPrime(903);
        boolean sixIsPrime = sieve.isPrime(6);
        boolean thirtyFiveIsPrime = sieve.isPrime(35);

        assertFalse(fourIsPrime);
        assertFalse(nineHundredThreeIsPrime);
        assertFalse(sixIsPrime);
        assertFalse(thirtyFiveIsPrime);
    }

    /**
     * Test that sieve returns the prime numbers when passed incrementing values.
     */
    @Test
    public void isPrimeWorksWhenPassedIncrementingValues() {
        boolean twoIsPrime = sieve.isPrime(2);
        boolean threeIsPrime = sieve.isPrime(3);
        boolean fourIsPrime = sieve.isPrime(4);
        boolean fiveIsPrime = sieve.isPrime(5);
        boolean sixIsPrime = sieve.isPrime(6);
        boolean sevenIsPrime = sieve.isPrime(7);
        boolean eightIsPrime = sieve.isPrime(8);
        boolean nineIsPrime = sieve.isPrime(9);

        assertTrue(twoIsPrime);
        assertTrue(threeIsPrime);
        assertFalse(fourIsPrime);
        assertTrue(fiveIsPrime);
        assertFalse(sixIsPrime);
        assertTrue(sevenIsPrime);
        assertFalse(eightIsPrime);
        assertFalse(nineIsPrime);
    }

    /**
     * Test that one is exception bound.
     */
    @Test(expected=IllegalArgumentException.class)
    public void isPrimeExceptionWhenNumberIsOne()  {
        boolean oneIsPrime = sieve.isPrime(1);


    }
    /**
     * Test that minus ten is exception bound.
     */
    @Test(expected=IllegalArgumentException.class)
    public void isPrimeExceptionWhenNumberIsMinusTen() {
        boolean minusTenIsPrime = sieve.isPrime(-10);
    }

    /**
     * Test that the highest limit is not prime.
     */
    @Test
    public void isPrimeFalseWhenNumberIs2Pow26(){
        boolean twoPow26IsPrime = sieve.isPrime(HARDLIMIT);

        assertFalse(twoPow26IsPrime);
    }

    /**
     * Test a large number out of range.
     */
    @Test(expected=IllegalArgumentException.class)
    public void isPrimeExceptionWhenNumberIs2Pow26Plus1(){
        boolean twoPow26Plus1 = sieve.isPrime(HARDLIMIT + 1);
    }

    /**
     * Test a large number out of range.
     */
    @Test(expected=IllegalArgumentException.class)
    public void isPrimeExceptionWhenNumberIs2Pow28(){
        boolean twoPow28 = sieve.isPrime((int)Math.pow(2,28));
    }

}

