package initial;

public class ArrayInitDemo {

    public static void main(String[] args) {
        intArrayInit();
        booleanArrayInit();
        referenceArrayInit();
        stringArrayInit();
    }

    private static void intArrayInit() {
        System.out.println("Inicialización de los elementos de un array de int");
        int[] ids = new int[3];
        for (int i = 0; i < ids.length; i++) {
            System.out.println("ids[" + i + "] = " + ids[i]);
        }
    }

    private static void booleanArrayInit() {
        System.out.println("Inicialización de los elementos de un array de boolean");
        boolean[] booleans = new boolean[3];
        for (int i = 0; i < booleans.length; i++) {
            System.out.println("booleans[" + i + "] = " + booleans[i]);
        }
    }

    /**
     * Cuando se crea un array de objetos no se crean los objetos
     * se crean elementos para guardar referencias a objetos
     */
    private static void referenceArrayInit() {
        System.out.println("Inicialización de los elementos de un array de referencias a objetos");
        Object[] objects = new Object[3];
        for (int i = 0; i < objects.length; i++) {
            System.out.println("objects[" + i + "] = " + objects[i]);
        }
    }

    /**
     * Cuando se crea un array de Strings (como los strings son objetos)
     * no se crean los strings
     * se crean elementos para guardar las referencias a las strings
     */
    private static void stringArrayInit() {
        System.out.println("Inicialización de los elementos de un array de referencias a objetos");
        String[] names = new String[3];
        for (int i = 0; i < names.length; i++) {
            System.out.println("names[" + i + "] = " + names[i]);
        }
    }

}
