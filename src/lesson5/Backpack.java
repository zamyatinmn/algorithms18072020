package lesson5;

import java.util.ArrayList;

public class Backpack {
    private int capacity;
    private ArrayList<Item> bestChoice = null;
    private int bestPrice;

    public Backpack(int capacity) {
        this.capacity = capacity;
    }

    private int calcWeight(ArrayList<Item> list) {
        int sum = 0;
        for (Item item : list) {
            sum += item.getWeight();
        }
        return sum;
    }

    private int calcPrice(ArrayList<Item> list) {
        int sum = 0;
        for (Item item : list) {
            sum += item.getPrice();
        }
        return sum;
    }

    private void checkSet(ArrayList<Item> list) {
        if (bestChoice == null) {
            if (calcWeight(list) <= capacity) {
                bestChoice = list;
                bestPrice = calcPrice(list);
            }
        } else {
            if (calcWeight(list) <= capacity && calcPrice(list) > bestPrice) {
                bestChoice = list;
                bestPrice = calcPrice(list);
            }
        }
    }

    public void takeItems(ArrayList<Item> list) {
        if (list.size() > 0){
            checkSet(list);
        }
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Item> newSet = new ArrayList<>(list);
            newSet.remove(i);
            takeItems(newSet);
        }
    }

    public ArrayList<Item> getBestChoice(){
        return bestChoice;
    }

    public int getBestPrice() {
        return bestPrice;
    }
}
