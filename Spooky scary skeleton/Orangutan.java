package skeleton;

/**
 * Az orangutan osztaly, ami az Animal osztalybol szarmazik, igy heterogen kollekcioban
 * tarolhato egyutt mas allatokkal.
 * Ezt fogja iranyitani a jatekos, aki mas jatekosokkal ellenben haromszot lephet egy korben.
 *
 * @version 1.0
 * @author Ferenczy Balint
 */
public class Orangutan extends Animal {

	/**
	 * Tarolja a jatekos pontszamait, amiket a pandak utan kap.
	 **/
	int points;

	/**
	 * Elengedi a mogotte allo panda kezet, ha van olyan.
	 **/
	@Override
	public void release() {
		Indent.print("Orangutan release()");
		if (backNeighbour != null) {
			backNeighbour.release();
		}
	}

	/**
	 * Megoli az orangutant, ezzel egyutt befejezi a jatekot.
	 **/
	@Override
	public void die() {
		Indent.print("Orangutan die()");
		Indent.inc();

		if (backNeighbour != null) {
			backNeighbour.release();
		}
		Controller.game.endGame();
		Indent.dec();
	}

	/**
	 * Kivalasztja, milyen csempere lepjen az otangutan.
	 * Ehhez a selectTileQuestions fuggveny kerdeseit hivja segitsegul
	 *
	 * @return Visszater a valasztott csempevel
	 **/
	@Override
	public Tile selectTile() {
		Indent.print("Orangutan selectTile()");
		Indent.inc();
		Tile t = Question.selectTileQuestions();
		Indent.dec();
		return t;
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
		Indent.print("Orangutan hitBy(Orangutan)");
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
		// TODO Auto-generated method stub
		Indent.print("Orangutan hitBy(Orangutan)");
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
		Indent.print("Orangutan collideWith(Element)");
		Indent.inc();
		boolean res = e.hitBy(this);
		Indent.dec();
		return res;
	}

	/**
	 * Az orangutan lepes fuggvenye.
	 * Ebben kivalasztja, melyik mezore lep, utkozik a benne levo objektumnak,
	 * es az utkozes eredmenyenek megfeleloen kezeli a kovetkezmenyeket.
	 **/
	@Override
	public void step() {
		// TODO Auto-generated method stub
		Indent.print("Orangutan step()");
		Indent.inc();
		Tile current = this.position;
		Tile tostep = this.selectTile();
		boolean accept = tostep.accept(this);
		if (accept) {
			position.remove();
			tostep.take(this);
		}
		boolean inQueue = this.isInQueue();
		if (inQueue && accept) {
			backNeighbour.follow(current);
		}
		Indent.dec();
	}

	/**
	 * Ellenorzi, sorban all-e a panda.
	 * Itt lehet kivalasztani, alljanak-e utana pandak.
	 *
	 * @return Igaz, ha all mogotte panda. Hamis, ha nem.
	 **/
	@Override
	public boolean isInQueue() {
		Indent.print("Orangutan isInQueue()");
		Indent.inc();
		if (!(backNeighbour != null)) {
			Question.orangutanQueueQuestions(this);
		}
		Indent.dec();
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
		Indent.print("Orangutan countPoints()");
		if (5 <= points && points < 10) {
			points += 5;
		} else if (10 < points) {
			points += 10;
		}
		return points;
	}

	/**
	 * A felvett pandak utan hozzaadodik egy pont a jatekosnak.
	 *
	 * @param incr hozzaad egy pontot a jatekos pontjaihoz
	 **/
	public void addPoints(int incr) {
		Indent.print("Orangutan addPoints()");
		Indent.inc();
		points++;
		Indent.dec();
	}

	/**
	 * Torli az orangutan mogott allo sort.
	 * Meghivodik ExitDoor-ba lepes eseten.
	 **/
	public void deleteQueue() {
		Indent.print("Orangutan deleteQueue()");
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
		Indent.print("Orangutan grab(Panda)");
		setBackNeighbour(p);
		getTile().swap(p.getTile());
	}

}
