package Kilo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    @Test
    public void test1() {
        UnitsConverter converter = new UnitsConverter();
        assertEquals(2.20462,converter.kiloToPound(1.0));
        assertEquals( 2.20462 * 3.55,converter.kiloToPound(3.55));
        assertEquals( 0,converter.kiloToPound(0));
    }
    @Test
    public void test2() {
        UnitsConverter converter = new UnitsConverter();
       var exception = assertThrows(IllegalArgumentException.class, ()->converter.kiloToPound(-3.4));
       assertEquals("Negative weight is invalid.", exception.getMessage());
    }

}