package structures;

public class BinaryNode<AnyType> {

    private Integer element;
    private BinaryNode<AnyType> left;
    private BinaryNode<AnyType> rigth;

    public BinaryNode() {
        this.element = null;
        this.left = null;
        this.rigth = null;
    }

    public BinaryNode(Integer theElement) {
        element = theElement;
        this.left = null;
        this.rigth = null;
    }

    public BinaryNode(Integer theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt) {
        element = theElement;
        rigth = rt;
        left = lt;
    }

    public Integer getElement() {
        return element;
    }

    public BinaryNode<AnyType> getLeft() {
        return left;
    }

    public BinaryNode<AnyType> getRight() {
        return rigth;
    }

    public void setElement(Integer x) {
        element = x;
    }

    public void setLeft(BinaryNode<AnyType> t) {
        left = t;
    }

    public void setRigth(BinaryNode<AnyType> t) {
        rigth = t;
    }

    public static <AnyType> int size(BinaryNode<AnyType> t) {

        if (t == null) return 0;
        else return 1 + size(t.left) + size(t.rigth);
    }


    public BinaryNode<AnyType> duplicate() {

        BinaryNode<AnyType> root = new BinaryNode<>(element, null, null);

        if (left != null) root.left = left.duplicate();
        if (rigth != null) root.rigth = rigth.duplicate();

        return root;
    }

    public void printPreOrder() {
        System.out.print(element + "\t");
        if (left != null) left.printPreOrder();
        if (rigth != null) rigth.printPreOrder();
    }

    public void printPostOrder() {
        if (left != null) left.printPostOrder();
        if (rigth != null) rigth.printPostOrder();
        System.out.print(element + "\t");
    }

    public void printInOrder() {
        if (left != null) left.printInOrder();
        System.out.print(element + "\t");
        if (rigth != null) rigth.printInOrder();
    }

    public void printDraw(String prefix, BinaryNode n, boolean isLeft) {
        if (n != null) {
            printDraw(prefix + "     ", n.getRight(), false);
            System.out.println(prefix + ("|-- ") + n.getElement());
            printDraw(prefix + "     ", n.getLeft(), true);
        }
    }

}
