package sorting;


import java.util.Comparator;

public class SelectionSort implements SortStrategy {

    public <T> void sort(T[] elements, Comparator<? super T> comparator) {

        for (int i = 0; i < elements.length - 1; i++) {

            // Consideramos inicialmente que el mínimo elemento de la parte que resta por ordenar está en i
            int minElementIndex = i;

            // Buscamos desde el índice siguiente a i para encontrar el mínimo
            for (int j = i + 1; j < elements.length; j++) {

                // Si en la posición j encontramos un valor menor que el mínimo
                if (comparator.compare(elements[j], elements[minElementIndex]) < 0) {
                    minElementIndex = j; // El nuevo índice del mínimo pasa ser el de la posición j
                }
            }

            // Si hemos encontrado un elemento menor en otra posición (intercambiamos los elementos)
            if (minElementIndex != i) {
                T temp = elements[i];
                elements[i] = elements[minElementIndex];
                elements[minElementIndex] = temp;
            }
        }
    }

}