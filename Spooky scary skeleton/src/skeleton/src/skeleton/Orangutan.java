package skeleton;

import javax.swing.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Az orangutan osztaly, ami az Animal osztalybol szarmazik, igy heterogen kollekcioban
 * tarolhato egyutt mas allatokkal.
 * Ezt fogja iranyitani a jatekos, aki mas jatekosokkal ellenben haromszot lephet egy korben.
 *
 * @author Ferenczy Balint
 * @version 1.0
 */
public class Orangutan extends Animal {

	/**
	 * Tarolja a jatekos pontszamait, amiket a pandak utan kap.
	 **/
	int points;

	public boolean toStep = false;
	public boolean dead = false;
	private int canSteal = 0;
	ArrayList<Float> color = new ArrayList<>();

	public Orangutan() {
		setColor(1.0f, 1.0f, 1.0f, 0.0f);
	}

	/**
	 * Elengedi a mogotte allo panda kezet, ha van olyan.
	 **/
	@Override
	public void release() {
		Indent.print("Orangutan " + this.name + " released its queue.");
		if (backNeighbour != null) {
			backNeighbour.release();
			backNeighbour=null;
		}
	}

	public void wannaStep() {
		toStep = true;
	}

	public void setColor(float r, float g, float b, float a) {
		color.clear();
		color.add(r);
		color.add(g);
		color.add(b);
		color.add(a);
	}

	/**
	 * Megoli az orangutant, ezzel egyutt befejezi a jatekot.
	 **/
	@Override
	public void die() {
		release();
		position.element = null;
		position = null;
		dead = true;
		Controller.game.endGame();
	}

	/**
	 * Kivalasztja, milyen csempere lepjen az otangutan.
	 * Ehhez a selectTileQuestions fuggveny kerdeseit hivja segitsegul
	 *
	 * @return Visszater a valasztott csempevel
	 **/
	@Override
	public Tile selectTile() {
		Scanner sc = new Scanner(System.in);
		String selection;
		Indent.print("***Orangutan " + this.name + " lep***");
		Indent.print("Jelenlegi helyzet: " + this.position.getName());
		for (int i = 0; i < position.getNeighbours().size(); i++) {
			if (this.backNeighbour != null) {
				if (position.getNeighbours().get(i) != this.backNeighbour.position)
					Indent.print(i + ".: " + position.getNeighbours().get(i).name);
			} else {
				Indent.print(i + ".: " + position.getNeighbours().get(i).name);
			}

		}
		Indent.print("Ird be a valasztott csempe szamat!");
		selection = sc.nextLine();
		if (selection.equals("release")) {
			this.release();
			return this.selectTile();
		}
		int index = Integer.parseInt(selection);

		return position.getNeighbours().get(index);
	}

	/**
	 * Kezeli, mi tortenik, amikor az orangutannak nekimeg egy masik orangutan.
	 * Ertelemszeruen ezt a lepest nem engedelyezi
	 *
	 * @param o Az orangutan, ami nekiutkozik
	 * @return mindig hamissal ter vissza, hisz olyan mezore nem lephet, amin all orangutan
	 **/
	@Override
	public boolean hitBy(Orangutan o) {
		if (o.isInQueue()) return false;


		if (isInQueue() && o.canSteal <= 0) {
			this.position.swap(o.position);
			o.setBackNeighbour(this.backNeighbour);
			this.backNeighbour.setFrontNeighbour(o);
			this.backNeighbour = null;
			this.canSteal = 3;
		}

		return false;
	}

	/**
	 * Kezeli, mi tortenik, amikor az orangutannak nekimegy egy panda.
	 * Ertelemszeruen ezt a lepest nem engedelyezi
	 *
	 * @param p A panda, ami nekiutkozik az orangutannak
	 * @return mindig hamissal ter vissza, hisz olyan mezore nem lephet, amin all orangutan
	 **/
	@Override
	public boolean hitBy(Panda p) {
		return false;
	}

	/**
	 * Atadja azt a mezo elemet, amire ra akar lepni az orangutan.
	 * Erre meghivodik az utkozes.
	 *
	 * @param e Az az elem, ami a valasztott csempen van
	 * @return visszaadja az utkozes eredmenyet, azaz, hogy ralephet-e a csempere
	 **/
	@Override
	public boolean collideWith(Element e) {
		boolean res = e.hitBy(this);
		return res;
	}

	/**
	 * Az orangutan lepes fuggvenye.
	 * Ebben kivalasztja, melyik mezore lep, utkozik a benne levo objektumnak,
	 * es az utkozes eredmenyenek megfeleloen kezeli a kovetkezmenyeket.
	 **/
	@Override
	public void step() {

		Tile current = this.position;
		Tile tostep = this.selectTile();
		boolean accept = tostep.accept(this);
		if (accept) {
			position.remove();
			tostep.take(this);
			this.position = tostep;
		}
		boolean inQueue = this.isInQueue();
		if (inQueue && accept) {
			backNeighbour.follow(current);
		}
		
	}

	/**
	 * Ellenorzi, sorban all-e a panda.
	 * Itt lehet kivalasztani, alljanak-e utana pandak.
	 *
	 * @return Igaz, ha all mogotte panda. Hamis, ha nem.
	 **/
	@Override
	public boolean isInQueue() {
		return (backNeighbour != null);
	}

	/**
	 * Megszamolja a mogotte sorban allo pandak utan, hogy mennyi pont
	 * jar a jatekosnak. Otnel tobb panda eseten +5, 10-nel tobb panda
	 * eseten +10 pont jar.
	 *
	 * @return visszaadja pontok szamat
	 **/
	public int countPoints() {
		if (!isInQueue()) return 0;
		Panda lastBackNeighbour = backNeighbour;
		
		while (lastBackNeighbour != null) {
			lastBackNeighbour = lastBackNeighbour.backNeighbour;
			points++;
		}
		if (5 <= points && points < 10) {
			points += 5;
		} else if (10 < points) {
			points += 10;
		}
		if (Controller.gameOn) {
			Indent.print("Orangutan " + this.name + " got " + points + " points.");
		}
		return points;
	}

	/**
	 * A felvett pandak utan hozzaadodik egy pont a jatekosnak.
	 *
	 * @param incr hozzaad egy pontot a jatekos pontjaihoz
	 **/
	public void addPoints(int incr) {
		points++;
	}

	/**
	 * Torli az orangutan mogott allo sort.
	 * Meghivodik ExitDoor-ba lepes eseten.
	 **/
	public void deleteQueue() {
		Panda lastBackNeighbour = backNeighbour;
		backNeighbour = null;
		while (lastBackNeighbour != null) {
			Panda current = lastBackNeighbour;
			lastBackNeighbour = lastBackNeighbour.backNeighbour;
			current.die();
		}
	}

	/**
	 * Megragadja a parameterkent kapott pandat, es beallitja hatso szomszedjanak.
	 *
	 * @param p A panda, amit hatso szomszednak allit
	 **/
	public void grab(Panda p) {
		setBackNeighbour(p);
		if (!p.isInQueue()) {
			getTile().swap(p.getTile());
		}
		this.backNeighbour.setFrontNeighbour(this);
	}

	@Override
	public void step(Tile t) {
		this.canSteal--;
		toStep = false;
		Tile current = this.position;
		Tile tostep = t;
		boolean accept = tostep.accept(this);
		if (accept) {
			position.remove();
			tostep.take(this);
		}
		boolean inQueue = this.isInQueue();
		if (inQueue && accept) {
			backNeighbour.follow(current);
		}
		Controller.game.endGame();
	}

	/**
	 * Kiprinteli standard outputra vagy egy fajlba az objektum allapotat.
	 */
	public void printStats() {
		Printer.printName(name);
		Printer.print("position: " + position.getName());
		Printer.print("points: " + points);
		if (backNeighbour != null) Printer.print("backNeighbour: " + backNeighbour.getName());
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(JLabel label) {
		// TODO Auto-generated method stub
		ImageIcon image = new ImageIcon("orangutan.png");
		label.setIcon(image);

	}

	@Override
	public Color getLineColor() {
		return new Color(this.color.get(0), this.color.get(1), this.color.get(2));
	}
	
	public boolean inPair(Element element) {
		if(backNeighbour==null) return false;
		if (element.name.equals(this.backNeighbour.name)) return true;
		/*Panda p = backNeighbour;
		while(p!=null) {
			if(p.name.equals(element.name)) return true;
			p = p.backNeighbour;
		}*/
		return false;
	}
	
}
