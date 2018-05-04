package game.main.black_jack;


import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public void insertCard(Card card) {
        this.cards.add(card);
    }

    // constructor
    public Hand() {
        cards = new ArrayList<>();
    }

    /**
     * show the cards in current player or deal's hand
     */
    public void printHand() {
        if (cards.size() == 0) {
            System.out.println("Empty Hand.");
        } else {
            for (Card card : cards) {
                System.out.println(card.getSuit() + " " + card.getCardValue());
            }
        }
    }
}