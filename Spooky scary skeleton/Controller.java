package main;

import java.util.ArrayList;

public class Controller {
	private ArrayList<Steppable> steppables = new ArrayList<>();
	private ArrayList<Panda> pandas = new ArrayList<>();
	private ArrayList<Orangutan> orangutans = new ArrayList<>();
	
	public void tick() {
		Indent.print("Controller tick()");
		Indent.inc();
		Game game = new Game();
			if(game.hasEnded()) {
				game.endGame();
			} else {
				for (int i = 0; i< 3; i++) {
					for(Orangutan o: orangutans) {
						o.step();
					}
				}
				for(Panda p: pandas) {
					p.step();
				}
				for(Steppable s: steppables) {
					s.step();
				}
			}
		Indent.dec();
	}
	
	public void addPanda(Panda p) {
		Indent.print("Controller addPanda(Panda)");
		pandas.add(p);
	}
	public void addOrangutan(Orangutan o) {
		Indent.print("Controller addOrangutan(Orangutan)");
		orangutans.add(o);
	}
	public void addSteppable(Steppable s) {
		steppables.add(s);
	}
}
