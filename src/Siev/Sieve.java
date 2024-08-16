package Siev;
import java.util.*;
public class Sieve {
    private final int maxPrime;
    private final boolean[] isPrime;

    Sieve(int maxPrime) {
        this.maxPrime = maxPrime;
        this.isPrime = new boolean[maxPrime + 1];
        for (int i = 2; i <= maxPrime; i++) {
            isPrime[i] = true;
        }
        for (int p = 2; p * p <= maxPrime; p++) {
            if (isPrime[p]) {
                for (int multiple = p * p; multiple <= maxPrime; multiple += p) {
                    isPrime[multiple] = false;
                }
            }
        }
    }
    List<Integer> getPrimes() {
        List<Integer> primes = new ArrayList<>();
        if (maxPrime == 1) {
            return Collections.emptyList();
        }
        for (int i = 2; i <= maxPrime; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
