package Prim;
import java.util.*;
public class PrimeFactorsCalculator {
    List<Long> calculatePrimeFactorsOf(long number) {
        List<Long> newList = new ArrayList<>();
        if (number < 2) {
            return newList;
        }
        for (long i = 2; i * i <= number; i++) {
            while (number % i == 0) {
                if (isPrime((int) i)) { // Use isPrime to confirm i is a prime factor
                    newList.add(i);
                }
                number /= i;
            }
        }
        if (number > 1 && isPrime((int) number)) { // Check if the remaining number is prime
            newList.add(number);
        }
        return newList;
    }
    boolean isPrime(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i <= x / 2; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
