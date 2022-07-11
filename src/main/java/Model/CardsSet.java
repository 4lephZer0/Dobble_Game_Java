package Model;

// Interfaz del mazo de cartas
public interface CardsSet {

    public boolean isDobble(Dobble cards);
    public int numCards(Dobble cards);
    public Card nthCard(Dobble cards, int indice);
    public int findTotalCards(Card card);
    public int requiredElements(Card card);
    public Dobble missingCards(Dobble cards);
}
