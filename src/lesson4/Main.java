package lesson4;

import lesson3.MyPriorityQueue;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> mlq = new MyLinkedList<>();
        mlq.insertFirst("Вася");
        mlq.insertFirst("Петя");
        mlq.insertFirst("Джони");

        for (String s : mlq) {
            System.out.println(s);
        }
    }
}
