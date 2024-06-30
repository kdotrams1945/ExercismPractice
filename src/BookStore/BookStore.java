package BookStore;

import java.util.*;


public class BookStore {

    public static final int AVAILABLE_BOOK_COUNT = 5;
    public static final Map<Integer, Double> DISCOUNTS = Map.of(1, 1.0, 2, 0.95, 3, 0.9, 4, 0.8, AVAILABLE_BOOK_COUNT, 0.75);

    public static ArrayList<Integer> aggregateBooks(List<Integer> books) {
        ArrayList<Integer> booksAggregated = new ArrayList<Integer>();
        for (int i = 1; i <= AVAILABLE_BOOK_COUNT; i++) {
            final int a = i;
            booksAggregated.add((int) books.stream()
                    .filter(book -> book == a)
                    .count());
        }
        return booksAggregated;
    }

    public static ArrayList<Integer> takeBasket(int batchSize, ArrayList<Integer> booksAggregated) {
        ArrayList<Integer> newBasket = new ArrayList<Integer>();
        for (int i = 0; i < booksAggregated.size(); i++) {
            Integer book = booksAggregated.get(i);
            newBasket.add(i < batchSize ? Integer.valueOf(book - 1) : book);

        }
        return newBasket;
    }

    double calculateBasketCost(List<Integer> books) {
        ArrayList<Integer> aggregated = aggregateBooks(books);
        aggregated.sort(Comparator.reverseOrder());
        return calculateBasket(aggregated);
    }

    private double calculateBasket(ArrayList<Integer> aggregated) {
        aggregated.removeIf(x -> x <= 0);
        if (aggregated.isEmpty()) {
            return 0;
        }
        if (aggregated.size() == 1) {
            return aggregated.get(0) * 8;
        }
        ArrayList<Double> costs = new ArrayList<Double>();
        for (int i = 2; i <= aggregated.size(); i++) {
            var scenarioCost = (i * 8 * DISCOUNTS.get(i)) +
                    calculateBasket(takeBasket(i, aggregated));
            costs.add(scenarioCost);
        }
        return Collections.min(costs);
    }
}
