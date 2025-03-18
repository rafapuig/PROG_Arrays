package varargs;

public class MathUtilsOld {

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int max(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) max = nums[i];
        }
        return max;
    }

}

class MathUtilsOldTest {
    public static void main(String[] args) {
        computeMaxFromTwo();
        computeMaxFromFour();
    }

    private static void computeMaxFromFour() {
        int[] nums = new int[]{5, 4, 7, 6};
        int max = MathUtilsOld.max(nums);
    }

    private static void computeMaxFromFour2() {
        int max = MathUtilsOld.max(new int[]{5, 4, 7, 6});
    }

    private static void computeMaxFromTwo() {
        // Calcular el máximo de 2 números
        int max = MathUtilsOld.max(5, 8);
    }

    private static void computeMaxFromThree() {
        // Calcular el máximo de 3 números
        int max = MathUtilsOld.max(MathUtilsOld.max(5, 8), 9);
    }


}
