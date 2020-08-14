package lesson8;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int NUM = 10;
        ChainHashMap<Integer, Integer> map = new ChainHashMap<>();
        Random random = new Random();
        int[] arr = new int[NUM];
        for (int i = 0; i < NUM; i++) {
            arr[i] = random.nextInt(1000);
            map.put(arr[i], 1);
        }

        System.out.println("Before removing \n" + map);
        System.out.println("Removing item " + arr[0]);
        map.remove(arr[0]);
        System.out.println("After removing \n" + map);
    }
}
