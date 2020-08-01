package lesson4;

public class MyOneLinkedList<T> {
    private Node first;
    private int size;

    public MyOneLinkedList() {
        first = null;
    }

    private class Node {
        T value;
        Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
        }
    }

    public void insertFirst(T item) {
        Node newNode = new Node(item, first);
        first = newNode;
        size++;
    }

    public T deleteFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        Node oldFirst = first;
        first = first.next;
        size--;
        return oldFirst.value;
    }

    public void insert(int index, T item) {
        if (index < 0 || index > size) {
            throw new RuntimeException("Incorrect index: " + index);
        }
        if (index == 0) {
            insertFirst(item);
            return;
        }
        Node current = first;
        int i = 0;
        while (i < index - 1) {
            current = current.next;
            i++;
        }
        Node newNode = new Node(item, current.next);
        current.next = newNode;
        size++;
    }

    public boolean delete(T item) {
        if (isEmpty()) {
            return false;
        }
        if (first.value.equals(item)) {
            deleteFirst();
            return true;
        }
        Node current = first;
        while (current.next != null && !current.next.value.equals(item)) {
            current = current.next;
        }
        if (current.next == null) {
            return false;
        }
        current.next = current.next.next;
        size--;
        return true;
    }


    public T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        return first.value;
    }


    public int indexOf(T item) {
        return index(item);
    }

    private int index(T item){
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.value.equals(item)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(T item) {
        return index(item) > -1;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder sb = new StringBuilder("[");

        while (current != null) {
            sb.append(current.value).append(", ");
            current = current.next;
        }
        if (sb.length() > 2) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");

        return sb.toString();
    }
}
