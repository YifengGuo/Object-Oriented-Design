package game.main.black_jack;

/**
 * Created by guoyifeng on 5/4/18.
 */

/**
 * Test program for BlackJack
 */
public class Test {
    public static void main(String[] args) throws MaxPlayerNumberException {
        Deck deck = new Deck();
        Player player1 = new Player(deck);
        Player player2 = new Player(deck);

        player1.joinGame(deck);
        player2.joinGame(deck);

        // deck.printCardsOnDeck(); // test initial cards and shuffle
        deck.dealInitialCard();
//        deck.getDealer().getHand().printHand();
//        deck.getPlayers().get(0).getHand().printHand();

        deck.playGame();
    }

}
