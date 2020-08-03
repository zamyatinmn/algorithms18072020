package lesson5;

public class Item {
    private int price;
    private int weight;
    private String name;

    public Item(String name, int price, int weight) {
        this.price = price;
        this.weight = weight;
        this.name = name;
    }

    @Override
    public String toString() {
        return name+ " " + price + "$ " + weight +  "kg";
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }
}
