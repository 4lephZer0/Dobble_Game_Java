package Dobble;

import java.util.List;
import java.util.Objects;

/*
* Clase Card, esta representa una carta del juego Dobble
* pero con su respectiva propiedad de que contiene elementos sin repetirlos
*
* Se relaciona con Dobble como un atributo de este.
*/
public class Card {

    private int largo; //Atributo que representa el largo de la lista de elementos
    private List<String> elementos; //Atributo que representa la lista de elementos

    // ####### METODOS CONSTRUCTORES #########
    /*
     * Metodo Constructor de Card
     * Se encarga de instanciar el largo y los elementos de Card
     */
    public Card(int largo, List elementos){
        this.largo = largo;
        this.elementos = elementos;
    }

    // ####### METODOS SELECTORES #########

    //Metodo Selector para obtener el Largo de la carta.
    public int getLargo() {
        return largo;
    }


    //Metodo Selector para obtener los elementos de la carta
    public List getElementos() {
        return elementos;
    }

    // ####### METODOS MODIFICADORES #########

    //Metodo modificador que se encarga de asignarle un nuevo valor al largo
    public void setLargo(int largo) {
        this.largo = largo;
    }


    //Metodo modificador que se encarga de asignarle una nueva lista como la lista de elementos
    public void setElementos(List<String> elementos) {
        this.elementos = elementos;
    }

    // ####### OTROS METODOS #########

    // Metodo que se encarga de comparar un objeto con el que llama al metodo.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return getLargo() == card.getLargo() && Objects.equals(getElementos(), card.getElementos());
    }

    //Metodo que se encarga de generar un string con todos los atributos de Card
    @Override
    public String toString() {
        return "Card{" +
                "largo=" + largo +
                ", elementos=" + elementos +
                '}';
    }
}