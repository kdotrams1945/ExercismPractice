package Prime;

public class PrimeCalculator {
    public static boolean isPrime(int x) {
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

    int nth(int nth) {
        int starter = 2;
        int counter = 0;
        while (counter < nth) {
            if (isPrime(starter)) {
                counter++;
            }
            starter++;
        }
        return starter - 1;
    }
}
