package skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Question {
	public static Tile selectTileQuestions() {
    	Indent.printr("Milyen csempere akarsz lepni? (T / BT / G)");
		BufferedReader reader =  
                new BufferedReader(new InputStreamReader(System.in)); 
		try {
			String answer = reader.readLine();
			answer = answer.toUpperCase();
			switch(answer) {
			case "T":  return new Tile();
			case "BT":  return new BreakableTile(10);
			case "G":  return new BreakableTile(0);
			default:  return new Tile();
			}
			
		} catch (IOException e) {
			Indent.print("Valami szornyu valaszt adhattal meg, ezert a rendszer osszeomlott.");
			e.printStackTrace();
		} 
		return new Tile();
    }
	//Panda isInQueue reszenel hivodik meg
    public static void queueQuestions(Panda gp) {
		Indent.printr("All mogotted panda? (P / TP / SP / JP / N)");
		ArrayList<Panda> pandasor = new ArrayList<>();
		
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
		try {
			String answer = reader.readLine().toUpperCase();
			while(!answer.equals("N")) {
				switch(answer) {
						case "P": pandasor.add(new Panda(false)); break;
						case "TP": pandasor.add(new TiredPanda(false)); break;
						case "SP": pandasor.add(new ScaredPanda(false)); break;
						case "JP": pandasor.add(new JumpingPanda(false)); break;
					}
				Indent.printr("All mogotte masik panda? (P / TP / SP / JP / N)");
				answer = reader.readLine().toUpperCase();
			}
			if(!pandasor.isEmpty()) {
				Panda p = gp;
				while(!pandasor.isEmpty()) {
					p.setBackNeighbour(pandasor.get(0));
					pandasor.get(0).setFrontNeighbour(p);
					p = pandasor.get(0);
					pandasor.remove(0);
				}
			}
			
		} catch (IOException e) {
			Indent.print("Valami szornyu valaszt adhattal meg, ezert a rendszer osszeomlott.");
			e.printStackTrace();
		} 
    }
	public static void acceptQuestions(Animal a, Tile gt) {
		Indent.printr("All valami a mezon, amire lepni szeretnel? (A / ED / XD / CM / GM / O / P / N / W)");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		try {
			String answer = reader.readLine();
			answer = answer.toUpperCase();
			switch(answer) {
			case "A": 
				Armchair ac = new Armchair();
				gt.setElement(ac);
				Indent.printr("Foglalt a fotel? (Y / N)");
				if(reader.readLine().toUpperCase().equals("Y")) {
					TiredPanda np = new TiredPanda();
					np.setArmchair(ac);
				} 
				
			break;
			case "ED": gt.setElement(new EntryDoor());
			break;
			case "XD": gt.setElement(new ExitDoor()); //XDDDDDD
			break;
			case "CM": gt.setElement(new ChocolateMachine());
			break;
			case "GM": gt.setElement(new GameMachine());
			break;
			case "O": gt.setElement(new Orangutan());
			break;
			case "P": 
				ArrayList<Panda> pandasor = new ArrayList<>();
				Indent.printr("Milyen fajta panda? (P / TP / SP / JP)");
				answer = reader.readLine().toUpperCase();
				switch (answer) {
				case "P": pandasor.add(new Panda(false)); break;
				case "TP": pandasor.add(new TiredPanda(false)); break;
				case "SP": pandasor.add(new ScaredPanda(false)); break;
				case "JP": pandasor.add(new JumpingPanda(false)); break;
				}
				gt.setElement(pandasor.get(0));
				Indent.printr("A panda resze-e lancnak? (Y / N)");
				answer = reader.readLine(); answer = answer.toUpperCase();
				if(answer.equals("Y")) {
					pandasor.get(0).setFrontNeighbour(new Orangutan());

					Indent.printr("All mogotte panda a lancban? (Y / N)");
					answer = reader.readLine(); answer = answer.toUpperCase();
					
					String innerAnswer;
					while(answer.equals("Y")) {
						Indent.printr("Milyen panda all mogotte? (P / TP / SP / JP)");
						innerAnswer = reader.readLine().toUpperCase();
						switch (innerAnswer) {
							case "P": pandasor.add(new Panda(false)); break;
							case "TP": pandasor.add(new TiredPanda(false)); break;
							case "SP": pandasor.add(new ScaredPanda(false)); break;
							case "JP": pandasor.add(new JumpingPanda(false)); break;
						}
						Indent.printr("All valami e mogott a panda mogott lancban? (Y / N)");
						answer = reader.readLine().toUpperCase();
					}
				}
				pandasor.remove(0);
				Panda p = (Panda) gt.element;
				if(!pandasor.isEmpty())pandasor.get(0).setFrontNeighbour((Animal)gt.element);
				while(!pandasor.isEmpty()) {
					p.backNeighbour = pandasor.get(0);
					pandasor.get(0).setFrontNeighbour(p.backNeighbour);
					p = p.backNeighbour;
					pandasor.remove(0);
					
					
				}
				
				break;
			case "W": gt.setElement(new Wardrobe());
			break;
			case "N": gt.setElement(null);
			break;
			default: gt.setElement(null);			
			}

		} catch (IOException e) {
			Indent.print("Valami szornyu valaszt adhattal meg, ezert a rendszer osszeomlott.");
			e.printStackTrace();
		} 
	}
public static void orangutanQueueQuestions(Orangutan go) {
	Indent.printr("All mogotted panda? (P / TP / SP / JP / N)");
	ArrayList<Panda> pandasor = new ArrayList<>();
	
	BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
	try {
		String answer = reader.readLine().toUpperCase();
		while(!answer.equals("N")) {
			switch(answer) {
					case "P": pandasor.add(new Panda(false)); break;
					case "TP": pandasor.add(new TiredPanda(false)); break;
					case "SP": pandasor.add(new ScaredPanda(false)); break;
					case "JP": pandasor.add(new JumpingPanda(false)); break;
				}
			Indent.printr("All mogotte masik panda? (P / TP / SP / JP / N)");
			answer = reader.readLine().toUpperCase();
		}
		if(!pandasor.isEmpty()) {
			go.setBackNeighbour(pandasor.get(0));
			pandasor.remove(0);
			Panda p = go.getBackNeighbour();
			while(!pandasor.isEmpty()) {
				p.backNeighbour = pandasor.get(0);
				pandasor.remove(0);
				p = p.backNeighbour;
			}
		}
		
	} catch (IOException e) {
		Indent.print("Valami szornyu valaszt adhattal meg, ezert a rendszer osszeomlott.");
		e.printStackTrace();
	} 
}
}
