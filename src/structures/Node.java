package structures;


public class Node<T extends Comparable<T>> {

    private T data;

    private int height;

    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T data) {
        this.data = data;
        this.height = 1;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public Node<T> getLeftChild() {
        return this.leftChild;
    }

    public Node<T> getRightChild() {
        return this.rightChild;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}



