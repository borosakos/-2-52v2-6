package skeleton;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		System.out.println("*******Panda teszter 2000********");
		System.out.println();
		System.out.println("Udvozlunk lifeed legjobb szklifeon progijaban!");
		System.out.println("A teszteleshez irj egy 'S' betut, vagy kilepeshez egy 'Q'-t!");
		BufferedReader reader =  
                new BufferedReader(new InputStreamReader(System.in)); 
		try {
		String choice = reader.readLine();
		
		while(choice.toUpperCase().equals("S")) {
			mainLoop();
			choice = reader.readLine();
		}
		} catch (Exception e){
			
		}
	}
	
	public static void mainLoop() throws Exception{
		BufferedReader reader =  
                new BufferedReader(new InputStreamReader(System.in)); 
		String answer;
		Game game = Controller.game;
		Board board = game.board;
		Indent.printr("Mivel szeretnel lepni? (O / P / TP / SP / JP)");
		answer=reader.readLine().toUpperCase();
		
		Animal jatekos;
		switch (answer) {
		case "O": Orangutan o = new Orangutan(); Controller.addOrangutan(o); jatekos = o; break;
		case "P": Panda p = new Panda(); Controller.addPanda(p);jatekos = p; break;
		case "TP": TiredPanda tp = new TiredPanda(); Controller.addPanda(tp); jatekos = tp; break;
		case "SP": ScaredPanda sp = new ScaredPanda(); Controller.addPanda(sp); jatekos = sp; break;
		case "JP": JumpingPanda jp = new JumpingPanda(); Controller.addPanda(jp); jatekos = jp; break;
		default: Orangutan ok = new Orangutan(); Controller.addOrangutan(ok); jatekos = ok;
		}
		
		Indent.printr("Van-e tulajdonsaga a mezonek, amin allsz?  (JT / WT / TT / N)");
		answer=reader.readLine().toUpperCase();
		Indent.printr("Torekeny csempen allsz?  (Y / N)");
		String answer2=reader.readLine().toUpperCase();
		
		int life = -1;
		switch(answer2) {
		case "Y": 
			Indent.printr("Mennyi lifee van?  (nullanal nagyobb egesz szam)");
			life =  Integer.parseInt(reader.readLine());
			break;
		case "N":
			life = -1;
			break;
		}
		
		
		
		
		Tile position;
		if(life==-1) {
		switch(answer) {
		case "JT": position = new Tile(true, false, null); board.addTile(position);  break;
		case "WT": position = new Tile(false, true, null); board.addTile(position); break;
		case "TT": position = new Tile(false, false, new Armchair()); board.addTile(position); break;
		case "N": position = new Tile(); board.addTile(position); break;
		default: position = new Tile(); board.addTile(position); break;
		}
		} else {
			switch(answer) {
			case "JT": position = new BreakableTile(true, false, null, life); board.addTile(position);  break;
			case "WT": position = new BreakableTile(false, true, null, life); board.addTile(position); break;
			case "TT": position = new BreakableTile(false, false, new Armchair(), life); board.addTile(position); break;
			case "N": position = new BreakableTile(life); board.addTile(position); break;
			default: position = new BreakableTile(life); board.addTile(position); break;
			}
		}
		position.setElement(jatekos);
		jatekos.setPosition(position);
		game.startGame();
		
		
		
	}

}
