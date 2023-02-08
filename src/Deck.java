import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards = new ArrayList<Card>();
	
	public Deck() {
		//loops run 2 - 14 to set up the deck 2-Ace
		for(int i=2; i<=14;i++) {
			Card c = new Card(i, "Spades");
			getCards().add(c);
		}
		for(int i=2; i<=14;i++) {
			Card c = new Card(i, "Clovers");
			getCards().add(c);
		}
		for(int i=2; i<=14;i++) {
			Card c = new Card(i, "Hearts");
			getCards().add(c);
		}
		for(int i=2; i<=14;i++) {
			Card c = new Card(i, "Diamonds");
			getCards().add(c);
		}
	}
	
	public void shuffle() {
		Collections.shuffle(getCards());
	}
	
	public Card draw() {
		return getCards().remove(0);
	}

	//return list of cards
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	

}
