package structures;

public class Main {

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.add(50);
        tree.add(20);
        tree.add(30);
        tree.add(60);
        tree.add(80);

        try{
            tree.addNotRep(10);
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("print postOrder");
        tree.printPostOrder();
        System.out.println("print preOrder");
        tree.printPreOrder();
        System.out.println("print inOrder");
        tree.printInOrder();

        if (tree.find(20) != null) System.out.println("NUMERO ECONTRADO");

        try{
            tree.delete(20);
            tree.delete(80);
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("print postOrder");
        tree.printPostOrder();

        //////////////////////////////////////////////////
        //////////////////////////////////////////////////
        System.out.println("****AVL TREE*****");
        AVLTree<Integer> treeAVL = new AVLTree<>();

        treeAVL.insert(50);
        treeAVL.insert(20);
        treeAVL.insert(30);
        treeAVL.insert(60);
        treeAVL.insert(80);
        treeAVL.insert(20);
        treeAVL.printInOrder();

        //if (treeAVL.find(20) != null) System.out.println("NUMERO ECONTRADO");

        treeAVL.delete(20);
        treeAVL.delete(80);
        System.out.println("print inOrder");
        treeAVL.printInOrder();


    }

}
