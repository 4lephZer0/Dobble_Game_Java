package Dobble;


import java.util.*;

// Clase Dobble, esta se encarga de representar un juego de Dobble.
public class Dobble implements CardsSet {

    private int maxC;   //Atributo que representa el maximo de cartas
    private int numE;   //Atributo que representa el numero total de elementos por carta
    private List<String> elements; //Atributo que representa la lista de elementos
    private List<Card> cards; //Atributo que representa el mazo de cartas


    // ####### METODOS CONSTRUCTORES #########


    // Este metodo se encarga de construir un mazo e instanciar todos los atributos de él
    public Dobble(int maxC, int numE, List<String> elements) {
        this.maxC = maxC;
        this.numE = numE;
        this.elements = elements;

        int n = numE - 1;

        List<Card> mazo = new ArrayList<Card>();
        List<String> carta = new ArrayList<String>();
        for (int i = 1; i <= n + 1; i++) {
            carta.add(elements.get(i - 1));
        }

        List<String> cartaAux = new ArrayList<String>(carta);
        Card carta1 = new Card(cartaAux.size(), cartaAux);
        mazo.add(carta1);

        for (int j = 1; j <= n; j++) {
            carta.clear();
            carta.add(elements.get(0));

            for (int k = 1; k <= n; k++) {
                carta.add(elements.get((n * j + (k + 1)) - 1));
            }
            cartaAux = new ArrayList<String>(carta);
            carta1 = new Card(cartaAux.size(), cartaAux);
            mazo.add(carta1);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                carta.clear();
                carta.add(elements.get(i));

                for (int k = 1; k <= n; k++) {
                    carta.add(elements.get((n + 2 + n * (k - 1) + (((i - 1) * (k - 1) + j - 1) % n)) - 1));
                }
                cartaAux = new ArrayList<String>(carta);
                carta1 = new Card(cartaAux.size(), cartaAux);
                mazo.add(carta1);
            }
        }
        Collections.shuffle(mazo);

        List<Card> mazoNuevo = null;
        if ((maxC < mazo.size()) && (maxC > 0)) {

            mazoNuevo = mazo.subList(0, (maxC - 1));
        } else if ((maxC >= mazo.size()) || (maxC < 0)){

            mazoNuevo = mazo;

        }


        this.cards = mazoNuevo;

    }


    // ####### METODOS DE PERTENENCIA #########


    //Este metodo se encarga verificar si un mazo de Dobble, es realmente un mazo.
    public boolean isDobble(Dobble cards) {

        List<Card> mazo = cards.getCards();

        for (int i = 0; i<mazo.size(); i++){

            Integer aux = 0;
            for (int j = 0; j<(mazo.get(i).getLargo()); j++){

                if ((j+1) < mazo.get(i).getLargo()){
                    if (mazo.get(i).getElementos().subList(j+1, mazo.get(i).getLargo()-1).contains(mazo.get(i).getElementos().get(j))){

                        return false;
                    }
                }

                if ((i+1) < mazo.size()){
                    if(mazo.get(i+1).getElementos().contains(mazo.get(i).getElementos().get(j))){

                        aux++;
                        if (aux.equals(2)){

                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }


    // ####### METODOS SELECTORES #########


    // Metodo que se encarga de obtener el maxC.
    public int getMaxC() {
        return maxC;
    }

    // Metodo que se encarga de obtener el numE.
    public int getNumE() {
        return numE;
    }

    // Metodo que se encarga de obtener la lista de elementos utilizados.
    public List<String> getElements() {
        return elements;
    }

    // Metodo que se encarga de obtener la lista de cartas (mazo).
    public List<Card> getCards() {
        return cards;
    }

    // Metodo que se encarga de obtener el total de cartas.
    public int numCards(Dobble cards){

        return cards.getCards().size();
    }

    // Metodo que se encarga de obtener una carta segun su indice.
    public Card nthCard(Dobble cards, int indice){

        return cards.getCards().get(indice);
    }

    // Metodo que se encarga de obtener el total de cartas dada una sola carta.
    public int findTotalCards(Card card){
        int n = card.getLargo() - 1;
        return ((n*n) + n + 1);
    }

    // Metodo que se encarga de obtener el total de elementos dada una sola carta.
    public int requiredElements(Card card){
        int n = card.getLargo() - 1;
        return ((n*n) + n + 1);
    }


    // ####### METODOS MODIFICADORES #########


    // Metodo que se encarga de obtener las cartas faltantes de un mazo.
    public Dobble missingCards(Dobble cards){

        Integer total = findTotalCards(cards.getCards().get(0));
        if (total.equals(cards.getCards().size())){
            return cards;
        }
        else{
            Dobble mazo = new Dobble(findTotalCards(cards.getCards().get(0)), (cards.getCards().get(0).getLargo()-1), cards.getElements());

            for (int i = 0; i<cards.getCards().size(); i++){

                for (int j = 0; j<mazo.getCards().size(); j++){

                    if (cards.getCards().get(i).equals(mazo.getCards().get(j))){

                        mazo.getCards().remove(j);

                    }
                }
            }
            return mazo;
        }
    }

    // Metodo que se encarga de setear el maxC
    public void setMaxC(int maxC) {
        this.maxC = maxC;
    }

    // Metodo que se encarga de setear el numE
    public void setNumE(int numE) {
        this.numE = numE;
    }

    // Metodo que se encarga de setear la lista de elementos
    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    // Metodo que se encarga de setear la lista de cartas
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    // ####### OTROS METODOS #########

    // Metodo que se encarga comparar 2 objetos.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dobble)) return false;
        Dobble dobble = (Dobble) o;
        return getMaxC() == dobble.getMaxC() && getNumE() == dobble.getNumE() && Objects.equals(getElements(), dobble.getElements()) && Objects.equals(getCards(), dobble.getCards());
    }

    // Metodo que se encarga de representar el mazo y sus atributos como String.
    @Override
    public String toString() {
        return "Cards{" +
                "maxC=" + maxC +
                ", numE=" + numE +
                ", elements=" + elements +
                ", cards=" + cards +
                '}';
    }
}
