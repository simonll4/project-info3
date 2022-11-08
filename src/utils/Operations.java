package utils;

import structures.AVLTree;
import structures.BinaryTree;
import structures.Heap;
import structures.MaximumHeap;

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
    static Heap randomHeap = new MaximumHeap();
    static Heap manualHeap = new MaximumHeap();

    //seleccion de tipo de TDA
    static boolean BinaryTree = false; // bandera de seleccion de TDA
    static boolean AVL = false; // bandera de seleccion de TDA
    static boolean heap = false; //bandera de seleccion de TDA
    static boolean exit = false; //bandera para moverse en el menu
    static boolean manual = false; //bandera que diferencia entre arbol random(true) y manual(false)

    //crea un arbol binario con numeros aleatorios
    public static void createRandomBinaryTree() {
        randomBinaryTree.makeEmpty();
        Scanner in = new Scanner(System.in);
        int quantity;

        System.out.println("CANTIDAD DE VALORES: ");
        quantity = in.nextInt();

        for (int i = 0; i < quantity; i++) {
            randomBinaryTree.addNotRep(generateRandom());
        }
    }

    //crea un arbol binario con numeros ingresados por consola
    public static void createManualBinaryTree() {
        manualBinaryTree.makeEmpty();
        Scanner in = new Scanner(System.in);
        int value;
        int i = 0;

        System.out.println("INGRESAR VALORES PARA EL ARBOL BINARIO (para finalizar ingrese un numero negativo):");
        do {
            i++;
            System.out.println("VALOR " + i + ": ");
            value = in.nextInt();
            if (value > 0) {
                manualBinaryTree.addNotRep(value);
            }
        } while (value > 0);
    }

    //crea un arbol binario AVL con numeros aleatorios
    public static void createRandomAvlTree() {
        randomAvlTree.makeEmpty();

        Scanner in = new Scanner(System.in);
        int quantity;

        System.out.println("CANTIDAD DE VALORES: ");
        quantity = in.nextInt();

        for (int i = 0; i < quantity; i++) {
            randomAvlTree.insert(generateRandom());
        }
    }

    //crea un arbol binario AVL con numeros ingresados por consola
    public static void createManualAvlTree() {
        manualAvlTree.makeEmpty();
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

    //crea un monticulo con numeros aleatorios
    public static void createRandomHeap() {
        randomHeap.makeEmpty();

        Scanner in = new Scanner(System.in);
        int quantity;

        System.out.println("CANTIDAD DE VALORES: ");
        quantity = in.nextInt();

        for (int i = 0; i < quantity; i++) {
            randomHeap.insert(generateRandom());
        }
    }

    // Crea un monticulo binario con numeros ingresados por consola
    public static void createManualHeap() {
        manualHeap.makeEmpty();
        Scanner in = new Scanner(System.in);
        int value;
        int i = 0;

        System.out.println("INGRESAR VALORES PARA EL MONTICULO BINARIO (para finalizar ingrese un numero negativo):");
        do {
            i++;
            System.out.println("VALOR " + i + ": ");
            value = in.nextInt();
            if (value > 0) {
                manualHeap.insert(value);
            }
        } while (value > 0);
    }

    // Agrega un elemento al arbol seleccionado
    public static void addElement() {
        Scanner in = new Scanner(System.in);
        Integer element;

        System.out.println("Ingrese valor entero que desea agregar al arbol: ");
        element = in.nextInt();

        if (BinaryTree) {
            if (manual) {
                manualBinaryTree.addNotRep(element);
            } else {
                randomBinaryTree.addNotRep(element);
            }
        }
        if (AVL) {
            if (manual) {
                manualAvlTree.insert(element);
            } else {
                randomAvlTree.insert(element);
            }
        }
        if (heap) {
            if (manual) {
                manualHeap.insert(element);
            } else {
                randomHeap.insert(element);
            }
        }
    }

    // Borra un elemento del arbol seleccionado
    public static void delete() {
        Scanner in = new Scanner(System.in);
        int element;
        System.out.println("Ingrese el valor que desea borrar: ");
        element = in.nextInt();

        if (BinaryTree) {
            if (manual) {
                manualBinaryTree.delete(element);
            } else {
                randomBinaryTree.delete(element);
            }
        }
        if (AVL) {
            if (manual) {
                manualAvlTree.delete(element);
            } else {
                randomAvlTree.delete(element);
            }
        }
        if (heap) {
            if (manual) {
                manualHeap.removeElement(element);
            } else {
                randomHeap.removeElement(element);
            }
        }
    }

    // Busca un elemento en el arbol seleccionado
    public static void find() {
        Scanner in = new Scanner(System.in);
        int element;
        Integer searched = null;
        System.out.println("Ingrese el valor que desea encontrar: ");
        element = in.nextInt();

        if (BinaryTree) {
            if (manual) {
                searched = manualBinaryTree.find(element);
            } else {
                searched = randomBinaryTree.find(element);
            }
        }
        if (AVL) {
            if (manual) {
                searched = manualAvlTree.find(element);
            } else {
                searched = randomAvlTree.find(element);
            }
        }
        if (heap) {
            if (manual) {
                searched = manualHeap.find(element);
            } else {
                searched = randomHeap.find(element);
            }
        }

        if (searched != null) {
            System.out.println("---------------------------------\nEL VALOR SE ENCUENTRA EN EL ARBOL\n---------------------------------");
        } else {
            System.out.println("------------------------------------\nEL VALOR NO SE ENCUENTRA EN EL ARBOL\n------------------------------------");
        }
    }

    //metodo para ejecutar el printInOrder para cada arbol ya creado
    public static void printInOrder() {
        if (BinaryTree) {
            if (manual) {
                manualBinaryTree.printInOrder();
            } else {
                randomBinaryTree.printInOrder();
            }
        }
        if (AVL) {
            if (manual) {
                manualAvlTree.printInOrder();
            } else {
                randomAvlTree.printInOrder();
            }
        }
        if (heap) {
            if (manual) {
                manualHeap.printInOrder();
            } else {
                randomHeap.printInOrder();
            }
        }
    }

    //metodo para dibujar los arboles ya creados en consola
    public static void printDrawTree() {
        if (BinaryTree) {
            if (manual) {
                manualBinaryTree.printDraw();
            } else {
                randomBinaryTree.printDraw();
            }
        }
        if (AVL) {
            if (manual) {
                manualAvlTree.printDraw();
            } else {
                randomAvlTree.printDraw();
            }
        }
    }

    //genera numeros aleatorios en un intervalo definido
    private static Integer generateRandom() {
        int min = 1;
        int max = 100;

        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}
