package utils;

import exceptions.PrintDrawEx;
import exceptions.PrintInOrderEx;

import java.util.Scanner;

//menu con las opciones que cuenta el programa

public class Menu {

    public static void mainMenu() {
        Scanner in = new Scanner(System.in);
        int option;

        do {
            System.out.println("************************\nSeleccione el tipo de TDA:\n1.- Arbol binario" + "\n2.- Arbol AVL\n" + "3.- Monticulo binario\n" + "0.- Salir\n************************");
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
                System.out.println("************************\nSeleccione operacion:\n0.-Inicio" + "\n1.- Crear arbol manual"
                        + "\n2.- Crear aleatoriamente\n" + "\n************************");
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
                        Operations.manualBinaryTree();
                    }
                    if (Operations.AVL) {
                        Operations.manualAvlTree();
                    }
                    /*if (Operations.heap) {

                    }*/
                    operationsMenu();
                    break;
                case 2:
                    if (Operations.BinaryTree) {
                        Operations.randomBinaryTree();
                    }
                    if (Operations.AVL) {
                        Operations.randomAvlTree();
                    }
                    /*f (Operations.heap) {

                    }*/
                    operationsMenu();
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
            System.out.println("************************\nSeleccione operacion:\n0.- Inicio" + "\n-1.- Atras\n" +
                    "1.- Eliminar elemento\n" + "2.- Encontrar elemento\n" + "3.- Agregar elemento\n" + "4.- Imprimir ordenado\n" +
                    "5.- Dibujar arbol\n" + "\n************************");
            option = in.nextInt();

            switch (option) {
                case -1:
                    break;
                case 0:
                    Operations.exit = true;
                    break;
                case 1:
                    if (Operations.BinaryTree) {

                    }
                    if (Operations.AVL) {

                    }
                    /*if (Operations.heap) {

                    }*/
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    if (Operations.BinaryTree) {

                    }
                    if (Operations.AVL) {

                    }
                    /*if (Operations.heap) {

                    }*/
                    break;
                case 5:
                    break;
                default:
                    System.out.println("OPCION INCORRECTA");
                    break;
            }
        } while (option < 0);
    }
}
