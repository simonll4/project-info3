package utils;

import structures.*;

import java.util.Scanner;

public class Options {
    static BinaryTree<Integer> randomBinaryTree = new BinaryTree<>();
    static BinaryTree<Integer> manualBinaryTree = new BinaryTree<>();
    static AVLTree<Integer> randomAvlTree = new AVLTree<>();
    static AVLTree<Integer> manualAvlTree = new AVLTree<>();

    public static void randomBinaryTree() {

        Scanner in = new Scanner(System.in);
        int quantity;

        System.out.println("CANTIDAD DE VALORES: ");
        quantity = in.nextInt();

        for (int i = 0; i < quantity; i++) {
            randomBinaryTree.add(generateRandom());
        }
    }

    public static void manualBinaryTree() {
        Scanner in = new Scanner(System.in);
        int value;
        int i = 0;

        System.out.println("INGRESAR VALORES PARA EL ARBOL BINARIO (para finalizar ingrese un numero negativo):");
        do {
            i++;
            System.out.println("VALOR " + i + ": ");
            value = in.nextInt();
            if (value > 0) {
                manualBinaryTree.add(value);
            }

        } while (value > 0);

    }

    public static void showTree() {
        Scanner in = new Scanner(System.in);
        int option;

        System.out.println("---PRINTER---\n1)ARBOL BINARIO ALEATORIO\n2)ARBOL BINARIO MANUAL\n3)ARBOL AVL ALEATORIO\n4)ARBOL AVL MANUAL");
        option = in.nextInt();

        if (option == 1) {
            randomBinaryTree.printInOrder();
        } else if (option == 2) {
            manualBinaryTree.printInOrder();
        } else if (option == 3) {
            randomBinaryTree.printInOrder();
        } else if (option == 4) {
            manualBinaryTree.printInOrder();
        } else {
            System.out.println("OPCION INCORRECTA");
        }

    }

    private static Integer generateRandom() {
        int min = 50;
        int max = 100;

        //Generate random int value from 50 to 100
        int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return random_int;
    }

}
