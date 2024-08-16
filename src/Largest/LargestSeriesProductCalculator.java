package Largest;
import java.util.HashSet;
import java.util.Set;
public class LargestSeriesProductCalculator {
    private final String inputNumber;

    public LargestSeriesProductCalculator(String inputNumber) {
        if (inputNumber == null) {
            throw new IllegalArgumentException("Input must be a non-empty numeric string.");
        }
        if (inputNumber.isEmpty() || !inputNumber.matches("\\d+")) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
        this.inputNumber = inputNumber;
    }

    public long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if (numberOfDigits <= 0) {
            throw new IllegalArgumentException("Series length must be greater than zero.");
        }
        if (numberOfDigits > inputNumber.length()) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }
        long maxProduct = 0;
        for (int i = 0; i <= inputNumber.length() - numberOfDigits; i++) {
            String series = inputNumber.substring(i, i + numberOfDigits);
            long product = calculateProduct(series);
            if (product > maxProduct) {
                maxProduct = product;
            }
        }
        return maxProduct;
    }
    long calculateProduct(String series) {
        long product = 1;
        for (char c : series.toCharArray()) {
            product *= Character.getNumericValue(c);
        }
        return product;
    }
}
