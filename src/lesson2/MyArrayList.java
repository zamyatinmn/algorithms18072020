package lesson2;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<T extends Comparable<T>> {
    private T[] list;
    private int size = 0;


    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity : " + capacity);
        }
        list = (T[]) new Comparable[capacity];
    }

    public MyArrayList() {
        int DEFAULT_CAPACITY = 10;
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    public void add(T value) {
        checkAndGrow();
        list[size] = value;
        size++;
    }

    public void add(int index, T item) {
        checkCorrectIndex(index);
        checkAndGrow();
        if (size - index >= 0) System.arraycopy(list, index, list, index + 1, size - index);
        list[index] = item;
        size++;
    }

    private void checkAndGrow() {
        if (list.length == size) {
            list = Arrays.copyOf(list, list.length * 2);
        }
    }

    public boolean remove(T item) {
        int i = 0;
        while (i < size && !list[i].equals(item)) {
            i++;
        }
        if (i == size) {
            return false;
        }
        if (size - 1 - i >= 0) System.arraycopy(list, i + 1, list, i, size - 1 - i);
        list[--size] = null;
        return true;
    }

    public T get(int index) {
        checkCorrectIndex(index);
        return list[index];
    }

    public void set(int index, T item) {
        checkCorrectIndex(index);
        list[index] = item;
    }

    public int size() {
        return size;
    }

    private void checkCorrectIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("no correct index" + index);
        }
    }

    public final int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) > -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(list[i]).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(" ]");
        return sb.toString();
    }

    private boolean less(T item1, T item2) {
        return item1.compareTo(item2) < 0;
    }

    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int iMin = i;
            for (int j = i + 1; j < size; j++) {
                if (less(list[j], list[iMin])) {
                    iMin = j;
                }
            }
            swap(i, iMin);
        }
    }

    public void selectionSort(Comparator comparator) {
        for (int i = 0; i < size - 1; i++) {
            int iMin = i;
            for (int j = i + 1; j < size; j++) {
                if (comparator.compare(list[j], list[iMin]) < 0) {
                    iMin = j;
                }
            }
            swap(i, iMin);
        }
    }

    public void insertionSort() {
        T key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];
            while (j > 0 && less(key, list[j - 1])) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
    }

    public void insertionSort(Comparator<T> comparator) {
        T key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];
            while (j > 0 && comparator.compare(key, list[j-1]) < 0) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
    }

    public void bubbleSort() {
        boolean isSwapped;
        for (int i = size - 1; i > 0; i--) {
            isSwapped = false;
            for (int j = 0; j < i; j++) {
                if (less(list[j + 1], list[j])) {
                    swap(j + 1, j);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                return;
            }
        }
    }

    public void bubbleSort(Comparator<T> comparator) {
        boolean isSwapped;
        for (int i = size - 1; i > 0; i--) {
            isSwapped = false;
            for (int j = 0; j < i; j++) {
                if (comparator.compare(list[j + 1], list[j]) < 0) {
                    swap(j + 1, j);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                return;
            }
        }
    }
}
