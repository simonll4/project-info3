package structures;


import utils.TreePrinter;

public class AvlNode<K extends Comparable<K>, T> implements TreePrinter.PrintableNode {
    private T data;
    private K key;
    private int height = 1;
    private AvlNode<K, T> leftChild;
    private AvlNode<K, T> rightChild;

    public AvlNode(K key, T data) {
        this.data = data;
        this.key = key;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AvlNode<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AvlNode<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public AvlNode<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(AvlNode<K, T> rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * Get left child
     */
    @Override
    public TreePrinter.PrintableNode getLeft() {
        return getLeftChild();
    }

    /**
     * Get right child
     */
    @Override
    public TreePrinter.PrintableNode getRight() {
        return getRightChild();
    }

    /**
     * Get text to be printed
     */
    @Override
    public String getText() {
        return String.valueOf(this.key);
    }
}

