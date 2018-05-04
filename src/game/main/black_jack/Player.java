package game.main.black_jack;

public class Player {
	private static final int INITIAL_BETS = 1000;


	private Hand hand;  // record the cards in hand
	private Deck deck;  // current deck the player is playing on
	private int totalBets;
	private int currentGameBets;
	private boolean stopDealing; // record if player still wants more card


	public Hand getHand() {
		return hand;
	}

	public Deck getDeck() {
		return deck;
	}

	public int getTotalBets() {
		return totalBets;
	}

	//constructor
	public Player(Deck deck) {
		totalBets = INITIAL_BETS;
		hand = new Hand();
		this.deck = deck;
		currentGameBets = 0;
		stopDealing = false;
	}

	/**
	 * used for comparing result and update current game bets
	 * @return
	 */
	public int getCurrentGameBets() {
		return currentGameBets;
	}

	public boolean isStopDealing() {
		return stopDealing;
	}

	public void insertCard(Card card) {
		this.hand.insertCard(card);
	}

	public void dealNextCard() {
		if (stopDealing == true) {
			System.out.println("You have stopped dealing the cards!");
			return;
		}
		Card card = this.deck.dealNextCard();
		insertCard(card);
	}

	public void joinGame(Deck deck) throws MaxPlayerNumberException {
		this.deck.addPlayer(this);
	}

	public void updateBets(int amount) {
		this.totalBets += amount;
	}

	public void stopDealing() {
		this.stopDealing = true;
	}

	public void placeBets(int amount) {
		this.currentGameBets += amount;
	}

}
