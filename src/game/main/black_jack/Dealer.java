package game.main.black_jack;

public class Dealer {
    private Hand hand;
    private int bets;
    private Deck deck;

    public Hand getHand() {
        return hand;
    }

    public int getBets() {
        return bets;
    }

    public Deck getDeck() {
        return deck;
    }

    public void insertCard(Card card) {
        this.hand.insertCard(card);
    }

    /**
     * get the next card from deck's cards
     */
    public void dealNextCard() {
        Card card = this.deck.dealNextCard();
        insertCard(card);
    }

    public boolean isLargerThan(Player player) {
        int dealerValue = deck.calculateHandValue(this.getHand());
        int playerValue = deck.calculateHandValue(player.getHand());

        if (dealerValue >= playerValue) {
            return true;
        } else {
            return false;
        }
    }

    public void updateBets(int amount) {
        this.bets += amount;
    }

}