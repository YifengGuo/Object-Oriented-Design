package game.main.black_jack;

public class Dealer {
    private static final int INITIAL_BETS = 10000;
    private Hand hand;
    private int bets;
    private Deck deck;
    private boolean stopDealing;

    public boolean isStopDealing() {
        return stopDealing;
    }

    public void stopDealing() {
        stopDealing = true;
    }


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

    // constructor
    public Dealer(Deck deck) {
        bets = INITIAL_BETS;
        hand = new Hand();
        this.deck = deck;
        stopDealing = false;
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

        if (dealerValue == playerValue) {
            return true;
        }

        if (playerValue == deck.BLAST_FLAG) {
            return true;
        }

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