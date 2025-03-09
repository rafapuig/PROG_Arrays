package sorting;

import java.util.Comparator;

public class InsertionRecursiveSort implements SortStrategy {
    @Override
    public <T> void sort(T[] elements, Comparator<? super T> comparator) {
        insertionSortRecursive(elements, elements.length, comparator);
    }

    <T> void insertionSortRecursive(T[] elements, int i, Comparator<? super T> comparator) {
        if (i <= 1) {
            return;
        }
        insertionSortRecursive(elements, i - 1, comparator);
        T key = elements[i - 1];
        int j = i - 2;
        while (j >= 0 && comparator.compare(elements[j], key) > 0) {
            elements[j + 1] = elements[j];
            j = j - 1;
        }
        elements[j + 1] = key;
    }


}
