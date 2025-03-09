package sorting;

import java.util.Comparator;

public class InsertionSort implements SortStrategy {
    @Override
    public <T> void sort(T[] elements, Comparator<? super T> comparator) {
        // Empezamos por el segundo elemento
        for (int i = 1; i < elements.length; i++) {
            T key = elements[i]; // El elemento en la posición i es la clave
            int j = i - 1; // Vamos hacia atrás
            // Mientras encontramos en el índice j un valor mayor que la clave
            while (j >= 0 && comparator.compare(elements[j], key) > 0) {
                elements[j + 1] = elements[j]; // Desplazamos el elemento hacia la derecha para hacer sitio
                j = j - 1; // j apunta a la posición anterior a donde se ha quedado el "hueco" para insertar
            }
            elements[j + 1] = key; // Insertamos el valor clave en la posición que le corresponde (el hueco)
        }
    }
}
