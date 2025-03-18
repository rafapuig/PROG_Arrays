package varargs;

public class MathUtils {

    public static int max(int n1, int n2, int... nums) {
        int max = n1 > n2 ? n1 : n2;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) max = nums[i];
        }
        return max;
    }

}

class MathUtilsTest {
    public static void main(String[] args) {
        computeMaxFromTwo();
        computeMaxFromFour();
    }



    private static void computeMaxFromTwo() {
        // Calcular el máximo de 2 números
        int max = MathUtils.max(5, 8);
    }

    private static void computeMaxFromFour() {
        // Forma más cómoda de llamar al metodo desde el código cliente
        int max = MathUtils.max(5, 4, 7, 6);
    }

}
