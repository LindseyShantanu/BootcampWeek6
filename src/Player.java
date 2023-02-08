import java.util.ArrayList;
import java.util.List;

public class Player {
	//Fields
	private List<Card> hand = new ArrayList<Card>();
	int score;
	String name;
	
	//Methods
	
	//constructor
	public Player(String name) {
		this.score = 0;
		this.name = name;
	}
	
	//default constructor JIC
	public Player() {}
	
	//prints playerName has: lists cards in hand 
	public void describe() {
		System.out.println(name + " has:");
		for (Card card: hand) 
			card.describe();
	}
	
	public Card flip() {
		return hand.remove(0);
	}
	
	public void draw(Deck d){
		Card c = d.draw();
		hand.add(c);
	}
	
	public void incrementScore(){
		score+=1;
	}
}
