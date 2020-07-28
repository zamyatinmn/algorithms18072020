package lesson2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        MyArrayList<Integer> arr1 = new MyArrayList<>();
        MyArrayList<Integer> arr2 = new MyArrayList<>();
        MyArrayList<Integer> arr3 = new MyArrayList<>();


        for (int i = 0; i < 100000; i++) {
            int temp = random.nextInt();
            arr1.add(temp);
            arr2.add(temp);
            arr3.add(temp);
        }

        long start = System.currentTimeMillis();
        arr1.bubbleSort();
        System.out.println("Время сортировки пузырьком " + (System.currentTimeMillis()-start) + "мс");


        start = System.currentTimeMillis();
        arr2.selectionSort();
        System.out.println("Время сортировки выбором " + (System.currentTimeMillis()-start) + "мс");

        start = System.currentTimeMillis();
        arr3.insertionSort();
        System.out.println("Время сортировки вставкой " + (System.currentTimeMillis()-start) + "мс");
    }
}
