package sorting;

import java.util.Comparator;

public interface SortStrategy {

    <T> void sort(T[] elements, Comparator<? super T> comparator);

    default <T extends Comparable<? super T>> void sort(T[] elements) {
        Comparator<? super T> comparator = Comparator.naturalOrder();
        sort(elements, comparator);
    }
}
