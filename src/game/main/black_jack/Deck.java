package game.main.black_jack;


import java.util.ArrayList;
import java.util.List;

public class Deck {
	private Dealer dealer;
	private List<Card> cards;
	private List<Player> players;

	public Dealer getDealer() {
		return this.dealer;
	}

	public List<Card> getCards() {
		return this.cards;
	}

	public List<Player> getPlayers() {
		return this.players;
	}

	/**
	 * Apply shuffle algorithm to perfectly
	 * shuffle the cards
	 */
	public void shuffle() {

	}

	public void addPlayer(Player player) {
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
		int max = Integer.MIN_VALUE;
		for (Card card : hand.getCards()) {
			if (card.getCardValue() != CardValue.ACE) {
				res += card.getCardValue().getValue();
			}
		}
		List<Card> aces =  findAllAces(hand);
		List<Integer> dedup = new ArrayList<>();
		if (aces.size() == 0) {
			return res;
		} else { // run dfs to find all possible value result
            List<Integer> allPossibleValues = new ArrayList<>();
            dfs(allPossibleValues, aces, res, 0, 0);
            for (Integer i : allPossibleValues) {
                if (!dedup.contains(i)) {
                    dedup.add(i);
                }
            }
		}
		// TODO: RETURN MAX VALUE WHICH LESS THAN OR EQUAL 21 IF POSSIBLE
        for (Integer i : dedup) {
		    if (res + i > max && res + i <= 21) {
		        max = res + i;
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

        res -= lastLevelAddition;
        // add 11
        int eleven = aces.get(level).getCardValue().getValue2();
        res += eleven;
        dfs(allPossibleValues, aces, res, level + 1, eleven);
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
}
