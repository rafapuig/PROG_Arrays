package reflexion;

import comparing.Apple;

import java.lang.reflect.Array;

public class ArrayCreationDemo {
    public static void main(String[] args) {
        int length = 10;
        int[] intArray = (int[]) Array.newInstance(int.class, length);
        boolean[] booleanArray = (boolean[]) Array.newInstance(boolean.class, length);
        String[] stringArray = (String[]) Array.newInstance(String.class, length);
        Apple[] appleArray = (Apple[]) Array.newInstance(Apple.class, length);

        String[] strings = (String[]) newArray(String.class, length);
        Apple[] apples = (Apple[]) newArray(Apple.class, length);
        //int[] ints = newArray(int.class, length);
        int[][] matrix = (int[][]) Array.newInstance(int.class, 2, 3);

    }

    @SuppressWarnings("unchecked")
    static <T> T[] newArray(Class<T> clazz, int length) {
        return  (T[]) Array.newInstance(clazz, length);
    }

}
