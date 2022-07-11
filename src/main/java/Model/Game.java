package Model;

import java.util.*;

// Interfaz del juego.
public interface Game {

    public List<Card> stackMode(Dobble cards);
    public DobbleGame register(DobbleGame game, Player nombreUsuario);
    public Player whoseTurnIsIt(DobbleGame game);
    public DobbleGame play(DobbleGame game, String accion, String elemento);
    public String status(DobbleGame game);
    public Integer score(DobbleGame game, String Usuario);

}
