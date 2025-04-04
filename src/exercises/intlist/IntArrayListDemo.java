package exercises.intlist;

public class IntArrayListDemo {

    public static void main(String[] args) {

        IntArrayList list = new IntArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        printInfo(list);

        list.add(11);
        printInfo(list);

        for (int n = 12; n <= 20; n++) {
            list.add(n);
        }
        printInfo(list);

        list.remove(10);
        printInfo(list);

        System.out.println(list.getLast());
        System.out.println(list.getFirst());

        list.clear();
        printInfo(list);
        try {
            System.out.println(list.getLast());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getClass().getSimpleName());
        }

        try {
            System.out.println(list.getFirst());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getClass().getSimpleName());
        }

        for (int i = 1; i <= 100; i+=2) {
            list.add(i);
        }
        printInfo(list);

    }

    public static void printInfo(IntArrayList list) {
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.capacity());
    }
}
