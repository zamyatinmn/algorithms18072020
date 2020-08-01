package lesson4;

public class MyLinkedQueue<T> {
    private MyLinkedList<T> queue = new MyLinkedList<>();

    public void insert(T item){
        queue.insertLast(item);
    }

    public T remove(){
        return queue.deleteFirst();
    }

    public T peek(){
        return queue.getFirst();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public int size(){
        return queue.size();
    }
}
