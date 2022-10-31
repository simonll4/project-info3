package utils;

import exceptions.PrintDrawEx;
import exceptions.PrintInOrderEx;

public class Tools {

    public static void solvePrint() {
        try {
            if (Options.flagOrder) Options.printInOrder();
            if (Options.flagDraw) Options.printDrawTree();
        }
        //tratamiento de Excepcion: imprimir en orden arbol vacio
        catch (PrintInOrderEx e) {
            e.printStackTrace();
            Options.flagOrder = true;
        }
        //tratamiento de Excepcion: dibujar arbol vacio
        catch (PrintDrawEx e) {
            e.printStackTrace();
            Options.flagDraw = true;
        }
    }
}
