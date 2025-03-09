package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort implements SortStrategy {
    @Override
    public <T> void sort(T[] elements, Comparator<? super T> comparator) {
        mergeSort(elements, elements.length, comparator);
    }

    public <T> void mergeSort(T[] a, int n, Comparator<? super T> comparator) {
        if (n < 2) {
            return;
        }

        int mid = n / 2;

        //List<T> ll = new ArrayList<>(Arrays.asList(a)).subList(0, mid);
        //List<T> rr = new ArrayList<>(Arrays.asList(a)).subList(mid, n);

        T[] l = Arrays.copyOfRange(a, 0, mid); //(T[]) Arrays.stream(a).limit(mid).toArray();// (T[]) ll.toArray(); //  (T[])Array.newInstance(type,mid);
        T[] r = Arrays.copyOfRange(a, mid, n); //()T[]) rr.toArray(); //  (T[])Array.newInstance(type,n - mid);

        //System.arraycopy(a, 0, l, 0, mid);
        //System.arraycopy(a, mid, r, 0, n - mid);

        mergeSort(l, mid, comparator);
        mergeSort(r, n - mid, comparator);

        merge(a, l, r, mid, n - mid, comparator);
    }

    public <T> void merge(
            T[] a, T[] l, T[] r, int left, int right, Comparator<? super T> comparator) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (comparator.compare(l[i], r[j]) <= 0) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

}
