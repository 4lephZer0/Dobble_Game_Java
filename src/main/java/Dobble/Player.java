package Dobble;

import java.util.Objects;

// Clase que se encarga de representar a un jugador
public class Player {

    String jugador; //Atributo que representa a un jugador.


    // ####### METODOS CONSTRUCTORES #########


    // Metodo que se encarga de instanciar a un jugador.
    public Player(String jugador) {
        this.jugador = jugador;
    }


    // ####### METODOS SELECTORES #########


    // Metodo que se encarga de obtener el jugador de la clase
    public String getJugador() {
        return jugador;
    }


    // ####### METODOS MODIFICADORES #########


    // Metodo que se encarga de setear el jugador de la clase
    public void setJugador(String jugador) {
        this.jugador = jugador;
    }


    // ####### OTROS METODOS #########


    // Metodo que se encarga de comparar un objeto con el que llama al metodo.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(getJugador(), player.getJugador());
    }

    // Metodo que se encarga de realizar una representacion en string de los atributos de la clase.
    @Override
    public String toString() {
        return "Player{" +
                "jugador='" + jugador + '\'' +
                '}';
    }
}
