package sorting;

import java.util.Comparator;

public class ShellSort implements SortStrategy {
    @Override
    public <T> void sort(T[] elements, Comparator<? super T> comparator) {
        int n = elements.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T key = elements[i];
                int j = i;
                while (j >= gap && comparator.compare(elements[j - gap],key) > 0) {
                    elements[j] = elements[j - gap];
                    j -= gap;
                }
                elements[j] = key;
            }
        }
    }
}
