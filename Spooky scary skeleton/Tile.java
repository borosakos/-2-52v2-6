package skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 
 */
public class Tile {

	/**
	 * Default constructor
	 */
	public Tile() {
	}

	public Tile(boolean b, boolean c, Armchair ac) {
		isJingling = b;
		isWhistling = c;
		neighbouringArmchairs.add(ac);
	}

	private boolean isJingling;
	private boolean isWhistling;
	protected Element element;
	private ArrayList<Tile> neighbours;
	protected ArrayList<Armchair> neighbouringArmchairs;

	/**
	 * @param a
	 * @return
	 */
	public boolean accept(Animal a) {
		Indent.print("Tile accept()");
		
		Indent.print("All valami a mezon, amire lepni szeretnel? (A / ED / XD / CM / GM / O / P / TP / SP / JP /  W / N)");
		Indent.inc();
		BufferedReader reader =  
                new BufferedReader(new InputStreamReader(System.in)); 
		try {
			String answer = reader.readLine();
			answer = answer.toUpperCase();
			switch(answer) {
			case "A": this.setElement(new Armchair());
			break;
			case "ED": this.setElement(new EntryDoor());
			break;
			case "XD": this.setElement(new ExitDoor()); //XDDDDDD
			break;
			case "CM": this.setElement(new ChocolateMachine());
			break;
			case "GM": this.setElement(new GameMachine());
			break;
			case "O": this.setElement(new Orangutan());
			break;
			case "P": this.setElement(new Panda());
			break;
			case "TP": this.setElement(new TiredPanda());
			break;
			case "SP": this.setElement(new ScaredPanda());
			break;
			case "JP": this.setElement(new JumpingPanda());
			break;
			case "W": this.setElement(new Wardrobe());
			break;
			case "N": this.setElement(null);
			break;
			default: this.setElement(null);
			
			
			}
			if(answer.equals("P") || answer.equals("TP") ||answer.equals("JP") ||answer.equals("SP")) {
				Indent.print("A panda resze-e lancnak?");
				answer = reader.readLine(); answer = answer.toUpperCase();
				if(answer.equals("Y")) {
					Indent.print("Allnak a panda mogott a lancban?");
					answer = reader.readLine(); answer = answer.toUpperCase();
					if(answer.equals("Y")) {
						//TODO: this.getElement().set
					}
				}
			}
		} catch (IOException e) {
			Indent.print("Valami szornyu valaszt adhattal meg, ezert a rendszer osszeomlott.");
			e.printStackTrace();
		} 
		
		if (element == null)
			return true;
		else
			return a.collideWith(element);
	}

	/**
	 * @return
	 */
	public ArrayList<Tile> getNeighbours() {
		Indent.print("Tile getNeighbours()");
		return neighbours;
	}

	/**
	 * @param t
	 */
	public void addNeighbour(Tile t) {
		Indent.print("Tile addNeighbour()");
	}

	/**
	 * @param a
	 */
	public void remove(Animal a) {
		Indent.print("Tile remove()");
		element = null;
	}

	/**
	 * @return
	 */
	public ArrayList<Armchair> getNeighbouringArmchairs() {
		Indent.print("Tile getNeighbouringArmchairs()");
		return neighbouringArmchairs;
	}

	/**
	 * @param b
	 */
	public void setIsJingling(boolean b) {
		Indent.print("Tile setIsJingling()");
		isJingling = b;
	}

	/**
	 *
	 */
	public boolean getIsJingling() {
		Indent.print("Tile getIsJingling()");
		return isJingling;
	}

	/**
	 * @param b
	 */
	public void setIsWhistling(boolean b) {
		Indent.print("Tile setIsWhistling()");
		isWhistling = b;
	}

	/**
	 * @return
	 */
	public boolean getIsWhistling() {
		Indent.print("Tile getIsWhistling()");
		return isWhistling;
	}

	/**
	 * @param e
	 */
	public void setElement(Element e) { //Ha jól értem, ez csak inicializásnál lesz használva de idk
		Indent.print("Tile setElement()");
		element = e;
	}

	/**
	 * @param a
	 */
	public void take(Animal a) {
		Indent.print("Tile take()");
		element = a;
	}

	/**
	 * @param t
	 */
	public void swap(Tile t) {
		Indent.print("Tile swap()");
		Indent.inc();
		Element tempElement = element;
		element = t.element;
		t.element = tempElement;
		Indent.dec();
	}

	public boolean lifeDecrease(int i) {
		Indent.print("Tile lifeDecrease(int i)");
		return false;
	}

}