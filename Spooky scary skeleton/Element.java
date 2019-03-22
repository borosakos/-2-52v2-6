package skeleton;

/**
 * 
 */
public abstract class Element {

    /**
     * Default constructor
     */
    public Element() {
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