package sieve;

import java.util.Arrays;

/**
 * Implementation of the Sieve of Eratosthenes algorithm for checking if a
 * number is prime or not. The implementation is lacking in error-checking
 * and optimization, and needs some patching up!
 *
 * @author Tomas
 * @version 2020-11-11
 */
public class Sieve {

    private static final int HARDLIMIT = (int) Math.pow(2, 26);             // the highest number allowed to be tested for primality.

    private boolean[] primeCache = new boolean[0];

    /**
     * Check if a number is prime or not!
     * If a number is already calculated return a duplicated array that holds
     * value for previous calculations. If not, check the primality of the number
     * and update the duplicate array.
     *
     * Note that prime[n] denotes the primality of number n.
     *
     * @param number An integer value to be checked for primality.
     * @return true if number is prime, false otherwise.
     */
    public boolean isPrime(int number) {

        exceptionIfIllegalArg(number);

        if ( number >= primeCache.length ) {
            boolean[] prime = sieve(number);
            return prime[number];
        }

        return primeCache[number];


       // boolean[] prime = sieve(number);
       // return prime[number];
    }

    /**
     * Check if a number is exception bound.
     *
     * @param number An integer value to be checked for exception.
     */
    private void exceptionIfIllegalArg(int number) throws IllegalArgumentException {
        if (number < 2 || number > HARDLIMIT)
            throw new IllegalArgumentException("The input number has to be in the range between 2 and 2^26");

    }
    /**
     * Calculate the array of a number. A duplicate array is set
     * to hold already calculated values.
     *
     * @param number An integer whose array is to be calculated.
     * @return the array of a number whose primality is to be checked.
     */
    private boolean[] sieve(int number) {
        boolean[] prime = new boolean[number + 1]; // + 1 because of 0-indexing
        Arrays.fill(prime, true); // assume all numbers are prime
        int sqrt = (int) Math.floor(Math.sqrt(number));
        for (int i = 2; i <= sqrt; i++) {
            if (prime[i]) {
                for (int j = i * 2; j < prime.length; j += i) {
                    prime[j] = false; // mark multiples of i as not prime
                    }
                }
            }
        primeCache = prime;
        return primeCache;
        }

}



