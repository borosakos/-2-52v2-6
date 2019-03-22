package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) {
		System.out.println("*******Panda teszter 2000********");
		System.out.println();
		System.out.println("Üdvözlünk életed lejgobb szkeleton progijában!");
		System.out.println("A teszteléshez írj egy 'S' betűt, vagy kilépéshez egy 'Q'-t!");
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
		Game game = new Game();
		Controller controller = game.controller;
		Board board = game.board;
		Indent.print("Mivel szeretnél lépni? (O / P / TP / SP / JP)");
		answer=reader.readLine().toUpperCase();
		
		switch (answer) {
		case "O": Orangutan o = new Orangutan(); controller.addOrangutan(o); break;
		case "P": Panda p = new Panda(); controller.addPanda(p); break;
		case "TP": TiredPanda tp = new TiredPanda(); controller.addPanda(tp); break;
		case "SP": ScaredPanda sp = new ScaredPanda(); controller.addPanda(sp); break;
		case "JP": JumpingPanda jp = new JumpingPanda(); controller.addPanda(jp); break;
		}
		
		Indent.print("Van-e tulajdonsága a mezőnek, amin állsz?  (JT / WT / TT / N)");
		answer=reader.readLine().toUpperCase();
		Tile position;
		switch(answer) {
		case "JT": position = new Tile(true, false, null); board.addTile(position);  break;
		case "WT": board.addTile(new Tile(false, true, null)); break;
		case "TT": board.addTile(new Tile(false, false, new Armchair())); break;
		case "N": board.addTile(new Tile()); break;
		default: board.addTile(new Tile()); break;
		}
		
	}

}
