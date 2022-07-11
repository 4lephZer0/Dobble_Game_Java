package Model;

import java.util.*;

// Clase DobbleGame que representa al juego completo de Dobble
public class DobbleGame implements Game {

    private List<Card> mesa; // Atributo que representar la mesa donde estan volteadas las cartas
    private int numPlayers; // Atributo que representa la cantidad de jugadores registrados
    private Dobble dobble; // Atributo que representa el mazo
    private String mode; // Atributo que representa el modo de juego a jugar
    private List<Player> jugadores; // Atributo que representa la lista de jugadores registrados
    private List<List<Card>> cartasJugadores; // Atributo que representa la lista de cartas de los jugadores.
    private int turno; // Atributo que representa el turno de quien juega actualmente
    private String estado; // Atributo que representa el estado del juego, puede ser iniciado, finalizado, Aun no iniciado


    // ####### METODOS CONSTRUCTORES #########


    // Constructor del juego Dobble, se encarga de instanciar los atributos de la clase.
    public DobbleGame(int numPlayers, Dobble cards, String mode) {

        this.mesa = new ArrayList<Card>();
        this.numPlayers = numPlayers;
        this.dobble = cards;
        this.mode = mode;
        this.jugadores = new ArrayList<Player>();
        this.cartasJugadores = new ArrayList<List<Card>>();
        this.turno = 0;
        this.estado = "Aun no iniciado.";
    }


    // ####### METODOS DE PERTENENCIA #########


    // Metodo que se encarga mostrar de quien es el turno actual
    public Player whoseTurnIsIt(DobbleGame game){

        return game.getJugadores().get(game.getTurno()-1);
    }


    // ####### METODOS SELECTORES #########


    // Metodo que muestra el estado actual de juego
    public String status(DobbleGame game){

        return game.getEstado();
    }

    // Metodo que muestra el puntaje de x jugador
    public Integer score(DobbleGame game, String Usuario){

        int posicion = game.getJugadores().indexOf(Usuario);
        return game.getCartasJugadores().get(posicion).size();
    }

    // Metodo que obtiene la mesa del juego
    public List<Card> getMesa() {
        return mesa;
    }

    // Metodo que obtiene el numero de jugadores registrados
    public int getNumPlayers() {
        return numPlayers;
    }

    // Metodo que obtiene el mazo de cartas del juego
    public Dobble getDobble() {
        return dobble;
    }

    // Metodo que obtiene el modo de juego
    public String getMode() {
        return mode;
    }

    // Metodo que obtiene la lista de jugadores
    public List<Player> getJugadores() {
        return jugadores;
    }

    // Metodo que obtiene la lista de cartas de cada jugador
    public List<List<Card>> getCartasJugadores() {
        return cartasJugadores;
    }

    // Metodo que obtiene el turno actual de juego
    public int getTurno() {
        return turno;
    }

    // Metodo que obtiene el estado actual del juego
    public String getEstado() {
        return estado;
    }

    // Metodo para obtener al ganador
    public String getGanador(DobbleGame game){

        Player ganador = game.getJugadores().get(0);
        Integer puntaje = game.getCartasJugadores().get(0).size();
        int puntaje2 = 0;
        for (int i = 1; i < game.getNumPlayers(); i++){

            if (game.getCartasJugadores().get(i).size() > puntaje){
                puntaje = game.getCartasJugadores().get(i).size();
                ganador = game.getJugadores().get(i);

            }else if(puntaje.equals(game.getCartasJugadores().get(i).size())){

                puntaje2 = game.getCartasJugadores().get(i).size();

            }

        }

        if (puntaje.equals(puntaje2)){

            return "Empatados";
        }
        else{

            return ganador.getJugador();
        }
    }

    // ####### METODOS MODIFICADORES #########


    // Metodo que se encarga de extraer 2 cartas del mazo y ponerlas en la mesa
    public List<Card> stackMode(Dobble cards){

        List<Card> cartasVolteadas = new ArrayList<Card>();

        if (cards.getCards().size() >= 2){

            cartasVolteadas.add(cards.getCards().get(0));
            cartasVolteadas.add(cards.getCards().get(1));
        }

        if (cards.getCards().size() < 2){

            System.out.println("NO QUEDAN MAS PARES DE CARTAS PARA JUGAR AL DOBBLE, POR FAVOR FINALIZAR EL JUEGO.");

        }

        return cartasVolteadas;
    }

    // Metodo que se encarga de registrar a un jugador dentro del juego
    public DobbleGame register(DobbleGame game, Player nombreUsuario){

        if (game.getJugadores().size() < game.getNumPlayers()){

            List<Player> jugAux = new ArrayList<Player>(game.getJugadores());
            List<List<Card>> cartasJugAux = new ArrayList<List<Card>>(game.getCartasJugadores());

            jugAux.add(nombreUsuario);
            game.setJugadores(jugAux);

            List<Card> cartasJug = new ArrayList<Card>();
            cartasJugAux.add(cartasJug);
            game.setCartasJugadores(cartasJugAux);

            game.setTurno((game.getTurno() + 1));

        }
        return game;

    }

    // Metodo que se encarga de realizar una accion del juego dada la eleccion
    public DobbleGame play(DobbleGame game, String accion, String elemento){

        if (accion.equals("1")){

            game.setMesa(stackMode(game.getDobble()));
            Dobble dobbleAux = game.getDobble();
            List<Card> mazoAux = game.getDobble().getCards().subList(2, game.getDobble().getCards().size());
            dobbleAux.setCards(mazoAux);
            game.setDobble(dobbleAux);
            game.setEstado("Iniciado");


        }else if (accion.equals("2")){

            if (game.getMesa().get(0).getElementos().contains(elemento) && game.getMesa().get(1).getElementos().contains(elemento)){

                List<List<Card>> cartasJug = new ArrayList<List<Card>>(game.getCartasJugadores());

                cartasJug.get(game.getTurno()-1).add(game.getMesa().get(0));
                cartasJug.get(game.getTurno()-1).add(game.getMesa().get(1));
                game.setCartasJugadores(cartasJug);

                Integer a = game.getTurno();
                if (a.equals(game.getNumPlayers())){

                    game.setTurno(1);
                }

                else{
                    game.setTurno(game.getTurno()+1);
                }
            }

            else{

                Integer a = game.getTurno();
                if (a.equals(game.getNumPlayers())){

                    game.setTurno(1);
                }

                else{
                    game.setTurno(game.getTurno()+1);
                }

                Dobble dobbleAux = game.getDobble();
                List<Card> mazoAux = game.getDobble().getCards();
                mazoAux.add(game.getMesa().get(1));
                mazoAux.add(game.getMesa().get(0));
                dobbleAux.setCards(mazoAux);
                game.setDobble(dobbleAux);

            }

        }else if (accion.equals("3")){


            Integer a = game.getTurno();
            if (a.equals(game.getNumPlayers())){

                game.setTurno(1);
            }

            else{
                game.setTurno(game.getTurno()+1);
            }

            Dobble dobbleAux = game.getDobble();
            List<Card> mazoAux = game.getDobble().getCards();
            mazoAux.add(game.getMesa().get(1));
            mazoAux.add(game.getMesa().get(0));
            dobbleAux.setCards(mazoAux);
            game.setDobble(dobbleAux);


        }else if (accion.equals("4")){

            //finish

            Player ganador = game.getJugadores().get(0);
            Integer puntaje = game.getCartasJugadores().get(0).size();
            Integer puntaje2 = 0;
            Player ganador2;
            for (int i = 0; i < game.getNumPlayers(); i++){

                if (game.getCartasJugadores().get(i).size() > puntaje){
                    puntaje = game.getCartasJugadores().get(i).size();
                    ganador = game.getJugadores().get(i);

                }else if(puntaje.equals(game.getCartasJugadores().get(i).size())){

                    puntaje2 = game.getCartasJugadores().get(i).size();
                    ganador2 = game.getJugadores().get(i);

                }

            }

            if (puntaje.equals(puntaje2)){

                System.out.println("Se declara un empate en el juego.");
            }
            else{
                System.out.println("El ganador del juego es el jugador: " + ganador.getJugador());
            }
            game.setEstado("Terminado");

        }

        return game;
    }

    // Metodo que se encarga de setear la mesa
    public void setMesa(List<Card> mesa) {
        this.mesa = mesa;
    }

    // Metodo que se encarga de setear el mazo de juego
    public void setDobble(Dobble dobble) {
        this.dobble = dobble;
    }

    // Metodo que se encarga de setear la lista de jugadores
    public void setJugadores(List<Player> jugadores) {
        this.jugadores = jugadores;
    }

    // Metodo que se encarga de setear la lista de cartas de cada jugador
    public void setCartasJugadores(List<List<Card>> cartasJugadores) {
        this.cartasJugadores = cartasJugadores;
    }

    // Metodo que se encarga de setear el turno actual del juego
    public void setTurno(int turno) {
        this.turno = turno;
    }

    // Metodo que se encarga de setear el estado actual del juego
    public void setEstado(String estado) {
        this.estado = estado;
    }


    // ####### OTROS METODOS #########


    // Metodo que se encarga comparar un objeto con el que llama al metodo
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DobbleGame)) return false;
        DobbleGame that = (DobbleGame) o;
        return getNumPlayers() == that.getNumPlayers() && getTurno() == that.getTurno() && Objects.equals(getMesa(), that.getMesa()) && Objects.equals(getDobble(), that.getDobble()) && Objects.equals(getMode(), that.getMode()) && Objects.equals(getJugadores(), that.getJugadores()) && Objects.equals(getCartasJugadores(), that.getCartasJugadores());
    }

    // Metodo que se encarga de realizar una representacion en string del juego
    @Override
    public String toString() {
        return "DobbleGame:" +
                "\nmesa=" + mesa +
                "\nnumPlayers=" + numPlayers +
                "\ndobble=" + dobble +
                "\nmode=" + mode +
                "\njugadores=" + jugadores +
                "\ncartasJugadores=" + cartasJugadores +
                "\nturno=" + turno +
                "\nestado=" + estado;
    }
}
