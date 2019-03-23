package skeleton;

/**
 * Egy csempén lévő játékgép. Körönként van esély arra, hogy csilingel.
 */
public class GameMachine extends Element {

    /**
     * Lekezeli a gép időszakos csilingelését.
     */
    public void step() {
		Indent.print("GameMachine step()");
		Indent.inc();
		
		jingle();
		
		Indent.dec();
    }

    /**
     * Beállítja a szomszédos tile-okat jingling-re.
     */
    public void jingle() {
    	Indent.print("GameMachine jingle()");
		Indent.inc();
		
		boolean jingling = rand();
		
		for(Tile t : position.getNeighbours())
			t.setIsJingling(jingling);
		
		Indent.dec();
    }

    /**
     * @param o Orángután
	 * Az orángutánnal való ütközést kezeli, nem engedi, hogy rálépjen.
     * @return Nem léphet rá, tehát hamis.
     */
    public boolean hitBy(Orangutan o) {
    	Indent.print("GameMachine hitBy(Orangutan)");
        return false;
    }

    /**
     * @param p Panda
	 * A Pandával való ütközést kezeli, nem engedi, hogy rálépjen.
     * @return Nem léphet rá, tehát hamis.
     */
    public boolean hitBy(Panda p) {
    	Indent.print("GameMachine hitBy(Panda)");
        return false;
    }

    /**
	 * Visszadja, hogy kell-e zenélni ebben a körben.
     * @return Ha a random szám nagyobb vagy egyenlő mint 0.5 akkor nem fütyül, egyébként de.
     */
    private boolean rand() {
        Indent.print("GameMachine rand()");
        return Math.random() < 0.5;
    }

    /**
     * @param e Elem 
	 * Lekezeli azt az eseményt, amikor az adott elem ütközik valamivel.
     * @return Itt hamist adunk vissza.
     */
    public boolean collideWith(Element e) {
		Indent.print("GameMachine collideWith(Element)");
		return false;
    }

}