package utils;

import exceptions.PrintDrawEx;
import exceptions.PrintInOrderEx;

import java.util.Scanner;

/*
    menu con las opciones que cuenta el programa
 */

public class Menu {

    public static void startMenu() {
        Scanner in = new Scanner(System.in);
        int option = 0;

        do {
            if (!Options.flagOrder && !Options.flagDraw) {
                System.out.println("************************\nElige opción:\n1.- Crear arbol aleatorio" + "\n2.- Crear arbol manual\n" + "3.- Crear arbol AVL aleatorio\n" + "4.- Crear arbol AVL manual\n" + "5.- Mostrar arbol ordenado\n" + "6.- Mostrar dibujo de arbol\n" + "0.- Salir\n************************");
                option = in.nextInt();
            } else {
                System.out.println("--------------------------------------------------------------------------------\n" + "WARNING: EL PROGRAMA NO PUEDE CONTINUAR, DEBES CREAR EL ARBOL QUE DESEA IMPRIMIR\n" + "--------------------------------------------------------------------------------");
            }

            switch (option) {
                case 0:
                    break;
                case 1:
                    Options.randomBinaryTree();
                    Tools.solvePrint();
                    option = Options.aux;
                    break;
                case 2:
                    Options.manualBinaryTree();
                    Tools.solvePrint();
                    option = Options.aux;
                    break;
                case 3:
                    Options.randomAvlTree();
                    Tools.solvePrint();
                    option = Options.aux;
                    break;
                case 4:
                    Options.manualAvlTree();
                    Tools.solvePrint();
                    option = Options.aux;
                    break;
                case 5:
                    //tratamiento de Excepcion: imprimir en orden arbol vacio
                    try {
                        Options.printInOrder();
                    } catch (PrintInOrderEx e) {
                        e.printStackTrace();
                        Options.flagOrder = true;
                        option = Options.aux;
                    }
                    break;
                case 6:
                    //tratamiento de Excepcion: dibujar arbol vacio
                    try {
                        Options.printDrawTree();
                    } catch (PrintDrawEx e) {
                        e.printStackTrace();
                        Options.flagDraw = true;
                        option = Options.aux;
                    }
                    break;
                default:
                    System.out.println("OPCION INCORRECTA");
                    break;
            }
        } while (option != 0);
    }
}