package sorting;

import exercises.model.Point;
import org.junit.jupiter.api.Test;

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
    void testInsertionSort() {
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
}
