package BookStore;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.*;

class BookStoreTest {

    @Test
    public void testNoBooks() {
        BookStore bookStore = new BookStore();
        var result = bookStore.calculateBasketCost(new ArrayList<Integer>());
        assertEquals(0, result);
    }
    @Test
    public void testOneBook() {
        BookStore bookStore = new BookStore();
        var result = bookStore.calculateBasketCost(Arrays.asList(2,2,2));
        assertEquals(24, result);
    }
    @Test
    public void testNoBooks2() {
        BookStore bookStore = new BookStore();
        var result = bookStore.calculateBasketCost(Arrays.asList(1, 2, 3, 4));
        assertEquals(25.60, result);
    }
    @Test
    public void testNoBooks3() {
        BookStore bookStore = new BookStore();
        var result = bookStore.calculateBasketCost(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5));
        assertEquals(51.20, result);
    }
    @Test
    public void testAggregation() {
        var aggregated = BookStore.aggregateBooks(Arrays.asList(5,1,2,1,2,3,3,1,4,4,5,1, 1, 2, 2, 3, 3, 4, 5));
        assertEquals(5, aggregated.size());
        assertEquals(5, aggregated.get(0));
        assertEquals(4, aggregated.get(1));
        assertEquals(4, aggregated.get(2));
        assertEquals(3, aggregated.get(3));
        assertEquals(3, aggregated.get(4));
    }
//    @Test
//    public void testAggregationBasket() {
//        var aggregated = BookStore.aggregateBooks(Arrays.asList(5, 1, 2, 1, 2, 3, 3, 1, 4, 4, 5, 1, 1, 2, 2, 3, 3, 4, 5));
//        // 5,4,4,3,3
//        assertThat(BookStore.takeBasket(5,aggregated), equalTo(Arrays.asList(4,3,3,2,2)));
//        assertThat(BookStore.takeBasket(4,aggregated), equalTo(Arrays.asList(4,3,3,2,3)));
//        assertThat(BookStore.takeBasket(3,aggregated), equalTo(Arrays.asList(4,3,3,3,3)));
//    }
//        @Test
//    public void testAggregationWhenBook1DoesNotExist() {
//        var aggregated = BookStore.aggregateBooks(Arrays.asList(5,2,2,3,3,4,4,5, 2, 2, 3, 3, 4, 5));
//        assertEquals(5, aggregated.size());
//        assertEquals(0, aggregated.get(0));
//        assertEquals(4, aggregated.get(1));
//        assertEquals(4, aggregated.get(2));
//        assertEquals(3, aggregated.get(3));
//        assertEquals(3, aggregated.get(4));
//    }

    private static final double EQUALITY_TOLERANCE = 0.001;
    private BookStore bookStore;
    @BeforeEach
    public void setUp() {
        bookStore = new BookStore();
    }
    @Test
    public void onlyASingleBook() {
        List<Integer> books = Collections.singletonList(1);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(8.00, Assertions.offset(EQUALITY_TOLERANCE));
    }
    //@DIsabled("Remove to run test")
    @Test
    public void twoOfSameBook() {
        List<Integer> books = Arrays.asList(2, 2);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(16.00, Assertions.offset(EQUALITY_TOLERANCE));
    }
    //@DIsabled("Remove to run test")
    @Test
    public void emptyBasket() {
        List<Integer> books = Collections.emptyList();
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(0.00, Assertions.offset(EQUALITY_TOLERANCE));
    }
    //@DIsabled("Remove to run test")
    @Test
    public void twoDifferentBooks() {
        List<Integer> books = Arrays.asList(1, 2);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(15.20, Assertions.offset(EQUALITY_TOLERANCE));
    }
    //@DIsabled("Remove to run test")
    @Test
    public void threeDifferentBooks() {
        List<Integer> books = Arrays.asList(1, 2, 3);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(21.60, Assertions.offset(EQUALITY_TOLERANCE));
    }
    //@DIsabled("Remove to run test")
    @Test
    public void fourDifferentBooks() {
        List<Integer> books = Arrays.asList(1, 2, 3, 4);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(25.60, Assertions.offset(EQUALITY_TOLERANCE));
    }
    //@DIsabled("Remove to run test")
    @Test
    public void fiveDifferentBooks() {
        List<Integer> books = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(30.00, Assertions.offset(EQUALITY_TOLERANCE));
    }
    //@DIsabled("Remove to run test")
    @Test
    public void twoGroupsOfFourIsCheaperThanGroupOfFivePlusGroupOfThree() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(51.20, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Test
    public void twoGroupsOfFourIsCheaperThanGroupsOfFiveAndThree() {
        List<Integer> books = Arrays.asList(1, 1, 2, 3, 4, 4, 5, 5);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(51.20, Assertions.offset(EQUALITY_TOLERANCE));
    }
    //@DIsabled("Remove to run test")
    @Test
    public void groupOfFourPlusGroupOfTwoIsCheaperThanTwoGroupsOfThree() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 4);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(40.80, Assertions.offset(EQUALITY_TOLERANCE));
    }
    //@DIsabled("Remove to run test")
    @Test
    public void twoEachOfFirst4BooksAnd1CopyEachOfRest() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(55.60, Assertions.offset(EQUALITY_TOLERANCE));
    }
    //@DIsabled("Remove to run test")
    @Test
    public void twoCopiesOfEachBook() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(60.00, Assertions.offset(EQUALITY_TOLERANCE));
    }
    //@DIsabled("Remove to run test")
    @Test
    public void threeCopiesOfFirstBookAnd2EachOfRemaining() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 1);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(68.00, Assertions.offset(EQUALITY_TOLERANCE));
    }
    //@DIsabled("Remove to run test")
    @Test
    public void threeEachOFirst2BooksAnd2EachOfRemainingBooks() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 1, 2);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(75.20, Assertions.offset(EQUALITY_TOLERANCE));
    }
    //@DIsabled("Remove to run test")
    @Test
    public void fourGroupsOfFourAreCheaperThanTwoGroupsEachOfFiveAndThree() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 1, 1, 2, 2, 3, 3, 4, 5);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(102.4, Assertions.offset(EQUALITY_TOLERANCE));
    }
    //@DIsabled("Remove to run test")
    @Test
    public void groupsOfFourAreCreatedEvenWhenThereAreMoreGroupsOfThreeThanGroupsOfFive() {
        List<Integer> books = Arrays.asList(1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(145.6, Assertions.offset(EQUALITY_TOLERANCE));
    }
    ////@DIsabled("Remove to run test")
    @Test
    public void oneGroupOfOneAndFourIsCheaperThanOneGroupOfTwoAndThree() {
        List<Integer> books = Arrays.asList(1, 1, 2, 3, 4);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(33.6, Assertions.offset(EQUALITY_TOLERANCE));
    }
    //@DIsabled("Remove to run test")
    @Test
    public void oneGroupOfOneAndTwoPlusThreeGroupsOfFourIsCheaperThanOneGroupOfEachSize() {
        List<Integer> books = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(100.0, Assertions.offset(EQUALITY_TOLERANCE));
    }
}