package structures;

import java.util.Scanner;

public class BinaryTree<AnyType> {

    private BinaryNode<AnyType> root;

    public BinaryTree() {
        root = new BinaryNode<>();
    }

    public BinaryTree(Integer rootItem) {
        root = new BinaryNode<>(rootItem, null, null);
    }

    public void add(Integer element) {
        root.add(root, element);
    }

    public void addNotRep(Integer element) throws Exception {
        root.addNotRep(element, root);
    }

    public void delete(Integer element) throws Exception {
        root.delete(element, root);
    }

    public Integer find(Integer element) {
        return root.find(root, element);
    }

    public BinaryNode<AnyType> getRoot() {
        return root;
    }

    public int size() {
        return BinaryNode.size(root);
    }

    public int height() {
        return BinaryNode.height(root);
    }

    public void printPreOrder() {
        if (root != null) root.printPreOrder();
    }

    public void printInOrder() {
        if (root != null) root.printInOrder();
    }

    public void printPostOrder() {
        if (root != null) root.printPostOrder();
    }

    public void printDraw() {
        root.printDraw("", root, false);
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void merge(Integer rootItem, BinaryTree<AnyType> t1, BinaryTree<AnyType> t2) {

        if (t1.root == t2.root && t1.root != null) throw new IllegalArgumentException();

        //allocate new node
        root = new BinaryNode<>(rootItem, t1.root, t2.root);

        //ensure that every node is in one tree
        if (this != t1) t1.root = null;
        if (this != t2) t2.root = null;

    }


}

