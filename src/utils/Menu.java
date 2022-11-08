package utils;

import java.util.Scanner;

//menu con las opciones que cuenta el programa

public class Menu {

    public static void mainMenu() {
        Scanner in = new Scanner(System.in);
        int option;

        do {
            Operations.exit = false;
            System.out.println("\n*************************\nSeleccione el tipo de TDA:\n1.- Arbol binario" + "\n2.- Arbol AVL\n" + "3.- Monticulo binario\n" + "0.- Salir\n************************");
            option = in.nextInt();

            switch (option) {
                case 0:
                    break;
                case 1:
                    Operations.BinaryTree = true;
                    creationMenu();
                    break;
                case 2:
                    Operations.AVL = true;
                    creationMenu();
                    break;
                case 3:
                    Operations.heap = true;
                    creationMenu();
                    break;
                default:
                    System.out.println("OPCION INCORRECTA");
                    break;
            }
        } while (option != 0);
    }

    private static void creationMenu() {
        Scanner in = new Scanner(System.in);
        int option;

        do {
            if (!Operations.exit) {
                System.out.println("\n************************\nSeleccione operacion:\n0.-Inicio" + "\n1.- Crear arbol manual" + "\n2.- Crear aleatoriamente");
                if (Operations.BinaryTree && !Operations.manualBinaryTree.isEmpty() || Operations.AVL && !Operations.manualAvlTree.isEmpty() || Operations.heap && !Operations.manualHeap.isEmpty()) {
                    System.out.println("3.- Realizar operaciones arbol manual");
                }
                if (Operations.BinaryTree && !Operations.randomBinaryTree.isEmpty() || Operations.AVL && !Operations.randomAvlTree.isEmpty() || Operations.heap && !Operations.randomHeap.isEmpty()) {
                    System.out.println("4.- Realizar operaciones arbol aleatorio");
                }
                System.out.println("************************");
                option = in.nextInt();
            } else {
                option = 0;
            }

            switch (option) {
                case 0:
                    Operations.BinaryTree = false;
                    Operations.AVL = false;
                    Operations.heap = false;
                    break;
                case 1:
                    if (Operations.BinaryTree) {
                        Operations.createManualBinaryTree();
                    }
                    if (Operations.AVL) {
                        Operations.createManualAvlTree();
                    }
                    if (Operations.heap) {
                        Operations.createManualHeap();
                    }
                    break;
                case 2:
                    if (Operations.BinaryTree) {
                        Operations.createRandomBinaryTree();
                    }
                    if (Operations.AVL) {
                        Operations.createRandomAvlTree();
                    }
                    if (Operations.heap) {
                        Operations.createRandomHeap();
                    }
                    break;
                case 3:
                    if (Operations.BinaryTree && !Operations.manualBinaryTree.isEmpty() || Operations.AVL && !Operations.manualAvlTree.isEmpty() || Operations.heap && !Operations.manualHeap.isEmpty()) {
                        Operations.manual = true;
                        operationsMenu();
                    } else {
                        System.out.println("OPCION INCORRECTA");
                    }
                    break;
                case 4:
                    if (Operations.BinaryTree && !Operations.randomBinaryTree.isEmpty() || Operations.AVL && !Operations.randomAvlTree.isEmpty() || Operations.heap && !Operations.randomHeap.isEmpty()) {
                        Operations.manual = false;
                        operationsMenu();
                    } else {
                        System.out.println("OPCION INCORRECTA");
                    }
                    break;
                default:
                    System.out.println("OPCION INCORRECTA");
                    break;
            }
        } while (option != 0);
    }

    private static void operationsMenu() {
        Scanner in = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n************************\nSeleccione operacion:\n0.- Inicio" + "\n-1.- Atras\n" + "1.- Eliminar elemento\n" + "2.- Encontrar elemento\n" + "3.- Agregar elemento\n" + "4.- Imprimir ordenado");
            if (!Operations.heap) {
                System.out.print("5.- Dibujar arbol\n" + "************************\n");
            }
            option = in.nextInt();

            switch (option) {
                case -1:
                    Operations.manual = false;
                    break;
                case 0:
                    Operations.exit = true;
                    break;
                case 1:
                    Operations.delete();
                    break;
                case 2:
                    Operations.find();
                    break;
                case 3:
                    Operations.addElement();
                    break;
                case 4:
                    Operations.printInOrder();
                    break;
                case 5:
                    if (!Operations.heap) {
                        Operations.printDrawTree();
                    } else {
                        System.out.println("OPCION INCORRECTA");
                    }
                    break;
                default:
                    System.out.println("OPCION INCORRECTA");
                    break;
            }
        } while (option > 0);
    }
}
