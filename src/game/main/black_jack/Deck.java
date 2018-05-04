package game.main.black_jack;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class Deck {
	private Dealer dealer;
	private List<Card> cards;
	private List<Player> players;

	public static final int BLAST_FLAG = -1;

	private static final int MAX_PLAYER_NUMBER = 5;

	public Dealer getDealer() {
		return this.dealer;
	}

	public List<Card> getCards() {
		return this.cards;
	}

	public List<Player> getPlayers() {
		return this.players;
	}

	// constructor
	public Deck() {
	    dealer = new Dealer(this);
	    cards = new ArrayList<>();
	    createCards(cards);
	    shuffle(cards);
	    players = new ArrayList<>(5);
    }

    private void createCards(List<Card> cards) {
	    for (Suit suit : Suit.values()) {
	        for (CardValue cardValue : CardValue.values()) {
	            cards.add(new Card(suit, cardValue));
            }
        }
    }

    public void printCardsOnDeck() {
	    for (Card card : cards) {
            System.out.println(card.getSuit() + " " + card.getCardValue());
        }
    }

	/**
	 * Apply shuffle algorithm to perfectly
	 * shuffle the cards
	 */
	public void shuffle(List<Card> cards) {
        for (int i = cards.size(); i >= 1; i--) {
            int index = (int) (Math.random() * i);
            swap(cards, index, i - 1);
        }
	}

	private void swap(List<Card> cards, int a, int b) {
	    Card tmp = cards.get(a);
	    cards.set(a, cards.get(b));
	    cards.set(b, tmp);
    }

	public void addPlayer(Player player) throws MaxPlayerNumberException {
	    if (players.size() == MAX_PLAYER_NUMBER) {
	        throw new MaxPlayerNumberException("The deck is full, please change another deck to play.");
        }
		this.players.add(player);
	}

	/**
	 * Give first two cards to both Dealer and each Player
	 */
	public void dealInitialCard() {
		for (int i = 0; i < 2; i++) {
			this.dealer.insertCard(this.cards.remove(0));
		}

		for (Player player : players) {
			for (int i = 0; i < 2; i++) {
				player.insertCard(this.cards.remove(0));
			}
		}
	}

	/**
	 * give out the next card from the card
	 */
	public Card dealNextCard() {
		return cards.remove(0);
	}

	/**
	 * TODO: compare the values of cards of each player with Dealer update player and dealer's bets by the result
	 */
	public void compareResults() {
        for (Player player : this.players) {
            int playerCurrentGameBets = player.getCurrentGameBets();
            if (dealer.isLargerThan(player)) {
                player.updateBets(playerCurrentGameBets * (-1));
                dealer.updateBets(playerCurrentGameBets);
            } else { // if player wins, then get double bets from the dealer
                player.updateBets(2 * playerCurrentGameBets);
                dealer.updateBets(2 * playerCurrentGameBets * (-1));
            }
        }
	}


	/**
	 * calculate the value in a Hand
	 * focus on the change of ACE
	 * @param hand
	 * @return
	 */
	public int calculateHandValue(Hand hand) {
		int res = 0;
		int max = BLAST_FLAG;
		for (Card card : hand.getCards()) {
			if (card.getCardValue() != CardValue.ACE) {
				res += card.getCardValue().getValue();
			}
		}
		List<Card> aces =  findAllAces(hand);
		List<Integer> dedup = new ArrayList<>();
		if (aces.size() == 0) {
			return res <= 21 ? res : BLAST_FLAG;
		} else { // run dfs to find all possible value result
            List<Integer> allPossibleValues = new ArrayList<>();
            dfs(allPossibleValues, aces, res, 0, 0);
            for (Integer i : allPossibleValues) { // de-duplicate
                if (!dedup.contains(i)) {
                    dedup.add(i);
                }
            }
		}
		// TODO: RETURN MAX VALUE WHICH LESS THAN OR EQUAL 21 IF POSSIBLE
        for (Integer i : dedup) {
		    if (i > max && i <= 21) {
		        max = i;
            }
        }
        return max;
	}

	private void dfs(List<Integer> allPossibleValues,List<Card> aces, int res, int level, int lastLevelAddition) {
	    // base case
        if (level == aces.size()) {
            allPossibleValues.add(res);
            // res -= lastLevelAddition;
            return;
        }

        // add 1
        int one = aces.get(level).getCardValue().getValue1();
        res += one;
        dfs(allPossibleValues, aces, res, level + 1, one);

        res -= one;
        // add 11
        int eleven = aces.get(level).getCardValue().getValue2();
        res += eleven;
        dfs(allPossibleValues, aces, res, level + 1, eleven);
		res -= eleven;
    }

	private List<Card> findAllAces(Hand hand) {
		List<Card> res = new ArrayList<>();
		for (Card card : hand.getCards()) {
			if (card.getCardValue() == CardValue.ACE) {
				res.add(card);
			}
		}
		return res;
	}

	public void playGame() {
	    for (Player player : players) {
	        serveOnePlayer(player);
        }
        serveDealer(dealer);
        compareResults();
        printResults();
    }

    private void serveOnePlayer(Player player) {
        System.out.println("current player's hand cards are ");
        player.getHand().printHand();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the amount of bets for this game: ");
        int amount = scanner.nextInt();
        player.placeBets(amount);
        while (!player.isStopDealing()) {
            System.out.println("current player's hand cards are ");
            player.getHand().printHand();
            System.out.println("Do you want to deal one more card?");
            String msg = scanner.next();
            if (msg.equals("Yes")) {
                player.dealNextCard();
                int value = this.calculateHandValue(player.getHand());
                if (value == BLAST_FLAG) {
                    System.out.println("You have blasted!!!");
                    return;
                }
            } else if (msg.equals("No")) {
                player.stopDealing();
            } else {
                System.out.println("Please insert Yes or No.");
            }
        }
    }

    private void serveDealer(Dealer dealer) {
        Scanner scanner = new Scanner(System.in);
        while (!dealer.isStopDealing()) {
            System.out.println("current dealer's hand cards are ");
            dealer.getHand().printHand();
            System.out.println("Do you want to deal one more card?");
            if (this.calculateHandValue(dealer.getHand()) <= 17) {
                dealer.dealNextCard();
                continue;
            }
            // if dealer's hand > 17, he can choose whether or not to deal next card
            String msg = scanner.next();
            if (msg.equals("Yes")) {
                dealer.dealNextCard();
                int value = this.calculateHandValue(dealer.getHand());
                if (value == BLAST_FLAG) {
                    System.out.println("You have blasted!!!");
                    return;
                }
            } else if (msg.equals("No")) {
                dealer.stopDealing();
            } else {
                System.out.println("Please insert Yes or No.");
            }
        }
    }

    public void printResults() {
	    System.out.println("After one game, each player and dealer's bets are: ");
	    for (Player player : players) {
	        System.out.println(player.getTotalBets());
        }
        System.out.println("Dealer's bets are: " + dealer.getBets());
    }
}
