package Leet.DivT;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void testSimple() {
       Solution solution = new Solution();
       var result = solution.divide(10,3);
       assertEquals(3, result);
    }
    @Test
    public void testSimple2() {
        Solution solution = new Solution();
        assertEquals(1, solution.divide(3,3));
        assertEquals(0, solution.divide(0,3));
        assertEquals(-2, solution.divide(7,-3));
        assertEquals(2, solution.divide(-7,-3));
        assertEquals(-2, solution.divide(-7,3));
        assertEquals(2, solution.divide(7,3));
    }
    @Test
    public void testSimple3() {
        Solution solution = new Solution();
        assertEquals(-2147483648, solution.divide(-2147483648,1));

        assertEquals(2147483647, solution.divide(-2147483648,-1));
    }
}