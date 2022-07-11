

import Model.Dobble;
import Model.DobbleGame;
import View.*;


import java.util.List;


// CLASE MAIN, aqui ocurre toda la magia del menu por consola.
public class Main {
    public static void main(String[] args){
        int maxC = 0;
        int numE = 0;
        int caso = 1;
        int cantJug = 0;
        List<String> elements = null;
        Dobble mazo = null;
        DobbleGame juego = null;


        VentanaPrincipal app = new VentanaPrincipal(maxC, numE, elements, caso, cantJug, mazo, juego);
        app.setVisible(true);
    }
}