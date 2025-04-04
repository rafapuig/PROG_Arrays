package exercises.intlist;

import java.util.Arrays;
import java.util.StringJoiner;

public class IntArrayList {

    private static final int DEFAULT_CAPACITY = 16;

    private int size = 0;
    private int[] array;

    public IntArrayList() {
        array = new int[DEFAULT_CAPACITY];
    }

    public IntArrayList(int... elements) {
        this.array = elements;
        this.size = elements.length;
    }

    public IntArrayList(int initialCapacity) {
        array = new int[initialCapacity];
    }

    public int size() {
        return size;
    }

    private void grow() {
        int oldCapacity = array.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        array = Arrays.copyOf(array, newCapacity);
    }

    public void add(int value) {
        add(size, value);
    }

    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(size == array.length) {
            grow();
        }
        // Hacer hueco para insertar
        System.arraycopy(array, index, array, index + 1, size - index);
        // Insertar el valor
        array[index] = value;
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public int getFirst() {
        return this.get(0);
    }

    public int getLast() {
        return this.get(size - 1);
    }

    public void set(int index, int value) {
        array[index] = value;
    }

    public int removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int oldValue = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return oldValue;
    }

    public boolean remove(int value) {
        int index = indexOf(value);
        if (index != -1) {
            removeAt(index);
            return true;
        }
        return false;
    }

    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(int value) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        size = 0;
    }

    public int capacity() {
        return array.length;
    }

    public int[] toArray() {
        return Arrays.copyOf(array, size);
    }

    public int[] toArray(int[] dest) {
        if (dest.length < size) return toArray();
        System.arraycopy(array, 0, dest, 0, size);
        return dest;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            joiner.add(String.valueOf(array[i]));
        }
        return joiner.toString();
    }
}
