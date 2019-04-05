package skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Egy torekeny csempet reprezentalo osztaly
 */
public class BreakableTile extends Tile {
	private int life = -1;


	public BreakableTile(int life) {
		this.life = life;
	}

	public BreakableTile(boolean b, boolean c, Armchair ac, int life) {
		super(b, c, ac);
		this.life = life;
	}

	/**
	 * Beallitja, hogy az allat a mezore lépjen
	 *
	 * @param a A mezore lepo allat
	 */
	@Override
	public void take(Animal a) {
		if (life <= 0) {
			a.die();
		} else {
			element = a;
		}
	}


	/**
	 * Lekezeli a mezore lepo allatot.
	 *
	 * @param a A mezore lepo allat
	 * @return true, ha a mezore lephet az allat, false ha nem
	 */
	public boolean accept(Animal a) { //Ez idk jo-e, meglatjuk
		Indent.print("BreakableTile accept()");
		if (life != 0) {
			Indent.print("Mennyi lifee legyen a csempenek? (nullanal nagyobb egesz)");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				life = Integer.parseInt(reader.readLine());
			} catch (IOException e) {

				e.printStackTrace();
			}
			Indent.print("Tile accept()");

			Indent.print("All valami a mezon, amire lepni szeretnel? (A / ED / XD / CM / GM / O / P / N)");
			Indent.inc();

			try {
				String answer = reader.readLine();
				answer = answer.toUpperCase();
				switch (answer) {
					case "A":
						this.setElement(new Armchair());
						break;
					case "ED":
						this.setElement(new EntryDoor());
						break;
					case "XD":
						this.setElement(new ExitDoor()); //XDDDDDD
						break;
					case "CM":
						this.setElement(new ChocolateMachine());
						break;
					case "GM":
						this.setElement(new GameMachine());
						break;
					case "O":
						this.setElement(new Orangutan());
						break;
					case "P":
						ArrayList<Panda> pandasor = new ArrayList<>();
						Indent.printr("Milyen fajta panda? (P / TP / SP / JP)");
						answer = reader.readLine().toUpperCase();
						switch (answer) {
							case "P":
								pandasor.add(new Panda());
								break;
							case "TP":
								pandasor.add(new TiredPanda());
								break;
							case "SP":
								pandasor.add(new ScaredPanda());
								break;
							case "JP":
								pandasor.add(new JumpingPanda());
								break;
						}
						Indent.printr("A panda resze-e lancnak? (Y / N)");
						answer = reader.readLine();
						answer = answer.toUpperCase();
						if (answer.equals("Y")) {
							pandasor.get(0).setFrontNeighbour(new Orangutan());
							if (pandasor.get(0).isInQueue()) {
								System.out.println("Sorban vagyok he!");
							}
							Indent.printr("All mogotte panda a lancban? (Y / N)");
							answer = reader.readLine();
							answer = answer.toUpperCase();

							String innerAnswer;
							while (answer.equals("Y")) {
								Indent.printr("Milyen panda all mogotte? (P / TP / SP / JP)");
								innerAnswer = reader.readLine().toUpperCase();
								switch (innerAnswer) {
									case "P":
										pandasor.add(new Panda());
										break;
									case "TP":
										pandasor.add(new TiredPanda());
										break;
									case "SP":
										pandasor.add(new ScaredPanda());
										break;
									case "JP":
										pandasor.add(new JumpingPanda());
										break;
								}
								Indent.printr("All valami e mogott a panda mogott lancban? (Y / N)");
								answer = reader.readLine().toUpperCase();
							}
						}
						this.setElement(pandasor.get(0));
						pandasor.remove(0);
						Panda p = (Panda)element;
						while (!pandasor.isEmpty()) {
							p.backNeighbour = pandasor.get(0);
							pandasor.remove(0);
							p = p.backNeighbour;
						}

						break;
					case "W":
						this.setElement(new Wardrobe());
						break;
					case "N":
						this.setElement(null);
						break;
					default:
						this.setElement(null);
				}

			} catch (IOException e) {
				Indent.print("Valami szornyu valaszt adhattal meg, ezert a rendszer osszeomlott.");
				e.printStackTrace();
			}
		}

		Indent.inc();
		if (life < 1) {
			a.die();
			Indent.dec();
			return false;
		}
		if (element == null) {
			Indent.dec();
			return true;
		} else {
			Indent.dec();
			return a.collideWith(element);
		}
	}

	/**
	 * Csokkenti a mezo eletet.
	 *
	 * @param i Mennyi elet tunjon
	 * @return true-val ter vissza, ha eltort a csempe, kulonben false
	 */
	public boolean lifeDecrease(int i) {
		Indent.print("BreakableTile lifeDecrease()");
		Indent.inc();
		life -= i;
		Indent.dec();
		if (life <= 0) return true;
		return false;
	}

	/**
	 * Leszedi az allatot magarol, es meghivja a lifeDecrease fuggvenyt.
	 */
	public void remove(Animal a) {
		Indent.print("BreakableTile remove()");
		Indent.inc();
		lifeDecrease(1);
		element = null;
		Indent.dec();
	}

	/**
	 * Visszaadja, hany elete van a csempenek
	 *
	 * @return a csempe elete
	 */
	public int getLife() {
		Indent.print("BreakableTile getLife()");
		return life;
	}

	/**
	 * Kiprinteli standard outputra vagy egy fajlba az objektum allapotat.
	 */
	@Override
	public void printStats() {
		Printer.printName(name);
		Printer.print("life: " + life);
		Printer.print("isJingling: " + isJingling);
		Printer.print("isWhistling: " + isWhistling);
		Printer.print("Element: " + element);
		for (int i = 0; i < neighbours.size(); i++) {
			Printer.print("neighbour" + (i+1) + ": " + neighbours.get(i).getName());
		}
		for (int i = 0; i < neighbouringArmchairs.size(); i++) {
			Printer.print("neighbouringArmchair" + (i+1) + ": " + neighbouringArmchairs.get(i).getName());
		}
	}
}