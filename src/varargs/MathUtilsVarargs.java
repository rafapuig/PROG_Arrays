package varargs;

public class MathUtilsVarargs {

    public static int max(int... nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) max = nums[i];
        }
        return max;
    }

}

class MathUtilsVarArgsTest {
    public static void main(String[] args) {
        computeMaxFromTwo();
        computeMaxFromFour();
    }

    private static void computeMaxFromFour() {
        int[] nums = new int[]{5, 4, 7, 6};
        int max = MathUtilsVarargs.max(nums);
    }

    private static void computeMaxFromFour2() {
        int max = MathUtilsVarargs.max(new int[]{5, 4, 7, 6});
    }

    private static void computeMaxFromFour3() {
        // Forma más cómoda de llamar al metodo desde el código cliente
        int max = MathUtilsVarargs.max(5, 4, 7, 6);
    }

    private static void computeMaxFromTwo() {
        // Calcular el máximo de 2 números
        int max = MathUtilsVarargs.max(5, 8);
    }

    private static void computeMaxFromThree() {
        // Calcular el máximo de 3 números
        int max = MathUtilsOld.max(MathUtilsVarargs.max(5, 8), 9);
    }


}
