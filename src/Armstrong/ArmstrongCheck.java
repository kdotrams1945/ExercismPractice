package Armstrong;

import java.util.*;

public class ArmstrongCheck {
    public List<Integer> getDigitArray(int number)
    {
        ArrayList<Integer> digits = new ArrayList<Integer>();
        while (number > 0){
            var x = number /10;
            digits.add(0,number%10);
            number = x;
        }
        return digits;
    }

    public boolean isArmstrong(int number) {
        // 11 -> 1,1
        var digits = getDigitArray(number);
        var length = digits.size();
        int sum = digits.stream()
                .mapToInt(digit -> (int) Math.pow(digit, length))
                .sum();
        return sum == number;
    }
    public boolean isArmstrong1(int number) {
        // 11 -> 1,1
        var digits = getDigitArray(number);
        var length = digits.size();
        int sum = 0;
        for (Integer digit : digits) {
            sum += (int) Math.pow(digit, length);
        }
        return sum == number;
    }
    public boolean isArmstrong0(int number) {
        String numberInString = String.valueOf(number);
        int length = numberInString.length();
        int sum = 0;
        for (int i = 0; i < numberInString.length(); i++) {
            int x = (int) numberInString.charAt(i) - ((int) ('0'));
            sum += (int) Math.pow(x, length);
        }
        return sum == number;
    }
}
