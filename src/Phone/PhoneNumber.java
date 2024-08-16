package Phone;

public class PhoneNumber {
    private String number;
    PhoneNumber(String numberString) {
        number = numberString.trim();
    }

    String getNumber() {
        String newNumber = number.replaceAll("[^\\\\d]", "");
        if (newNumber.length() == 11 && newNumber.charAt(0) == '1') {
            newNumber = newNumber.substring(1);
        }
        return newNumber;
    }
}
