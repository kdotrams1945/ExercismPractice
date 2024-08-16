package H;
import java.util.Map;
import java.util.HashMap;

public class House {
    private static final Map<Integer, String> VERSES = new HashMap<>();

    static {
        VERSES.put(1, "This is the house that Jack built.");
        VERSES.put(2, "This is the malt\nthat lay in the house that Jack built.");
        VERSES.put(3, "This is the rat\nthat ate the malt\nthat lay in the house that Jack built.");
        VERSES.put(4, "This is the cat\nthat killed the rat\nthat ate the malt\nthat lay in the house that Jack built.");
        VERSES.put(5, "This is the dog\nthat worried the cat\nthat killed the rat\nthat ate the malt\nthat lay in the house that Jack built.");
        VERSES.put(6, "This is the cow with the crumpled horn\nthat tossed the dog\nthat worried the cat\nthat killed the rat\nthat ate the malt\nthat lay in the house that Jack built.");
        VERSES.put(7, "This is the maiden all forlorn\nthat milked the cow with the crumpled horn\nthat tossed the dog\nthat worried the cat\nthat killed the rat\nthat ate the malt\nthat lay in the house that Jack built.");
        VERSES.put(8, "This is the man all tattered and torn\nthat kissed the maiden all forlorn\nthat milked the cow with the crumpled horn\nthat tossed the dog\nthat worried the cat\nthat killed the rat\nthat ate the malt\nthat lay in the house that Jack built.");
        VERSES.put(9, "This is the priest all shaven and shorn\nthat married the man all tattered and torn\nthat kissed the maiden all forlorn\nthat milked the cow with the crumpled horn\nthat tossed the dog\nthat worried the cat\nthat killed the rat\nthat ate the malt\nthat lay in the house that Jack built.");
        VERSES.put(10, "This is the rooster that crowed in the morn\nthat woke the priest all shaven and shorn\nthat married the man all tattered and torn\nthat kissed the maiden all forlorn\nthat milked the cow with the crumpled horn\nthat tossed the dog\nthat worried the cat\nthat killed the rat\nthat ate the malt\nthat lay in the house that Jack built.");
        VERSES.put(11, "This is the farmer sowing his corn\nthat kept the rooster that crowed in the morn\nthat woke the priest all shaven and shorn\nthat married the man all tattered and torn\nthat kissed the maiden all forlorn\nthat milked the cow with the crumpled horn\nthat tossed the dog\nthat worried the cat\nthat killed the rat\nthat ate the malt\nthat lay in the house that Jack built.");
        VERSES.put(12, "This is the horse and the hound and the horn\nthat belonged to the farmer sowing his corn\nthat kept the rooster that crowed in the morn\nthat woke the priest all shaven and shorn\nthat married the man all tattered and torn\nthat kissed the maiden all forlorn\nthat milked the cow with the crumpled horn\nthat tossed the dog\nthat worried the cat\nthat killed the rat\nthat ate the malt\nthat lay in the house that Jack built.");
    }

    String verse(int verse) {
        if (verse < 1 || verse > VERSES.size()) {
            throw new IllegalArgumentException("Verse number out of range.");
        }
        return VERSES.get(verse);
    }

    String verses(int startVerse, int endVerse) {
        if (startVerse < 1 || endVerse > VERSES.size() || startVerse > endVerse) {
            throw new IllegalArgumentException("Verse numbers out of range.");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = startVerse; i <= endVerse; i++) {
            sb.append(verse(i)).append("\n\n");
        }
        return sb.toString().trim();
    }

    String sing() {
        return verses(1, VERSES.size());
    }
}
