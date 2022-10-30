package utils;

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
                System.out.println("************************\nElige opción:\n1.- Crear arbol aleatorio" +
                        "\n2.- Crear arbol manual\n" +
                        "3.- Crear arbol AVL aleatorio\n" +
                        "4.- Crear arbol AVL manual\n" +
                        "5.- Mostrar arbol ordenado\n" +
                        "6.- Mostrar dibujo de arbol\n" +
                        "0.- Salir\n************************");
                option = in.nextInt();
            } else {
                System.out.println("--------------------------------------------------------------------------------\n" +
                        "WARNING: EL PROGRAMA NO PUEDE CONTINUAR, DEBES CREAR EL ARBOL QUE DESEA IMPRIMIR\n" +
                        "--------------------------------------------------------------------------------");
            }

            switch (option) {
                case 0:
                    break;
                case 1:
                    Options.randomBinaryTree();
                    //tratamiento de Excepcion: imprimir en orden arbol vacio
                    try {
                        if (Options.flagOrder) Options.printInOrder();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Options.flagOrder = true;
                        option = Options.aux;
                    }
                    //tratamiento de Excepcion: dibujar arbol vacio
                    try {
                        if (Options.flagDraw) Options.printDrawTree();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Options.flagDraw = true;
                        option = Options.aux;
                    }
                    break;
                case 2:
                    Options.manualBinaryTree();
                    //tratamiento de Excepcion: imprimir en orden arbol vacio
                    try {
                        if (Options.flagOrder) Options.printInOrder();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Options.flagOrder = true;
                        option = Options.aux;
                    }
                    //tratamiento de Excepcion: dibujar arbol vacio
                    try {
                        if (Options.flagDraw) Options.printDrawTree();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Options.flagDraw = true;
                        option = Options.aux;
                    }
                    break;
                case 3:
                    Options.randomAvlTree();
                    //tratamiento de Excepcion: imprimir en orden arbol vacio
                    try {
                        if (Options.flagOrder) Options.printInOrder();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Options.flagOrder = true;
                        option = Options.aux;
                    }
                    //tratamiento de Excepcion: dibujar arbol vacio
                    try {
                        if (Options.flagDraw) Options.printDrawTree();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Options.flagDraw = true;
                        option = Options.aux;
                    }
                    break;
                case 4:
                    Options.manualAvlTree();
                    //tratamiento de Excepcion: imprimir en orden arbol vacio
                    try {
                        if (Options.flagOrder) Options.printInOrder();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Options.flagOrder = true;
                        option = Options.aux;
                    }
                    //tratamiento de Excepcion: dibujar arbol vacio
                    try {
                        if (Options.flagDraw) Options.printDrawTree();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Options.flagDraw = true;
                        option = Options.aux;
                    }
                    break;
                case 5:
                    //tratamiento de Excepcion: imprimir en orden arbol vacio
                    try {
                        Options.printInOrder();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Options.flagOrder = true;
                        option = Options.aux;
                    }
                    break;
                case 6:
                    //tratamiento de Excepcion: dibujar arbol vacio
                    try {
                        Options.printDrawTree();
                    } catch (Exception e) {
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

