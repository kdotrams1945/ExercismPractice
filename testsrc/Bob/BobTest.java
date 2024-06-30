package Bob;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class BobTest {
    @Test
    public void Bob1() {
        Bob bob = new Bob();
        var output = bob.hey("Tom-ay-to, tom-aaaah-to.");
        assertEquals("Whatever.", output);
    }
    @Test
    public void Bob2() {
        Bob bob = new Bob();
        var output = bob.hey("FCECDFCAAB");
        assertEquals("Whoa, chill out!", output);
    }
    @Test
    public void Bob3() {
        Bob bob = new Bob();
        var output = bob.hey("Does this cryogenic chamber make me look fat?");
        assertEquals("Sure.", output);
    }
    @Test
    public void Bob4() {
        Bob bob = new Bob();
        var output = bob.hey("WHAT'S GOING ON?");
        assertEquals("Calm down, I know what I'm doing!", output);
    }



}