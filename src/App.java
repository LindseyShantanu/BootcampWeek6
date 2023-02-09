import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

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

			//play a shuffle sound and wait
		playMusic("shuffling-cards-1.wav");
		oneSec();
		
		
		//deal the deck
		System.out.println("Let's deal the deck.");
		playMusic("cards03.wav");
		oneSec();
		for(int i=0; i<52; i++) {
			if (i%2==0)
				p1.draw(deck1);
			else
				p2.draw(deck1);
		}
		
		//play War
		for(int i=0; i<26; i++) {
			//let's make it a little nicer to look at
			//This will break up each round
			for(int j=0; j<50; j++) {
				System.out.print("*");
			}
			System.out.println();
			for(int j=0; j<50; j++) {
				System.out.print("-");
			}
			System.out.println();
			for(int j=0; j<50; j++) {
				System.out.print("*");
			}
			System.out.println();
			
			//Player 1 turn
			oneSec();
			playMusic("page-flip-01a.wav");
			Card c = p1.flip();
			int x = c.getValue();
			System.out.print(p1.name + " plays "); 
				c.describe();
			
			//Player 2 turn
			oneSec();
			playMusic("page-flip-02.wav");
			Card c2 = p2.flip();
			int y = c2.getValue();
			System.out.print(p2.name + " plays "); 
				c2.describe();
			
			//Compare scores and give points
			oneSec();
			if(x>y) {
				p1.incrementScore();
				if(x==y+1 || x==14)
					playMusic("yes.wav");
				System.out.println(p1.name + " gets a point and has " + p1.score+" points.");
			}
			else if (y>x){
				p2.incrementScore();
				if(y==x+1 || y==14)
					playMusic("haha.wav");
				System.out.println(p2.name + " gets a point and has " + p2.score+" points.");

			}
			else {
				System.out.println("Tie - no points");

			}
			oneSec();
		}
		
		//compare final score
			//Adding in the fancy break lines
			for(int j=0; j<50; j++) {
				System.out.print("*");
			}
			System.out.println();
			for(int j=0; j<50; j++) {
				System.out.print("-");
			}
			System.out.println();
			for(int j=0; j<50; j++) {
				System.out.print("*");
			}
			System.out.println();
		if (p1.score>p2.score) {
			System.out.println("\033[1mWINNER! WINNER!\033[0m");
			System.out.println("Congratulations "+p1.name+"! You win with a score of "
					+ p1.score+ " to " + p2.score + ".");
			playMusic("cheerin.wav");
		} else if (p2.score>p1.score) {
			System.out.println("\033[1mWINNER! WINNER!\033[0m");
			System.out.println("Congratulations "+p2.name+"! You win with a score of "
					+ p2.score+ " to " + p1.score + ".");
			playMusic("cheerin.wav");
		} else {
			System.out.println("\033[1mDraw!\033[0m");
			System.out.println("It's a tie with a score of "
					+ p1.score+ " to " + p2.score + ".");
			playMusic("womp-womp.wav");
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
	        while(clip.getMicrosecondLength()!= clip.getMicrosecondPosition());
	    } catch(Exception e) {
	        JOptionPane.showMessageDialog(null,"Error");
	    }
	    
	}
	
	public static void oneSec(){
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	/* Use to print the deck:
	for (Card card: deck1.getCards()) {
		card.describe();
	}*/
		
}

