package compatibility;

import comparing.Apple;
import comparing.Person;

public class CompatibityDemo {
    public static void main(String[] args) {
        //testCompatibilty();

        testPrimitiveArrayToWrapper();

    }

    private static void testCompatibilty() {
        int[] intArray = new int[10];
        intArray[0] = (byte) 10; // OK asignablemente compatible
        //intArray[1] = 10.f; // Error, float no es asignablemente compatible

        Object[] objectArray = new Object[10];
        objectArray[0] = new String("Hola");
        objectArray[1] = Integer.valueOf(15);
        objectArray[2] = null;

        String string = (String) objectArray[0];
        int integer = ((Integer) objectArray[1]).intValue();
        int integer2 = (int) objectArray[1];
    }

    static void testPrimitiveArrayToWrapper() {
        int[] intArray = new int[10];
        //Integer[] integerArray = intArray;
        Integer[] integerArray = new Integer[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            integerArray[i] = Integer.valueOf(intArray[i]);
        }
    }
}
