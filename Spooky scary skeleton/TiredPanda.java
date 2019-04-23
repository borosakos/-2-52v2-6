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
		isAlive = true;
		//super();
		isSitting = false;
		inArmchair = null;
		sittingTimeLeft = -1;
	}

	/**
	 * Constructor
	 */
	public TiredPanda(boolean b) {
		controlled = b;
		if (!b) {
			Tile t = new Tile();
			this.position = t;
			t.setElement(this);
		}
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
		isSitting = true;
		sittingTimeLeft = 3;
		usedArmchairs.add(ac);
		setArmchair(ac);
		ac.setOccupied(true);
		getTile().remove();
		position = null;
		if(Controller.gameOn) {
			Indent.print("TiredPanda "+this.name+" sits down on "+ac.name);
		}
	}

	/**
	 * Veletlenszeruen kivalasztja a csempet, amire lepni fog.
	 *
	 * @param
	 * @return Viszzater a kivalasztott csempevel.
	 */
	public Tile selectTile() {
		if (isSitting) {
			return null;
		}

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

		detect();


		if (isInQueue()) {
			if (Controller.getRandom()) {
				return;
			}
		}
		Tile t2 = null;
		if (Controller.getRandom()) {
			t2 = selectTile();
		}

		if (t2 == null || !t2.accept(this)) {
			return;
		}

		getTile().remove();
		t2.take(this);


		if (isInQueue()) {
			backNeighbour.follow(this.getTile());
		}
	}

	/**
	 * Az adott felall a fotelebol, es egy vele szomszedos mezore lep.
	 *
	 * @param
	 * @return
	 */
	public void getUp() {

		isSitting = false;
		for (Tile t : inArmchair.getTile().getNeighbours()) {
			if (t.getElement()==null) t.take(this);
		}
		inArmchair.setOccupied(false);
		inArmchair = null;
	}

	/**
	 * Megnezi, hogy van-e fotel a kornyeken.
	 *
	 * @param
	 * @return Ha nincs korulotte fotel visszater.
	 */
	public void detect() {
		Armchair ac = chooseArmchair();
		if (ac == null) {
			return;
		}
		sitDown(ac);

		setFrontNeighbour(null);
		if (isInQueue()) {
			backNeighbour.release();
		}
	}

	/**
	 * Lekerdezi a szomszedos foteleket, �s kivalasztja kozuluk az elso olyat, ami nem foglalt.
	 *
	 * @return Visszater a valasztott fotellel.
	 */
	public Armchair chooseArmchair() {

		ArrayList<Armchair> armchairs = getTile().getNeighbouringArmchairs();
		for (Armchair armchair : armchairs) {
			if (!armchair.getIsOccupied() && !usedArmchairs.contains(armchair)) {
				return armchair;
			}
		}

		return null;
	}

	/**
	 * Beallitja, a fotelt amibe a panda beleul.
	 *
	 * @param ac - A fotel a mibe ulni fog a panda
	 */
	public void setArmchair(Armchair ac) {
		inArmchair = ac;
	}

	public void step(Tile t) {
		if (isSitting) {
			sittingTimeLeft--;
			if (sittingTimeLeft == 0) {
				getUp();
			}
			return;
		}

		detect();


		if (isInQueue()) {
			if (Controller.getRandom()) {
				return;
			}
		}
		Tile t2 = t;
		if (Controller.getRandom()) {
			t2 = selectTile();
		}

		if (t2 == null || !t2.accept(this)) {
			return;
		}

		if (!isSitting) {
			getTile().remove();
			t2.take(this);
		}

		if (isInQueue()) {
			backNeighbour.follow(this.getTile());
		}
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