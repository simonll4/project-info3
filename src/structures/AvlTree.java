package structures;

import java.util.*;

public class AvlTree<K extends Comparable<K>, T> {
    private AvlNode<K, T> root;

    public AvlTree() {
    }

    public AvlTree<K, T> insert(K key, T data) {
        root = insert(key, data, root);
        return this;
    }

    private AvlNode<K, T> insert(K key, T data, AvlNode<K, T> node) {
        if (node == null) {
            return new AvlNode<>(key, data);
        }
        if (key.compareTo(node.getKey()) < 0) {
            node.setLeftChild(insert(key, data, node.getLeftChild()));
        } else if (key.compareTo(node.getKey()) > 0) {
            node.setRightChild(insert(key, data, node.getRightChild()));
        } else {
            return node;
        }
        updateHeight(node);
        return applyRotation(node);
    }

    public AvlNode<K, T> get(K key) {
        return get(key, root);
    }

    private AvlNode<K, T> get(K key, AvlNode<K, T> node) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.getKey()) < 0) {
            return get(key, node.getLeftChild());
        } else if (key.compareTo(node.getKey()) > 0) {
            return get(key, node.getRightChild());
        } else {
            return node;
        }
    }

    public AvlNode<K, T> getRoot() {
        return this.root;
    }

    public void delete(K key) {
        root = delete(key, root);
    }

    private AvlNode<K, T> delete(K key, AvlNode<K, T> node) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.getKey()) < 0) {
            node.setLeftChild(delete(key, node.getLeftChild()));
        } else if (key.compareTo(node.getKey()) > 0) {
            node.setRightChild(delete(key, node.getRightChild()));
        } else {
            if (node.getLeftChild() == null) {
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            }

            AvlNode<K, T> tempNode = getMax(node.getLeftChild());
            node.setKey(tempNode.getKey());
            node.setData(tempNode.getData());
            node.setLeftChild(delete(node.getKey(), node.getLeftChild()));
        }
        updateHeight(node);
        return applyRotation(node);
    }

    private AvlNode<K, T> applyRotation(AvlNode<K, T> node) {
        int balance = balance(node);
        if (balance > 1) {
            // esta desbalanceado a la izquierda
            if (balance(node.getLeftChild()) < 0) {
                node.setLeftChild(rotateLeft(node.getLeftChild()));
            }
            return rotateRight(node);
        }
        if (balance < -1) {
            // esta desbalanceado a la derecha
            if (balance(node.getRightChild()) > 0) {
                node.setRightChild(rotateRight(node.getRightChild()));
            }
            return rotateLeft(node);
        }
        return node;
    }

    private AvlNode<K, T> rotateRight(AvlNode<K, T> node) {
        AvlNode<K, T> leftNode = node.getLeftChild();
        AvlNode<K, T> centerNode = leftNode.getRightChild();
        leftNode.setRightChild(node);
        node.setLeftChild(centerNode);
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    private AvlNode<K, T> rotateLeft(AvlNode<K, T> node) {
        AvlNode<K, T> rightNode = node.getRightChild();
        AvlNode<K, T> centerNode = rightNode.getLeftChild();
        rightNode.setLeftChild(node);
        node.setRightChild(centerNode);
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    private int balance(AvlNode<K, T> node) {
        return node != null ? height(node.getLeftChild()) - height(node.getRightChild()) : 0;
    }

    private void updateHeight(AvlNode<K, T> node) {
        int maxHeight = Math.max(height(node.getLeftChild()), height(node.getRightChild()));
        node.setHeight(maxHeight + 1);
    }

    private int height(AvlNode<K, T> node) {
        return node != null ? node.getHeight() : 0;
    }

    /**
     * Devolver una lista enlazada con los datos del arbol utilizando el criterio "In Order".
     *
     * @return lista de mails ordenados in order
     */
    public LinkedList<T> getSorteredInOrderList() {
        LinkedList<T> list = new LinkedList<>();
        getInOrder(this.root, list);
        return list;
    }

    /**
     * Devolver una lista enlazada con los datos del arbol utilizando el criterio "In Order", pero que ademas este filtrando desde un parametro "from" hasta un "to".
     *
     * @param from inicio del filtrado
     * @param to   fin del filtrado
     * @return lista de mails ordenados in order filtrados
     */
    public LinkedList<T> getInorderedSegmentedList(K from, K to) {
        LinkedList<T> list = new LinkedList<>();
        getInOrderedSegmented(this.root, list, from, to);
        return list;
    }

    /* Given a binary tree, print its nodes in inorder*/
    private void getInOrderedSegmented(AvlNode<K, T> node, LinkedList<T> list, K from, K to) {
        if (node == null)
            return;

        /* first recur on left child */
        if (node.getKey().compareTo(from) > 0)
            getInOrderedSegmented(node.getLeftChild(), list, from, to);

        /* then print the data of node */
        if (node.getKey().compareTo(from) > 0 && node.getKey().compareTo(to) < 0)
            try {
                list.add(node.getData());
            } catch (Exception e) {
                System.out.println(e);
            }

        /* now recur on right child */
        if (node.getKey().compareTo(to) < 0)
            getInOrderedSegmented(node.getRightChild(), list, from, to);
    }

    private void getPostOrder(AvlNode<K, T> node, LinkedList<T> list) {
        if (node == null)
            return;

        getPostOrder(node.getLeftChild(), list);
        getPostOrder(node.getRightChild(), list);

        try {
            list.add(node.getData());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void getInOrder(AvlNode<K, T> node, LinkedList<T> list) {
        if (node == null)
            return;

        getInOrder(node.getLeftChild(), list);

        // Agregarlo a la lista
        try {
            list.add(node.getData());
        } catch (Exception e) {
            System.out.println(e);
        }

        getInOrder(node.getRightChild(), list);
    }

    private void getPreOrder(AvlNode<K, T> node, LinkedList<T> list) {
        if (node == null)
            return;

        try {
            list.add(node.getData());
        } catch (Exception e) {
            System.out.println(e);
        }

        getPreOrder(node.getLeftChild(), list);
        getPreOrder(node.getRightChild(), list);
    }

    public AvlNode<K, T> getMax() {
        if (isEmpty()) {
            return null;
        }
        return getMax(root);
    }

    private AvlNode<K, T> getMax(AvlNode<K, T> node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }
        return node;
    }

    public AvlNode<K, T> getMin() {
        if (isEmpty()) {
            return null;
        }
        return getMin(root);
    }

    public AvlNode<K, T> getMin(AvlNode<K, T> node) {
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }
        return node;
    }

    public boolean isEmpty() {
        return false;
    }

    /**
     * Internal method to print a subtree in sorted order.
     *
     * @param t the node that roots the tree.
     */
    private void printTree(AvlNode<K, T> t) {
        if (t != null) {
            printTree(t.getLeftChild());
            System.out.println(t.getKey());
            printTree(t.getRightChild());
        }
    }

    public void print() {
        print(false, "", root);
    }

    private void print(boolean isRight, String identation, AvlNode<K, T> r) {
        if (r.getRightChild() != null) {
            print(true, identation + (isRight ? "     " : "|    "), r.getRightChild());
        }
        System.out.print(identation);
        if (isRight) {
            System.out.print(" /");
        } else {
            System.out.print(" \\");
        }
        System.out.print("-- ");
        System.out.println(r.getKey());
        if (r.getLeftChild() != null) {
            print(false, identation + (isRight ? "|    " : "     "), r.getLeftChild());
        }
    }
}
