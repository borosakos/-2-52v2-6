package skeleton;

/**
 * Egy csempen levo csokiautomata. Koronkent van esely arra, hogy sipol egyet.
 * @author Bozi Roland
 * @version 1.0
 */
public class ChocolateMachine extends Element {
	
    /**
     * Lekezeli a gep idoszakos sipolasat.
     */
    public void step() {
        Indent.print("ChocolateMachine step()");
		whistle();
    }

    /**
     * Beallitja a korulotte levo tile-okat whistling-re.
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
	 * Az orangutannal valo utkozest kezeli, nem engedi, hogy ralepjen.
     * @param o Orangutan
     * @return Nem lephet ra, tehat hamis.
     */
    public boolean hitBy(Orangutan o) {
		Indent.print("ChocolateMachine hitBy(Orangutan)");
        return false;
    }

    /**
	 * A pandaval valo utkozest kezeli, nem engedi, hogy ralepjen.
     * @param p Panda
     * @return Nem lephet ra, tehat hamis.
     */
    public boolean hitBy(Panda p) {
		Indent.print("ChocolateMachine hitBy(Panda)");
        return false;
    }

    /**
	 * Visszadja, hogy kell-e futyulni ebben a korben.
     * @return Ha a random szam nagyobb vagy egyenlo mint 0.5 akkor nem futyul, egyebkent de.
     */
    private boolean rand() {
        Indent.print("ChocolateMachine rand()");
        return Math.random() < 0.5;
    }
    
    /**
	 * Lekezeli azt az esemenyt, amikor az adott elem utkozik valamivel.
     * @param e Elem
     * @return Itt hamist adunk vissza.
     */
    public boolean collideWith(Element e) {
		Indent.print("ChocolateMachine collideWith(Element)");
		return false;
    	
    }

}