package sorting;

import exercises.model.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortingDemo {

    public static void main(String[] args) {

        String[] items = {"Gko", "Mkokoko", "Ckookokoko", "Akok", "Eko", "Fkokoko", "Bkokokokokokoko", "H"};

        SortStrategy sortStrategy = new MergeSort();

        sortStrategy.sort(items, Comparator.comparing(String::length));

        System.out.println(Arrays.toString(items));

        Point[] points = new Point[items.length];
        sortStrategy.sort(points, Comparator.nullsFirst(Comparator.comparing(Point::getX)));

        System.out.println(Arrays.toString(points));
    }

    @Test
    void testInsertionSort1() {
        int[] elements = {5, 4, 3, 2, 1};
        SortStrategy insertionSort = new MergeSort();

        Integer[] boxed = ArrayUtils.toWrapperArray(elements);
        System.out.println(Arrays.toString(boxed));

        insertionSort.sort(boxed);
        System.out.println(Arrays.toString(boxed));

        int[] expected = {1, 2, 3, 4, 5};
        int[] result = ArrayUtils.toPrimitiveArray(boxed);

        assertArrayEquals(result, expected);
    }

    @Test
    void testSelectionSort() {
        testSorting(new SelectionSort());
    }

    @Test
    void testInsertionSort() {
        testSorting(new InsertionSort());
    }

    void testSorting(SortStrategy sortStrategy) {
        testSortingStrategy(sortStrategy);
        testSortingStrategy(sortStrategy, Comparator.comparing(String::length));
    }

    static void testSortingStrategy(SortStrategy sortStrategy) {
        String[] words = {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez"};
        sortStrategy.sort(words);
        System.out.println(Arrays.toString(words));
    }

    static void testSortingStrategy(SortStrategy sortStrategy, Comparator<? super String> comparator) {
        String[] words = {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez"};
        sortStrategy.sort(words, comparator);
        System.out.println(Arrays.toString(words));
    }


    private static SortStrategy[] provideTestSortingStrategyArgs() {
        return new SortStrategy[]{
                new InsertionSort(),
                new SelectionSort(),
                new InsertionRecursiveSort(),
                new MergeSort(),
                new ShellSort(),
                new QuickSort()};
    }

    @ParameterizedTest()
    @MethodSource("provideTestSortingStrategyArgs")
    void performTestSorting(SortStrategy sortStrategy) {
        // Dado
        String[] words = {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez"};

        // Cuando
        sortStrategy.sort(words);

        // Entonces
        String[] expected = {"cinco", "cuatro", "diez", "dos", "nueve", "ocho", "seis", "siete", "tres", "uno"};
        assertArrayEquals(expected, words);

        System.out.println("Ordenando mediante " + sortStrategy.getClass().getSimpleName());
        System.out.println(Arrays.toString(words));
    }
}
