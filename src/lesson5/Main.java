package lesson5;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        long start = System.nanoTime();
        System.out.println(Recursive.power(12, 9));
        System.out.println(System.nanoTime() - start);


        ArrayList<Item> stock = new ArrayList<>();
        stock.add(new Item("Гитара", 1500, 1));
        stock.add(new Item("Магнитофон", 3000, 4));
        stock.add(new Item("Ноутбук", 2000, 3));
        stock.add(new Item("Iphone", 2000, 1));
        System.out.println("Все предметы: " + stock.toString());

        Backpack backpack = new Backpack(4);
        backpack.takeItems(stock);
        System.out.println("Лучший набор предметов: " + backpack.getBestChoice());
        System.out.println("Лучшая цена: " + backpack.getBestPrice() + "$");
    }
}
