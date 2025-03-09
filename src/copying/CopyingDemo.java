package copying;

import java.util.Arrays;

public class CopyingDemo {

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5};
        int[] dest = new int[numbers.length + 1];
        System.arraycopy(numbers, 0, dest, 0, numbers.length);
        dest[5] = 6;
    }
}
