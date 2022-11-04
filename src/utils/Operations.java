package utils;

import exceptions.PrintDrawEx;
import exceptions.PrintInOrderEx;
import structures.*;

import java.util.Scanner;

/*
    clase utilizada para ejecutar las opciones selecionadas
    en Menu.java
 */

public class Operations {
    static BinaryTree<Integer> randomBinaryTree = new BinaryTree<>();
    static BinaryTree<Integer> manualBinaryTree = new BinaryTree<>();
    static AVLTree<Integer> randomAvlTree = new AVLTree<>();
    static AVLTree<Integer> manualAvlTree = new AVLTree<>();

    //seleccion de tipo de TDA
    static boolean BinaryTree = false;
    static boolean AVL = false;
    static boolean heap = false;

    static boolean exit = false;

    //crea un arbol binario con numeros aleatorios
    public static void randomBinaryTree() {

        Scanner in = new Scanner(System.in);
        int quantity;

        System.out.println("CANTIDAD DE VALORES: ");
        quantity = in.nextInt();

        for (int i = 0; i < quantity; i++) {
            randomBinaryTree.add(generateRandom());
        }
    }

    //crea un arbol binario con numeros ingresados por consola
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

    //crea un arbol binario AVL con numeros aleatorios
    public static void randomAvlTree() {

        Scanner in = new Scanner(System.in);
        int quantity;

        System.out.println("CANTIDAD DE VALORES: ");
        quantity = in.nextInt();

        for (int i = 0; i < quantity; i++) {
            randomAvlTree.insert(generateRandom());
        }
    }

    //crea un arbol binario AVL con numeros ingresados por consola
    public static void manualAvlTree() {
        Scanner in = new Scanner(System.in);
        int value;
        int i = 0;

        System.out.println("INGRESAR VALORES PARA EL ARBOL BINARIO (para finalizar ingrese un numero negativo):");
        do {
            i++;
            System.out.println("VALOR " + i + ": ");
            value = in.nextInt();
            if (value > 0) {
                manualAvlTree.insert(value);
            }
        } while (value > 0);
    }

    //metodo para ejecutar el printInOrder para cada arbol ya creado
    public static void printInOrderBinaryTree(int option) {
        Scanner in = new Scanner(System.in);
        // Primero ver la vandera para ver el tipo de arbol
        // Me fijo si es manual o aleatorio
        if (option == 0) {
            manualBinaryTree.printInOrder();
        } else if (option == 1) {
            randomBinaryTree.printInOrder();
        }
    }

    //metodo para dibujar los arboles ya creados en consola
    public static void printDrawTree() {
        Scanner in = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n---PRINTER---\n0)salir\n1)ARBOL BINARIO ALEATORIO\n2)ARBOL BINARIO MANUAL\n3)ARBOL AVL ALEATORIO\n4)ARBOL AVL MANUAL");
            option = in.nextInt();

            if (option == 1) {
                randomBinaryTree.printDraw();
            } else if (option == 2) {

                manualBinaryTree.printDraw();
            } else if (option == 3) {

                randomAvlTree.printDraw();
            } else if (option == 4) {

                manualAvlTree.printDraw();
            } else if (option == 0) {
                break;
            } else {
                System.out.println("OPCION INCORRECTA");
            }
        } while (option != 0);
    }

    //genera numeros aleatorios en un intervalo definido
    private static Integer generateRandom() {
        int min = 1;
        int max = 100;

        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

}
