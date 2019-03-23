package skeleton;

import java.util.ArrayList;

public  class Controller {
	private static ArrayList<Steppable> steppables = new ArrayList<>();
	private static ArrayList<Panda> pandas = new ArrayList<>();
	private static ArrayList<Orangutan> orangutans = new ArrayList<>();
	public static Game game = new Game();
	
	public void tick() {
		Indent.print("Controller tick()");
		Indent.inc();
			if(game.hasEnded()) {
				game.endGame(); return;
			} else {
				for (int i = 0; i< 3; i++) {
					for(Orangutan o: orangutans) {
						o.step();
						if(game.hasEnded()) {
							game.endGame(); Indent.dec(); break;
						}
					}
				}
				for(Panda p: pandas) {
					if(p.getIsAlive()) p.step();
					if(game.hasEnded()) {
						game.endGame(); Indent.dec(); return;
					}
				}
				for(Steppable s: steppables) {
					s.step();
					if(game.hasEnded()) {
						game.endGame(); Indent.dec(); return;
					}
				}
			}
		Indent.dec();
	}
	
	
	
	public static void addPanda(Panda p) {
		Indent.print("Controller addPanda(Panda)");
		pandas.add(p);
	}
	public static void addOrangutan(Orangutan o) {
		Indent.print("Controller addOrangutan(Orangutan)");
		orangutans.add(o);
	}
	public static void addSteppable(Steppable s) {
		steppables.add(s);
	}
	public static ArrayList<Orangutan> getOrangutans(){
		return orangutans;
	}
	public static ArrayList<Panda> getPandas(){
		return pandas;
	}
}
