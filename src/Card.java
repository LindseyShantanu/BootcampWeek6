
public class Card {
	//Fields
	private int value;
	private String val;
	private String name;
	
	//not sure if I'll use these yet...
	private final static int A = 14;
	private final static int K = 13;
	private final static int Q = 12;
	private final static int J = 11;
	
	//Methods
	public Card(int value, String name) {
		this.value=value;
		this.name=name;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void describe() {
		switch(value) {
			case(2):
				val = "Two";
				break;
			case(3):
				val = "Three";
				break;
			case(4):
				val = "Four";
				break;
			case(5):
				val = "Five";
				break;
			case(6):
				val = "Six";
				break;
			case(7):
				val = "Seven";
				break;
			case(8):
				val = "Eight";
				break;
			case(9):
				val = "Nine";
				break;
			case(10):
				val = "Ten";
				break;
			case(11):
				val = "Jack";
				break;
			case(12):
				val = "Queen";
				break;
			case(13):
				val = "King";
				break;
			default:
				val = "Ace";
		}
		System.out.println(val + " of " + name);
	}
}
