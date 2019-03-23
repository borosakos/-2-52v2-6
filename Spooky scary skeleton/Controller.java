package skeleton;

import java.util.ArrayList;

/**
* A jatek motorja, ami lepteti az osszes jatekost es elementet,
* amig a jatek veget nem ert.
*
* @author		Ferenczy Balint
* @author		Bozi Roland
* @version 	1.0
*/

public  class Controller {
	/**
	* A leptetheto dolgok, amik se nem pandak, se nem orangutanok
	*/
	private static ArrayList<Steppable> steppables = new ArrayList<>();

	/**
	* A pandakat tartalmazo tomb
	*/
	private static ArrayList<Panda> pandas = new ArrayList<>();
	/**
	* Az orangutanok tartalmazo tomb
	*/
	private static ArrayList<Orangutan> orangutans = new ArrayList<>();
	/**
	* A jatek peldany
	*/
	public static Game game = new Game();

	/**
	* A fo lepteto fuggveny, amit a Game hiv meg egy ciklusban
	* Eloszor az orangutanokat, majd a pandakat, vegul pedig az
	* egyeb leptetheto objektumokat lepteti. Ez a sorrend
	* biztositja az akciok megfelelo sorrendu lefutasat (pl. mezo
	* csilingeles kezelese).
	* Az orangutanok egy korben haromszor lephetnek, ez az oka a
	* belso for ciklusnak (igy a jatekban konnyebb lesz elkapni
	* a pandakat).
	*/
	public void tick() {
		Indent.print("Controller tick()");
		Indent.inc();
			if(game.hasEnded()) {
				game.endGame(); return;
			} else {
				for (int i = 0; i< 3; i++) {
					for(Orangutan o: orangutans) {
						o.step();
					}
				}
				for(Panda p: pandas) {
					if(p.getIsAlive()) p.step();
				}
				for(Steppable s: steppables) {
					s.step();
				}
			}
		Indent.dec();
	}



	/**
	* Panda hozzaadasa a listahoz.
	* @param p A panda amit hozzaadunk a listahoz
	*/
	public static void addPanda(Panda p) {
		Indent.print("Controller addPanda(Panda)");
		pandas.add(p);
	}
	/**
	* Orangutan hozzaadasa a listahoz.
	* @param o Az orangutan amit hozzaadunk a listahoz
	*/
	public static void addOrangutan(Orangutan o) {
		Indent.print("Controller addOrangutan(Orangutan)");
		orangutans.add(o);
	}
	/**
	* Steppable hozzaadasa a listahoz.
	* @param s A steppable amit hozzaadunk a listahoz
	*/
	public static void addSteppable(Steppable s) {
		steppables.add(s);
	}
	/**
	* Visszaadja az orangutanok listajat.
	* @return Az orangutanok listaja
	*/
	public static ArrayList<Orangutan> getOrangutans(){
		return orangutans;
	}
	/**
	* Visszaadja a pandak listajat.
	* @return A pandak listaja
	*/
	public static ArrayList<Panda> getPandas(){
		return pandas;
	}
}
}
