package reflexion;

public class ArrayClassDemo {

    static String format = "%-25s %-25s %-15s\n";

    public static void main(String[] args) {
        int[] intArray = new int[0];
        int[][] intIntArray = new int[0][0];
        int[][][] intIntIntArray = new int[0][0][0];

        String[] stringArray = new String[0];
        String[][] stringStringArray = new String[0][0];
        String[][][] stringStringStringArray = new String[0][0][0];

        System.out.printf(format, "Tipo Array", "Clase", "Tipo elementos");
        printArrayInfo(intArray);
        printArrayInfo(intIntArray);
        printArrayInfo(intIntIntArray);
        printArrayInfo(stringArray);
        printArrayInfo(stringStringArray);
        printArrayInfo(stringStringStringArray);
    }


    static void printArrayInfo(Object array) {
        System.out.printf(format, getArrayTypeName(array), getClassName(array), getElementsTypeName(array));
    }


    public static String getClassName(Object object) {
        return object.getClass().getName();
    }

    public static <T> String getArrayTypeName(Object object) {
        return object.getClass().getTypeName();
    }

    public static <T> String getElementsTypeName(Object object) {
        return object.getClass().getComponentType().getName();
    }

}
