package comparing;

/**
 * Clase de utilidad para imprimir resultados de comparaciones por consola
 */
public class ComparisonUtils {

    public static <T extends Comparable<T>> void printComparisonResults(T left, T right) {
        String sign = toSign(left.compareTo(right));
        System.out.println(left + " " + sign + " " + right);
    }

    public static void printComparisonResults(Comparable<?> left, Comparable<?> right, int result) {
        String sign = toSign(result);
        System.out.println(left + " " + sign + " " + right);
    }

    /**
     * Procesa el resultado de una comparación de objetos comparables
     * Si la comparación fue que el elemento era menor que con quien se compara el resultado es < 0
     * y por tanto, devuelve el signo <
     * Si la comparación dictó que era mayor el resultado es > 0
     * y lo que devolvemos es el signo >
     * Si no, devolvemos un signo = , porque ambos objetos habrán sido considerados iguales
     */
    public static String toSign(int result) {
        if (result < 0) return "<";
        if (result > 0) return ">";
        return "=";
    }
}
