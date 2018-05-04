package game.main.black_jack;


import java.util.List;

public class Hand {
    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public void insertCard(Card card) {
        this.cards.add(card);
    }
}