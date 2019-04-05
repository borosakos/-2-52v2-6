package skeleton;

/**
 *
 */
public abstract class Element {


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected String name;

	/**
	 * Default constructor
	 */
	public Element() {
	}

	public void setTile(Tile t) {
		position = t;
	}

	public Tile getTile() {
		return position;
	}

	/**
	 *
	 */
	protected Tile position;

	/**
	 * @param o
	 * @return
	 */
	public abstract boolean hitBy(Orangutan o);

	/**
	 * @param p
	 * @return
	 */
	public abstract boolean hitBy(Panda p);

	/**
	 * @param e
	 * @return
	 */
	public abstract boolean collideWith(Element e);

}