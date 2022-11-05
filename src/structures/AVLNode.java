package structures;


public class AVLNode<T extends Comparable<T>> {

    private T data;
    private int height;
    private AVLNode<T> leftChild;
    private AVLNode<T> rightChild;

    public AVLNode(T data) {
        this.data = data;
        this.height = 1;
        this.leftChild = null;
        this.rightChild = null;
    }

    public AVLNode() {
        this.data = null;
        this.height = 0;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setLeftChild(AVLNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(AVLNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public AVLNode<T> getLeftChild() {
        return this.leftChild;
    }

    public AVLNode<T> getRightChild() {
        return this.rightChild;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }


}



