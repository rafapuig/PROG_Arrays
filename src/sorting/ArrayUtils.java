package sorting;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
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

    public static int[] toIntArray(Integer[] elements) {
        int[] result = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            result[i] = elements[i].intValue();
        }
        return result;
    }

    public static Integer[] toIntegerArray(int[] elements) {
        Integer[] result = new Integer[elements.length];
        for (int i = 0; i < elements.length; i++) {
            result[i] = Integer.valueOf(elements[i]);
        }
        return result;
    }



}
