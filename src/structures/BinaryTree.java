package structures;

import exceptions.PrintDrawEx;
import exceptions.PrintInOrderEx;

import java.lang.Exception;

public class BinaryTree<AnyType> {

    private BinaryNode<AnyType> root;

    public BinaryTree() {
        root = new BinaryNode<>();
    }

    public BinaryTree(Integer rootItem) {
        root = new BinaryNode<>(rootItem, null, null);
    }

    public void add(Integer element) {
        add(root, element);
    }

    public void add(BinaryNode<AnyType> node, Integer element) {

        if (node.getElement() == null) {    //chequeo si el arbol esta vacio
            node.setElement(element);
        } else {
            if (element < node.getElement()) {
                if (node.getLeft() != null) add(node.getLeft(), element);
                else node.setLeft(new BinaryNode<>(element));
            } else {
                if (node.getRight() != null) add(node.getRight(), element);
                else node.setRigth(new BinaryNode<>(element));
            }
        }
    }

    public void addNotRep(Integer element) throws Exception {
        addNotRep(element, root);
    }

    public void addNotRep(Integer element, BinaryNode<AnyType> node) throws Exception {
        if (element < node.getElement()) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryNode<>(element));
            } else {
                addNotRep(element, node.getLeft());
            }
        } else if (element > node.getElement()) {
            if (node.getRight() == null) {
                node.setRigth(new BinaryNode<>(element));
            } else {
                addNotRep(element, node.getRight());
            }
        } else {
            throw new Exception("El elemento ya esta en el arbol");
        }
    }

    public void delete(Integer element) throws Exception {
        delete(element, root);
    }

    public BinaryNode<AnyType> delete(Integer element, BinaryNode<AnyType> node) throws Exception {
        if (element.equals(node.getElement())) {
            if (node.getLeft() == null && node.getRight() == null) node = null;
            else if (node.getRight() == null) node = node.getLeft();
            else if (node.getLeft() == null) node = node.getRight();
            else {
                BinaryNode<AnyType> aux = node.getLeft();
                node = node.getRight();
                BinaryNode<AnyType> aux2 = node.getLeft();
                if (aux2 != null) {
                    while (aux2.getLeft() != null) {
                        aux2 = aux2.getLeft();
                    }
                    aux2.setLeft(aux);
                } else node.setLeft(aux);
            }
        } else if (element < node.getElement() && node.getLeft() != null) node.setLeft(delete(element, node.getLeft()));
        else if (element > node.getElement() && node.getRight() != null)
            node.setRigth(delete(element, node.getRight()));
        else throw new Exception("El elemento no esta en el arbol");
        return node;
    }

    public Integer find(Integer element) {
        return find(root, element);
    }

    public Integer find(BinaryNode node, Integer element) {

        if (element.equals(node.getElement())) {
            return node.getElement();
        } else if (element < node.getElement()) {
            if (node.getLeft() != null) return find(node.getLeft(), element);
            else return null;
        } else {
            if (node.getRight() != null) return find(node.getRight(), element);
            else return null;
        }

    }

    public BinaryNode<AnyType> getRoot() {
        return root;
    }

    public int size() {
        return BinaryNode.size(root);
    }

    public int height() {
        return height(root);
    }

    public static <AnyType> int height(BinaryNode<AnyType> t) {

        if (t == null) return -1;
        else return 1 + Math.max(height(t.getLeft()), height(t.getRight()));
    }

    public void printPreOrder() {
        if (root != null) printPreOrder();
    }

    public void printInOrder() {
        root.printInOrder();
    }
    /*
    public void printInOrder() throws PrintInOrderEx {
        if (root.getElement() == null) throw new PrintInOrderEx("ARBOL VACIO");
        root.printInOrder();
    }
     */

    public void printPostOrder() {
        if (root != null) root.printPostOrder();
    }

    public void printDraw() {
        root.printDraw("", root, false);
    }

    /*public void printDraw() throws PrintDrawEx {
        if (root.getElement() == null) throw new PrintDrawEx("ARBOL VACIO");
        root.printDraw("", root, false);
    }*/

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void merge(Integer rootItem, BinaryTree<AnyType> t1, BinaryTree<AnyType> t2) {

        if (t1.root == t2.root && t1.root != null) throw new IllegalArgumentException();

        root = new BinaryNode<>(rootItem, t1.root, t2.root);

        if (this != t1) t1.root = null;
        if (this != t2) t2.root = null;

    }


}

