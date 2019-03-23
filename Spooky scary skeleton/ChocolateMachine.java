package skeleton;

/**
 * Egy csempén lévő csokiautomata. Körönként van esély arra, hogy sípol egyet.
 */
public class ChocolateMachine extends Element {
	
    /**
     * Lekezeli a gép időszakos sípolását.
     */
    public void step() {
        Indent.print("ChocolateMachine step()");
		whistle();
    }

    /**
     * Beállítja a körülötte lévő tile-okat whistling-re.
     */
    public void whistle() {
		Indent.print("ChocolateMachine whistle()");
		Indent.inc();
		
		boolean whistling = rand();
		
		for(Tile t : position.getNeighbours())
			t.setIsWhistling(whistling);
		
		Indent.dec();
    }

    /**
     * @param o Orángután
	 * Az orángutánnal való ütközést kezeli, nem engedi, hogy rálépjen.
     * @return Nem léphet rá, tehát hamis.
     */
    public boolean hitBy(Orangutan o) {
		Indent.print("ChocolateMachine hitBy(Orangutan)");
        return false;
    }

    /**
     * @param p Panda
	 * A pandával való ütközést kezeli, nem engedi, hogy rálépjen.
     * @return Nem léphet rá, tehát hamis.
     */
    public boolean hitBy(Panda p) {
		Indent.print("ChocolateMachine hitBy(Panda)");
        return false;
    }

    /**
	 * Visszadja, hogy kell-e fütyülni ebben a körben.
     * @return Ha a random szám nagyobb vagy egyenlő mint 0.5 akkor nem fütyül, egyébként de.
     */
    private boolean rand() {
        Indent.print("ChocolateMachine rand()");
        return Math.random() < 0.5;
    }
    
    /**
     * @param e Elem
	 * Lekezeli azt az eseményt, amikor az adott elem ütközik valamivel.
     * @return Itt hamist adunk vissza.
     */
    public boolean collideWith(Element e) {
		Indent.print("ChocolateMachine collideWith(Element)");
		return false;
    	
    }

}