package lesson6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rd = new Random();
        int balancedCount = 0;
        int trees = 100000;

        for (int i = 0; i < trees; i++) {
            MyTreeMap<Integer, Integer> map = new MyTreeMap<>();
            while (map.height() != 6){
                map.put(rd.nextInt(200) - 100, rd.nextInt());
            }
            if (map.isBalanced()){
                balancedCount++;
            }
        }

        System.out.println("Balanced trees - " + (double)balancedCount/trees*100 + "%");
        System.out.println("Unbalanced trees - " + (double)(trees - balancedCount)/trees*100 + "%");
    }
}
