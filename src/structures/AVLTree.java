package structures;


public class AVLTree<T extends Comparable<T>> {

    private AVLNode<T> root;

    public AVLNode<T> getRoot() {
        return root;
    }

    public AVLTree<T> insert(T data) {
        root = insert(data, root);
        return this;
    }

    private AVLNode<T> insert(T data, AVLNode<T> node) {
        if (node == null) {
            return new AVLNode<>(data);
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(insert(data, node.getLeftChild()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(insert(data, node.getRightChild()));
        } else {
            return node;
        }
        updateHeight(node);
        return applyRotation(node);
    }


    public void delete(T data) {
        root = delete(data, root);
    }

    private AVLNode<T> delete(T data, AVLNode<T> node) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(delete(data, node.getLeftChild()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(delete(data, node.getRightChild()));
        } else {
            // One Child or Leaf Node (no children)
            if (node.getLeftChild() == null) {
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            }
            // Two Children
            node.setData(getMax(node.getLeftChild()));
            node.setLeftChild(delete(node.getData(), node.getLeftChild()));
        }
        updateHeight(node);
        return applyRotation(node);
    }


    public void printInOrder() {
        PrintInOrder(root);
    }

    private void PrintInOrder(AVLNode<T> node) {
        if (node != null) {
            PrintInOrder(node.getLeftChild());
            System.out.print(node.getData() + "\t");
            PrintInOrder(node.getRightChild());
        }
    }

    public void printDraw() {
        printDraw("", root, false);
    }

    private void printDraw(String prefix, AVLNode n, boolean isLeft) {
        if (n != null) {
            printDraw(prefix + "     ", n.getRightChild(), false);
            System.out.println(prefix + ("|-- ") + n.getData());
            printDraw(prefix + "     ", n.getLeftChild(), true);
        }
    }

    public T getMax() {
        if (isEmpty()) {
            return null;
        }
        return getMax(root);
    }

    private T getMax(AVLNode<T> node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }
        return node.getData();
    }


    public T getMin() {
        if (isEmpty()) {
            return null;
        }
        return getMin(root);
    }

    private T getMin(AVLNode<T> node) {
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }
        return node.getData();
    }


    public boolean isEmpty() {
        return root == null;
    }

    private AVLNode<T> applyRotation(AVLNode<T> node) {
        int balance = balance(node);
        if (balance > 1) {
            if (balance(node.getLeftChild()) < 0) {
                node.setLeftChild(rotateLeft(node.getLeftChild()));
            }
            return rotateRight(node);
        }
        if (balance < -1) {
            if (balance(node.getRightChild()) > 0) {
                node.setRightChild(rotateRight(node.getRightChild()));
            }
            return rotateLeft(node);
        }
        return node;
    }

    private AVLNode<T> rotateRight(AVLNode<T> node) {
        AVLNode<T> leftNode = node.getLeftChild();
        AVLNode<T> centerNode = leftNode.getRightChild();
        leftNode.setRightChild(node);
        node.setLeftChild(centerNode);
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    private AVLNode<T> rotateLeft(AVLNode<T> node) {
        AVLNode<T> rightNode = node.getRightChild();
        AVLNode<T> centerNode = rightNode.getLeftChild();
        rightNode.setLeftChild(node);
        node.setRightChild(centerNode);
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    private void updateHeight(AVLNode<T> node) {
        int maxHeight = Math.max(
                height(node.getLeftChild()),
                height(node.getRightChild())
        );
        node.setHeight(maxHeight + 1);
    }

    private int balance(AVLNode<T> node) {
        return node != null ? height(node.getLeftChild()) - height(node.getRightChild()) : 0;
    }

    private int height(AVLNode<T> node) {
        return node != null ? node.getHeight() : 0;
    }

    public T find(T element) {
        return find(root, element);
    }

    private T find(AVLNode<T> node, T element) {
        if (element.equals(node.getData())) {
            return  node.getData();
        } else if (element.compareTo(node.getData()) < 0) {
            if (node.getLeftChild() != null) return find(node.getLeftChild(), element);
            else return null;
        } else {
            if (node.getRightChild() != null) return find(node.getRightChild(), element);
            else return null;
        }
    }

}
