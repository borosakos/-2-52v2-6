package skeleton;

import java.util.ArrayList;

/**
 *
 */

public class Panda extends Animal {

	protected boolean isAlive;
	protected Animal frontNeighbour;

	/**
	 * A szkeletonnak egy jelzo boolean, ami azt jelzi, hogy a tesztelo
	 * iranyitja-e a pandat
	 **/
	public boolean controlled = true;

	/**
	 * Default constructor
	 */
	public Panda() {
		Indent.print("Panda()");
		Indent.inc();

		isAlive = true;
		//frontNeighbour = null;
		Indent.dec();
	}

	public Panda(boolean b) {
		Indent.print("Panda()");
		Indent.inc();
		controlled = b;
		if (!b) {
			Tile t = new Tile();
			this.position = t;
			t.setElement(this);
		}
		Indent.dec();
	}


	/**
	 * A panda lep egy tetszoleges szomszedos mezore.
	 *
	 * @param
	 * @return Ha a panda sorban vagy olyan mezore lepne amire nem tud,
	 * akkor visszater.
	 */
	public void step() {
		Indent.print("Panda step()");
		Indent.inc();

		detect();
		if (!isAlive) {
			Indent.dec();
			return;
		}
		Tile current = this.getTile();

		if (isInQueue()) {
			if (!controlled) {
				Indent.dec();
				return;
			}
		}

		Tile t2 = selectTile();

		if (t2 == null || !t2.accept(this)) {
			Indent.dec();
			return;
		}

		getTile().remove();
		t2.take(this);


		if (isInQueue()) {
			backNeighbour.follow(current);
		}

		Indent.dec();

	}


	/**
	 * A lancban levo panda koveti az elotte halado allatot.
	 *
	 * @param t - A panda elott levo allat.
	 * @return Ha a panda olyan mezore lepne amire nem tud,
	 * akkor visszater.
	 */
	public void follow(Tile t) {
		Indent.print("Panda follow(Tile t)");
		Indent.inc();
		Tile t2 = getTile();
		
		t2.remove();
		t.take(this);
		this.position = t;
		if (backNeighbour != null) backNeighbour.follow(t2);

		Indent.dec();
	}

	/**
	 * Ellenorzi, hogy van-e a mezon valamilyen flag.
	 *
	 * @param
	 * @return
	 */
	public void detect() {
		Indent.print("Panda detect()");
		Indent.inc();
		Indent.dec();
	}

	/**
	 * Veletlenszeruen kivalasztja a csempet, amire lepni fog.
	 *
	 * @param
	 * @return Viszzater a kivalasztott csempevel.
	 */
	public Tile selectTile() {
		Indent.print("Panda selectTile()");
		
		return getTile().getNeighbours().get((int)(Math.random() * getTile().getNeighbours().size()));
	}

	/**
	 * Az orangutan nekimegy a pandanak.
	 *
	 * @param o - Az orangutan amelyik nekimegy a pandanak.
	 * @return false
	 */
	public boolean hitBy(Orangutan o) {
		Indent.print("Panda hitBy()");
		Indent.inc();
		if (isInQueue())
			o.die();

		Panda p2 = o.getBackNeighbour();
		o.grab(this);

		if (p2 != null) {
			p2.setFrontNeighbour(this);
			setBackNeighbour(p2);
		}

		Indent.dec();
		return false;
	}

	/**
	 * Beallitja az elotte allo allatot.
	 *
	 * @param animal - Az elotte allo allat.
	 * @return
	 */
	protected void setFrontNeighbour(Animal animal) {
		Indent.print("Panda setFrontNeighbour(Animal)");
		Indent.inc();

		frontNeighbour = animal;

		Indent.dec();
	}


	/**
	 * Egy panda nekimegy a pandanak.
	 *
	 * @param p - A panda amelyik nekiment a pandanak.
	 * @return false
	 */
	public boolean hitBy(Panda p) {
		Indent.print("Panda hitBy()");
		Indent.inc();
		Indent.dec();
		return false;
	}

	/**
	 * Lekezeli azt az esemenyt, amikor az adott elem utkozik a pandaval.
	 *
	 * @param e - Az elem amivel utkozik a panda.
	 * @return false
	 */
	public boolean collideWith(Element e) {
		// TODO implement here
		return false;
	}

	/**
	 * Megoli a pandat.
	 *
	 * @param
	 * @return
	 */
	public void die() {
		
		isAlive = false;
		getTile().setElement(null);
		if (frontNeighbour != null) getFrontNeighbour().setBackNeighbour(null);
		if (backNeighbour != null) release();
		setFrontNeighbour(null);
		setBackNeighbour(null);

	}

	/**
	 * Visszaadja, hogy a panda eletben van-e.
	 *
	 * @return A panda eletban van-e
	 */
	public boolean getIsAlive() {
		
		return isAlive;
	}


	/**
	 * A panda elott allo allatot adja vissza.
	 *
	 * @return A panda elott allo allatot adja vissza.
	 */
	protected Animal getFrontNeighbour() {
		
		return frontNeighbour;
	}


	/**
	 * Az adott panda megfogja a parameterkent kapott panda kezet,
	 * aki igy a lancban ele kerul.
	 *
	 * @param a - Az allat amelyiknek a kezet megfogja a panda.
	 * @return
	 */
	public void grab(Animal a) {
	

		a.setBackNeighbour(this);
		Tile pt = this.getTile();
		a.getTile().swap(pt); //idk jo-e ez igy, de senki nem mond semmit es maganyos vagyok:^)

	}


	/**
	 * Az adott panda elengedi a mogotte allo panda kezet, aki �gy megszunik szomszedja lenni.
	 *
	 * @param
	 * @return
	 */
	public void release() {


		if (frontNeighbour != null) {
			getFrontNeighbour().setBackNeighbour(null);
		}
		if (backNeighbour != null) {
			getBackNeighbour().setFrontNeighbour(null);
			getBackNeighbour().release();
		}

	}


	/**
	 * Visszaadja hogy a panda sorban all-e
	 *
	 * @return A panda sorban all-e.
	 */
	public boolean isInQueue() {
		
		return (backNeighbour != null && frontNeighbour !=null);
	}

	@Override
	public void step(Tile t) {

		detect();
		if (!isAlive) {
			Indent.dec();
			return;
		}
		Tile current = this.getTile();

		if (isInQueue()) {
			if (Controller.getRandom()==1) {
				Indent.dec();
				return;
			}
		}
		Tile t2 = t;
		if(Controller.getRandom()==1) {
			t2 = selectTile();
		}

		if (t2 == null || !t2.accept(this)) {
			Indent.dec();
			return;
		}
		getTile().remove();
		t2.take(this);
		if (isInQueue()) {backNeighbour.follow(current);}
	}
	
		
	/**
	 * Kiprinteli standard outputra vagy egy fajlba az objektum allapotat.
	 */
	public void printStats() {
		Printer.printName(name);
		Printer.print("position: " + position.getName());
		Printer.print("isAlive" + isAlive);
		Printer.print("backNeighbour: " + backNeighbour.getName());
		Printer.print("frontNeighbour: " + frontNeighbour.getName());
		//TODO: van egy controlled is, az csak skeletonban kellett, nem?
	}
}

