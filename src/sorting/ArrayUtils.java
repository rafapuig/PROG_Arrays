package sorting;

import comparing.ComparisonUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ArrayUtils {

    public static int[] toPrimitiveArray(Integer[] elements) {
        //IntStream.of(elements).boxed().mapToInt(Integer::intValue).toArray();
        return Arrays.stream(elements).mapToInt(Integer::intValue).toArray();
    }

    public static Integer[] toWrapperArray(int[] elements) {
        //IntStream.of(elements).boxed().toArray(Integer[]::new);
        return Arrays.stream(elements).boxed().toArray(Integer[]::new);
    }

    public static Long[] toLongArray(long[] elements) {
        return LongStream.of(elements).boxed().toArray(Long[]::new);

    }

    public static long[] toLongArray(Long[] elements) {
        return Stream.of(elements).mapToLong(Long::longValue).toArray();

    }

    public static int[] toIntPrimitiveArray(Integer[] elements) {
        int[] result = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            result[i] = elements[i].intValue();
        }
        return result;
    }

    public static Integer[] toIntegerWrapperArray(int[] elements) {
        Integer[] result = new Integer[elements.length];
        for (int i = 0; i < elements.length; i++) {
            result[i] = Integer.valueOf(elements[i]);
        }
        return result;
    }

    private static final Random random = new Random();

    public static <T> void shuffle(T[] elements) {
        for (int i = 0; i < elements.length; i++) {
            int index = random.nextInt(elements.length);
            T temp = elements[index];
            elements[index] = elements[i];
            elements[i] = temp;
        }
    }

    public static void shuffle(int[] elements) {
        Integer[] copy = toIntegerWrapperArray(elements);
        shuffle(copy);
        int[] shuffled = toIntPrimitiveArray(copy);
        System.arraycopy(shuffled, 0, elements, 0, shuffled.length);
    }

    public static <T extends Comparable<T>> void sort(T[] elements, SortStrategy sortStrategy) {
        sortStrategy.sort(elements);
    }

    public static <T> void sort(T[] elements, SortStrategy sortStrategy, Comparator<T> comparator) {
        sortStrategy.sort(elements, comparator);
    }

}

class ArrayUtilsTest {

    @Test
    public void testShuffle() {
        Integer[] elements = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(elements));
        ArrayUtils.shuffle(elements);
        System.out.println(Arrays.toString(elements));
        ArrayUtils.shuffle(elements);
        System.out.println(Arrays.toString(elements));
    }

    @Test
    public void testToIntPrimitiveArray() {
        Integer[] elements = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(elements));
        int[] elems = ArrayUtils.toIntPrimitiveArray(elements);
        System.out.println(Arrays.toString(elems));
    }

    @Test
    public void testToIntegerWrapperArray() {
        int[] elements = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(elements));
        Integer[] elems = ArrayUtils.toIntegerWrapperArray(elements);
        System.out.println(Arrays.toString(elems));
    }

    @Test
    public void testShuffleInt() {
        int[] elements = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(elements));
        ArrayUtils.shuffle(elements);
        System.out.println(Arrays.toString(elements));
    }
}
