package lesson8;

import java.util.LinkedList;

public class ChainHashMap<Key, Value> {
    private int capacity;
    private int size;

    private LinkedList<Node>[] st;

    public ChainHashMap() {
        this.capacity = 8;
        st = new LinkedList[capacity];
        for (int i = 0; i < st.length; i++) {
            st[i] = new LinkedList<>();
        }
    }

    private class Node {
        Key key;
        Value value;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private void checkKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key == null");
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void remove(Key key){
        checkKeyNotNull(key);
        int i = hash(key);
        Node removing = null;
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                removing = node;
            }
        }
        if (removing == null){
            return;
        }
        st[i].remove(removing);
        size--;
    }

    public void put(Key key, Value value) {
        checkKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        st[i].addLast(new Node(key, value));
        size++;
    }

    public Value get(Key key) {
        checkKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            for (Node node : st[i]) {
                sb.append(node.key).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
