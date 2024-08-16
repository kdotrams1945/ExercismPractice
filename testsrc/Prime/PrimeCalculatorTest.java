package Prime;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeCalculatorTest {
    @Test
    public void testPrime1() {
        PrimeCalculator prime = new PrimeCalculator();
        assertTrue(prime.isPrime(2));
        assertTrue(prime.isPrime(3));
        assertFalse(prime.isPrime(4));
        assertTrue(prime.isPrime(5));
        assertFalse(prime.isPrime(6));

        assertFalse(prime.isPrime(8));
        assertTrue(prime.isPrime(41));
    }

    @Test
    public void testPrime2() {
        PrimeCalculator prime = new PrimeCalculator();
        assertEquals(2, prime.nth(1));
        assertEquals(3, prime.nth(2));
        assertEquals(5, prime.nth(3));
        assertEquals(23, prime.nth(9));
        assertEquals(37, prime.nth(12));
    }

    @Test
    public void someFun() {
        int[] primeArray = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41
                , 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        for (int i = 0; i < primeArray.length; i++) {
            assertEquals(primeArray[i], new PrimeCalculator().nth(i + 1));
        }
    }


}