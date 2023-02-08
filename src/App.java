import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class App {

	public static void main(String[] args) {
		//create a deck and 2 players
		Deck deck1 = new Deck();
		Player p1 = new Player("Player 1");
		Player p2 = new Player("Player 2");
		
		//shuffle the deck
		deck1.shuffle();
		System.out.println("First, we must shuffle.");
		//Try to add shuffle sound clip

		
		playMusic("shuffling-cards-1.mp3");
		
		
		/* Use to print the deck:
		for (Card card: deck1.getCards()) {
			card.describe();
		}*/
		
		//deal the deck
		System.out.println("Let's deal the deck.");
		for(int i=0; i<52; i++) {
			if (i%2==0)
				p1.draw(deck1);
			else
				p2.draw(deck1);
		}
		
		//play War
		for(int i=0; i<26; i++) {
			int x = p1.flip().getValue();
			int y = p2.flip().getValue();
			
		}
		

	}
	
	public static void playMusic(String filepath) {
	    InputStream sound;
	    try {
	        sound = new FileInputStream(new File(filepath));
	        BufferedInputStream bis = new BufferedInputStream(sound);
	        AudioInputStream ais = AudioSystem.getAudioInputStream(bis);
	        Clip clip = AudioSystem.getClip();
	        clip.open(ais);
	        clip.start();
	    } catch(Exception e) {
	        JOptionPane.showMessageDialog(null,"Error");
	    }
	}
		
}

