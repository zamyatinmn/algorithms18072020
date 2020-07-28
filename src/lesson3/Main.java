package lesson3;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        String string = "А роза упала на лапу Азора";
        System.out.println(string);
        System.out.println(Palindrom.reverse(string));

        MyDeque<Integer> deque = new MyDeque<>();
        deque.insertFront(3);
        deque.insertFront(2);
        deque.insertFront(1);
        deque.insertBack(4);
        deque.insertBack(5);
        System.out.println(deque.toString());
        deque.removeBack();
        deque.removeFront();
        System.out.println(deque.toString());

        MyPriorityQueue<Integer> prior = new MyPriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        prior.insert(5);
        prior.insert(1);
        prior.insert(7);
        prior.insert(4);
        System.out.println(prior.toString());
    }
}
