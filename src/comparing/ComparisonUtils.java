package comparing;

import org.junit.jupiter.api.Test;

/**
 * Clase de utilidad para imprimir resultados de comparaciones por consola
 */
public class ComparisonUtils {

    /**
     * Procesa el resultado de una comparación de objetos comparables
     * Si la comparación fue que el elemento era menor que con quien se compara el resultado es < 0
     * y por tanto, devuelve el signo <
     * Si la comparación dictó que era mayor el resultado es > 0
     * y lo que devolvemos es el signo >
     * Si no, devolvemos un signo = , porque ambos objetos habrán sido considerados iguales
     */
    public static char sign(int comparisonResult) {
        if (comparisonResult < 0) return '<';
        if (comparisonResult > 0) return '>';
        return '=';
    }


    public static <T extends Comparable<T>> void printComparisonResults(T left, T right) {
        char sign = sign(left.compareTo(right));
        System.out.println(left + " " + sign + " " + right);
    }


    public static void printComparisonResults(Comparable<?> left, Comparable<?> right, int result) {
        char sign = sign(result);
        System.out.println(left + " " + sign + " " + right);
    }
}

class ComparisonUtilsTest {

    @Test
    public void testPrintComparisonResults() {
        int x = 7;
        int y = 5;
        int z = 7;

        ComparisonUtils.printComparisonResults(x, y);
        ComparisonUtils.printComparisonResults(y, x);
        ComparisonUtils.printComparisonResults(z, z);
    }

}
