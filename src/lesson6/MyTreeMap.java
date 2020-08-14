package lesson6;

import java.util.NoSuchElementException;

public class MyTreeMap<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;
        int height;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.size = 1;
            height = 0;
        }
    }

    public int size() {
        return size(root);
    }

    public int height(){
        return height(root);
    }

    private int height(Node node){
        if (node == null || node.left == null && node.right == null){
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node){
        if (node == null || node.left == null && node.right == null){
            return true;
        }
        return Math.abs(height(node.right) - height(node.left)) <=1 && isBalanced(node.left) && isBalanced(node.right);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private boolean isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не должен быть null");
        }
        return true;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        isKeyNotNull(key);

        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    public void put(Key key, Value value) {
        isKeyNotNull(key);
        if (value == null) {
            //delete(key)
            return;
        }
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        node.size = size(node.left) + size(node.right) + 1;
        node.height = height(node) + 1;
        return node;
    }


    public Key minKey() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        node.height = height(node);
        return node;
    }

    public void delete(Key key) {
        isKeyNotNull(key);
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if(cmp> 0){
            node.right = delete(node.right, key);
        } else {
            if(node.left == null){
                return node.right;
            }
            if(node.right == null){
                return node.left;
            }

            Node temp = node;
            node = min(node.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        node.height = height(node);
        return node;
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }
        return toString(node.left) + " " +
                node.key + " = " + node.value +
                " " + toString(node.right);
    }
}
