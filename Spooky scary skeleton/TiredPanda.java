package skeleton;


import java.util.ArrayList;

/**
 *
 */
public class TiredPanda extends Panda {

	/**
	 * Default constructor
	 */
	public TiredPanda() {

		Indent.print("TiredPanda()");
		Indent.inc();

		isAlive = true;
		//super();
		isSitting = false;
		inArmchair = null;
		sittingTimeLeft = -1;

		Indent.dec();
	}

	/**
	 * Constructor
	 */
	public TiredPanda(boolean b) {
		Indent.print("TiredPanda()");
		Indent.inc();
		controlled = b;
		if (!b) {
			Tile t = new Tile();
			this.position = t;
			t.setElement(this);
		}
		Indent.dec();
	}


	private boolean isSitting;
	private Armchair inArmchair;
	private int sittingTimeLeft;
	ArrayList<Armchair> usedArmchairs = new ArrayList<>();

	/**
	 * Az adott panda leul a parameterkent kapott fotelbe veletlenszeru ideig.
	 *
	 * @param ac - A fotel amelyikbe ulni fog a panda.
	 */

	public void sitDown(Armchair ac) {
		Indent.print("TiredPanda sitDown()");
		Indent.inc();
		isSitting = true;
		sittingTimeLeft = 3;
		usedArmchairs.add(ac);
		setArmchair(ac);
		ac.setOccupied(true);
		getTile().remove();
		position = null;

		Indent.dec();
	}

	/**
	 * Veletlenszeruen kivalasztja a csempet, amire lepni fog.
	 *
	 * @param
	 * @return Viszzater a kivalasztott csempevel.
	 */
	public Tile selectTile() {

		Indent.print("TiredPanda selectTile()");
		Indent.inc();
		if (isSitting) {
			return null;
		}

		Indent.dec();
		return getTile().getNeighbours().get((int)(Math.random() * getTile().getNeighbours().size()));
	}

	/**
	 * A panda lep egy tetszoleges szomszedos mezore.
	 *
	 * @param
	 * @return Ha a panda sorban vagy olyan mezore lepne amire nem tud,
	 * akkor visszater.
	 */
	public void step() {

		if (isSitting) {
			sittingTimeLeft--;
			if (sittingTimeLeft == 0) {
				getUp();
			}
			return;
		}
		Indent.print("TiredPanda step()");
		Indent.inc();

		detect();


		if (isInQueue()) {
			if (Controller.getRandom()) {
				Indent.dec();
				return;
			}
		}
		Tile t2 = null;
		if (Controller.getRandom()) {
			t2 = selectTile();
		}

		if (t2 == null || !t2.accept(this)) {
			Indent.dec();
			return;
		}

		getTile().remove();
		t2.take(this);


		if (isInQueue()) {
			backNeighbour.follow(this.getTile());
		}

		Indent.dec();
	}

	/**
	 * Az adott felall a fotelebol, es egy vele szomszedos mezore lep.
	 *
	 * @param
	 * @return
	 */
	public void getUp() {
		Indent.print("TiredPanda getUp()");

		isSitting = false;
		for (Tile t : inArmchair.getTile().getNeighbours()) {
			if (t.getElement().equals(null)) t.take(this);
		}
		inArmchair.setOccupied(false);
		inArmchair = null;

		Indent.inc();
		Indent.dec();
	}

	/**
	 * Megnezi, hogy van-e fotel a kornyeken.
	 *
	 * @param
	 * @return Ha nincs korulotte fotel visszater.
	 */
	public void detect() {
		Indent.print("TiredPanda detect()");
		Indent.inc();

		Armchair ac = chooseArmchair();
		if (ac == null) {
			Indent.dec();
			return;
		}
		sitDown(ac);

		setFrontNeighbour(null);
		if (isInQueue()) {
			backNeighbour.release();
		}

		Indent.dec();
	}

	/**
	 * Lekerdezi a szomszedos foteleket, �s kivalasztja kozuluk az elso olyat, ami nem foglalt.
	 *
	 * @param
	 * @return Visszater a valasztott fotellel.
	 */
	public Armchair chooseArmchair() {
		Indent.print("TiredPanda chooseArmchair()");
		Indent.inc();

		ArrayList<Armchair> armchairs = getTile().getNeighbouringArmchairs();
		for (Armchair armchair : armchairs) {
			if (!armchair.getIsOccupied() && !usedArmchairs.contains(armchair)) {
				Indent.dec();
				return armchair;
			}
		}

		Indent.dec();
		return null;
	}

	/**
	 * Beallitja, a fotelt amibe a panda beleul.
	 *
	 * @param ac - A fotel a mibe ulni fog a panda
	 * @reuturn
	 */
	public void setArmchair(Armchair ac) {
		Indent.print("TiredPanda chooseArmchair()");
		Indent.inc();
		inArmchair = ac;
		Indent.dec();
	}

	public void step(Tile t) {
		if (isSitting) {
			sittingTimeLeft--;
			if (sittingTimeLeft == 0) {
				getUp();
			}
			return;
		}
		Indent.print("TiredPanda step()");
		Indent.inc();

		detect();


		if (isInQueue()) {
			if (Controller.getRandom()) {
				Indent.dec();
				return;
			}
		}
		Tile t2 = t;
		if (Controller.getRandom()) {
			t2 = selectTile();
		}

		if (t2 == null || !t2.accept(this)) {
			Indent.dec();
			return;
		}

		if (!isSitting) {
			getTile().remove();
			t2.take(this);
		}

		if (isInQueue()) {
			backNeighbour.follow(this.getTile());
		}

		Indent.dec();
	}

	/**
	 * Kiprinteli standard outputra vagy egy fajlba az objektum allapotat.
	 */
	public void printStats() {
		Printer.printName(name);
		Printer.print("position: " + position.getName());
		Printer.print("isAlive: " + isAlive);
		if (backNeighbour != null) Printer.print("backNeighbour: " + backNeighbour.getName());
		if (frontNeighbour != null) Printer.print("frontNeighbour: " + frontNeighbour.getName());
		Printer.print("isSitting: " + isSitting);
		if (inArmchair != null) Printer.print("isArmchair: " + inArmchair.getName());
		Printer.print("sittingTimeLeft: " + sittingTimeLeft);
	}
}