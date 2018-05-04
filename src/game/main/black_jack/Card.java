package game.main.black_jack;
/**
 * Created by guoyifeng on 5/3/18.
 */

/**
 * entity class Card
 */
public class Card {
    private Suit suit;
    private CardValue cardValue;

    public Suit getSuit() {
        return suit;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public Card(Suit suit, CardValue cardValue) {
        this.suit = suit;
        this.cardValue = cardValue;
    }
}