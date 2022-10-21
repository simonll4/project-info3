package utils;

import java.util.Scanner;

public class Menu {

    public static void startMenu() {
        Scanner in = new Scanner(System.in);
        int option;

        do {
            System.out.println("************************\nElige opción:\n1.- Crear arbol aleatorio" +
                    "\n2.- Crear arbol manual\n" +
                    "3.- Crear arbol AVL aleatorio\n" +
                    "4.- Crear arbol AVL aleatorio\n" +
                    "5.- Mostrar arbol ordenado\n" +
                    "6.- Mostrar dibujo de arbol\n" +
                    "0.- Salir\n************************");
            option = in.nextInt();

            switch (option) {
                case 0:
                    break;
                case 1:
                    Options.randomBinaryTree();
                    break;
                case 2:
                    Options.manualBinaryTree();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    Options.showTree();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("OPCION INCORRECTA");
                    break;

            }

        } while (option != 0);


    }

}

