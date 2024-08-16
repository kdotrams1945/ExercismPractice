package Twelve;
import java.util.Map;
import java.util.HashMap;
public class TwelveDays {
    private final Map<Integer, String> map = new HashMap<>(){{
        put(1, "a Partridge in a Pear Tree");
        put(2, "two Turtle Doves");
        put(3, "three French Hens");
        put(4, "four Calling Birds");
        put(5, "five Gold Rings");
        put(6, "six Geese-a-Laying");
        put(7, "seven Swans-a-Swimming");
        put(8, "eight Maids-a-Milking");
        put(9, "nine Ladies Dancing");
        put(10, "ten Lords-a-Leaping");
        put(11, "eleven Pipers Piping");
        put(12, "twelve Drummers Drumming");

    }};
    String verse(int verseNumber) {
        StringBuilder verse = new StringBuilder("");
        verse.append("On the " + getOrdinal(verseNumber) + " day of Christmas my true love gave to me: ");
        for (int i = verseNumber; i > 1; i--) {
            verse.append(map.get(i));
            verse.append(", ");
        }
        if (verseNumber == 1) {
            verse.append("a Partridge in a Pear Tree.\n");
        } else {
            verse.append("and a Partridge in a Pear Tree.\n");
        }
        return verse.toString();
    }

    String verses(int startVerse, int endVerse) {
        StringBuilder verses = new StringBuilder();
        for (int i = startVerse; i <= endVerse; i++) {
            verses.append(verse(i));
            if (i < endVerse) {
                verses.append("\n");
            }
        }
        return verses.toString();
    }

    String sing() {
        return verses(1,12);
    }

    public static String getOrdinal(int number) {
        return switch (number) {
            case 1 -> "first";
            case 2 -> "second";
            case 3 -> "third";
            case 4 -> "fourth";
            case 5 -> "fifth";
            case 6 -> "sixth";
            case 7 -> "seventh";
            case 8 -> "eighth";
            case 9 -> "ninth";
            case 10 -> "tenth";
            case 11 -> "eleventh";
            case 12 -> "twelfth";
            default -> "unknown";
        };
    }
}
