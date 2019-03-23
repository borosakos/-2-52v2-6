package skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
 */
public class BreakableTile extends Tile {

    public BreakableTile(int life) {
    	this.life = life;
    }

    public BreakableTile(boolean b, boolean c, Armchair ac, int life) {
		super(b, c, ac);
		this.life = life;
	}
    @Override
    public void take(Animal a) {
    	if(life<=0) {
    		a.die();
    	} else {
    		element = a;
    	}
    }

	/**
     * 
     */
    private int life=-1;
    private boolean broken;

    /**
     * @param a 
     * @return
     */
    public boolean accept(Animal a) { //Ez idk j�-e, megl�tjuk 
    	Indent.print("BreakableTile accept()");
    	if(life!=0) {
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
				switch(answer) {
				case "A": this.setElement(new Armchair());
				break;
				case "ED": this.setElement(new EntryDoor());
				break;
				case "XD": this.setElement(new ExitDoor()); //XDDDDDD
				break;
				case "CM": this.setElement(new ChocolateMachine());
				break;
				case "GM": this.setElement(new GameMachine());
				break;
				case "O": this.setElement(new Orangutan());
				break;
				case "P": 
					ArrayList<Panda> pandasor = new ArrayList<>();
					Indent.printr("Milyen fajta panda? (P / TP / SP / JP)");
					answer = reader.readLine().toUpperCase();
					switch (answer) {
					case "P": pandasor.add(new Panda()); break;
					case "TP": pandasor.add(new TiredPanda()); break;
					case "SP": pandasor.add(new ScaredPanda()); break;
					case "JP": pandasor.add(new JumpingPanda()); break;
					}
					Indent.printr("A panda resze-e lancnak? (Y / N)");
					answer = reader.readLine(); answer = answer.toUpperCase();
					if(answer.equals("Y")) {
						pandasor.get(0).setFrontNeighbour(new Orangutan());
						if(pandasor.get(0).isInQueue()) {
							System.out.println("Sorban vagyok he!");
						}
						Indent.printr("All mogotte panda a lancban? (Y / N)");
						answer = reader.readLine(); answer = answer.toUpperCase();
						
						String innerAnswer;
						while(answer.equals("Y")) {
							Indent.printr("Milyen panda all mogotte? (P / TP / SP / JP)");
							innerAnswer = reader.readLine().toUpperCase();
							switch (innerAnswer) {
								case "P": pandasor.add(new Panda()); break;
								case "TP": pandasor.add(new TiredPanda()); break;
								case "SP": pandasor.add(new ScaredPanda()); break;
								case "JP": pandasor.add(new JumpingPanda()); break;
							}
							Indent.printr("All valami e mogott a panda mogott lancban? (Y / N)");
							answer = reader.readLine().toUpperCase();
						}
					}
					this.setElement(pandasor.get(0));
					pandasor.remove(0);
					Panda p = (Panda) element;
					while(!pandasor.isEmpty()) {
						p.backNeighbour = pandasor.get(0);
						pandasor.remove(0);
						p = p.backNeighbour;
					}
					
					break;
				case "W": this.setElement(new Wardrobe());
				break;
				case "N": this.setElement(null);
				break;
				default: this.setElement(null);			
				}

			} catch (IOException e) {
				Indent.print("Valami szornyu valaszt adhattal meg, ezert a rendszer osszeomlott.");
				e.printStackTrace();
			} 
    	}

    	Indent.inc();
        if (life<1) {
        	a.die();
        	Indent.dec();
        	return false;
        }
		if (element == null) {
			Indent.dec();
			return true;
		}
		else {
			Indent.dec();
			return a.collideWith(element);
		}
    }

    /**
     * 
     */
    public void breakTile() { //Kell ez egy�ltal�n? reeee de ut�lom ezt az eg�sz diagramozgat�st annyival egy�rtelm�bb lett volna sim�n leprogramozni istenem
    	Indent.print("BreakableTile breakTile()");
    	Indent.inc();
        broken = true;
        Indent.dec();
    }

    /**
     * @param i 
     * @return
     */
    public boolean lifeDecrease(int i) {
    	Indent.print("BreakableTile lifeDecrease()");
    	Indent.inc();
        life -= i;
        Indent.dec();
        if (life <= 0) { breakTile(); return true; }
        return false;
    }

    /**
     * @param a
     */
    public void remove(Animal a) {
    	Indent.print("BreakableTile remove()");
    	Indent.inc();
        lifeDecrease(1);
        element = null;
        Indent.dec();
    }

    /**
     * @return
     */
    public int getLife() {
    	Indent.print("BreakableTile getLife()");
        return life;
    }

}