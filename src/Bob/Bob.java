package Bob;

public class Bob {
    String hey(String input) {
        String trimmedInput = input.trim();

        if (trimmedInput.isEmpty()) {
            return "Fine. Be that way!";
        }

        boolean isQuestion = trimmedInput.endsWith("?");
        boolean isYelling = trimmedInput.equals(input.toUpperCase()) && trimmedInput.matches(".*[a-zA-Z].*");

        if (isQuestion && isYelling) {
            return "Calm down, I know what I'm doing!";
        } else if (isQuestion) {
            return "Sure.";
        } else if (isYelling) {
            return "Whoa, chill out!";
        } else {
            return "Whatever.";
        }
    }
}
