package skeleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.*; 

import javax.swing.JOptionPane;

public class Game {
	public Board board;
	boolean end = false;

	Game() {
		board = new Board();
	}

	Game(Board _board) {
		board = _board;
	}

	public void endGame() {
		if(hasEnded()==1) {
			JOptionPane.showMessageDialog(null, "All of the pandas have been rescued! Let's take a look at your scores...");
			ArrayList<Orangutan> scores = Controller.getOrangutans();
			Collections.sort(scores, new SortByPoints());
			JOptionPane.showMessageDialog(null, "The winner is "+scores.get(0).name+" with "+scores.get(0).points+ " points.");
			for(int i = 1; i<scores.size(); i++) {
				JOptionPane.showMessageDialog(null, "Then comes "+scores.get(i).name+" with "+scores.get(i).points+ " points.");
			}
			JOptionPane.showMessageDialog(null, "Game OVER!");
			System.exit(0);
		}
		ArrayList<Orangutan> died = new ArrayList<>();
		Orangutan winner = null;
		if(hasEnded()==2) {
			for(Orangutan o:Controller.getOrangutans()) {
				if (o.dead) {
					died.add(o);
				} else {
					winner = o;
				}
			}
			String message = "The game has ended, because";
			for(int i = 0; i<died.size(); i++) {
				message+=" "+died.get(i).name;
				if(i!=(died.size()-1)) message+=" and";
			}
			message+= " died. That leaves "+winner.name+" as the winner. Congrats!";
			JOptionPane.showMessageDialog(null, message);
			System.exit(0);
		}
	}
	class SortByPoints implements Comparator<Orangutan> 
	{ 
	    // Used for sorting in ascending order of 
	    // roll number 
		public int compare(Orangutan a, Orangutan b) 
	    { 
	        return b.points - a.points; 
	    } 
	} 
	

	public void startGame() {
		while (hasEnded()==0) {
			Controller.tick();
		}
	}

	public int hasEnded() {
			boolean pandaRemained = false;
			for(Panda p:Controller.getPandas()) {
				if(p.isAlive) pandaRemained = true;
			}
			if(!pandaRemained) {
				return 1;
			}
			int dead = 0;
			for(Orangutan o :Controller.getOrangutans()) {
				if (o.dead) dead++;
			}
			if(dead==Controller.getOrangutans().size()-1) {
				return 2;
			}
			return 0;
	}
}
