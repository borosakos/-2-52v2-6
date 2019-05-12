package skeleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Interpreter {
	private Board board;

	Interpreter(Board given) {
		board = given;
	}

	void getCommands() {
		Scanner sc = new Scanner(System.in);
		String cmd = sc.nextLine().toLowerCase();

		String[] cmdParts = cmd.split(" ");

		Printer.setStandardOutput();
		//Ha command linerol olvasunk
		while (!cmdParts[0].equals("exit") && !cmdParts[0].equals("file")) {
			handleCommand(cmdParts);
			cmd = sc.nextLine().toLowerCase();
			cmdParts = cmd.split(" ");
		}

		//Ha fajlbol olvasunk
		if (cmdParts[0].equals("file")) {
			String inFile = "", outFile = "";
			while (true) {
				board = new Board();
				Controller.reset();
				Indent.print("Ird be az input fajl nevet:");
				sc = new Scanner(System.in);
				inFile = sc.nextLine();
				if (inFile.equals("exit")) break;
				Indent.print("Ird be az output fajl nevet:");
				outFile = sc.nextLine();
				if (outFile.equals("exit")) break;
				Printer.setFile(outFile);

				try {
					sc = new Scanner(new File(inFile));
					String fileCmd;
					while ((sc.hasNextLine())) {
						fileCmd = sc.nextLine();
						cmdParts = fileCmd.split(" ");
						handleCommand(cmdParts);

					}
				} catch (FileNotFoundException e) {
					Indent.print("Fajl nem letezik, probald ujra.");
				}
				Printer.flushFile();
			}
			Printer.closeFile();
		}
	}

	private void handleCommand(String[] cmdParts) {
		switch (cmdParts[0]) {
			case "tile":
				handleTile(cmdParts);
				break;
			case "btile":
				handleBTile(cmdParts);
				break;
			case "orangutan":
				handleOrangutan(cmdParts);
				break;
			case "panda":
				handlePanda(cmdParts);
				break;
			case "tpanda":
				handleTPanda(cmdParts);
				break;
			case "spanda":
				handleSPanda(cmdParts);
				break;
			case "jpanda":
				handleJPanda(cmdParts);
				break;
			case "gamemachine":
				handleGM(cmdParts);
				break;
			case "chocolatemachine":
				handleCM(cmdParts);
				break;
			case "armchair":
				handleAC(cmdParts);
				break;
			case "doors":
				handleDoors(cmdParts);
				break;
			case "wardrobe":
				handleWD(cmdParts);
				break;
			case "stats":
				handleStats(cmdParts);
				break;
			case "release":
				handleRelease(cmdParts);
				break;
			case "step":
				handleStep(cmdParts);
				break;
			case "random":
				Controller.setRandom(!Controller.getRandom());
				if (Controller.getRandom()) Indent.print("Turning randomization on");
				if (!Controller.getRandom()) Indent.print("Turning randomization off");
				break;
			case "jingle":
				handleJingle(cmdParts);
				break;
			case "whistle":
				handleWhistle(cmdParts);
				break;
			case "queue":
				handleQueue(cmdParts);
				break;
			case "compare":
				handleCompare(cmdParts);
				break;
			case "compareall":
				handleCompareAll(cmdParts);
				break;
			case "color":
				handleColor(cmdParts);
				break;
			case "start":
				try {
					Scanner sc = new Scanner(new File("palya.txt"));
					String fileCmd;
					while ((sc.hasNextLine())) {
						fileCmd = sc.nextLine();
						cmdParts = fileCmd.split(" ");
						handleCommand(cmdParts);
					}
				} catch (FileNotFoundException e) {
					Indent.print("Fajl nem letezik, probald ujra.");
				}
				Controller.setRandom(true);
				if (Controller.getRandom()) Indent.print("Turning randomization on");
				Controller.gameOn = true;
				Controller.game = new Game(board);
				Controller.graphics.showGame();
				Controller.game.startGame();

				break;
		}
	}

	private void handleColor(String[] cmd) {
		Orangutan current = Controller.getOrangutan(cmd[1]);
		current.setColor(Float.parseFloat(cmd[2]), Float.parseFloat(cmd[3]), Float.parseFloat(cmd[4]), Float.parseFloat(cmd[5]));
	}

	private void handleTile(String[] cmd) {
		Tile t = board.getTByName(cmd[1]);
		if (t == null) {
			t = new Tile(cmd[1]);
			board.addTile(t);
		}
		t.removeNeighbours();
		if (cmd.length < 1) return;
		for (int i = 2; i < cmd.length; i++) {
			Tile tempTile = board.getTByName((cmd[i]));
			t.addNeighbour(tempTile);
			tempTile.addNeighbour(t);
		}
	}

	void handleStats(String[] cmd) {
		if (cmd.length == 1) { //ha nincs parameter
			for (Tile t : board.getTiles()) {
				t.printStats();
				if (t.getElement() != null) {
					t.getElement().printStats();
				}
			}
		} else {
			Steppable s = Controller.getSteppable(cmd[1]);
			if (s != null) {
				s.printStats();
			}
			Element e = Controller.getElement(cmd[1]);
			if (e != null) {
				e.printStats();
			}
			Tile t = board.getTByName(cmd[1]);
			if (t != null) {
				t.printStats();
			}
			if (t == null && e == null && s == null) Indent.print("No object with name " + cmd[1] + " was found.");
		}
	}

	private void handleBTile(String[] cmd) {
		if (cmd.length < 3) {
			Indent.print("No life/name given!");
			return;
		}
		BreakableTile t = (BreakableTile)board.getTByName(cmd[2]);
		if (t == null) {
			t = new BreakableTile(cmd[2], Integer.parseInt(cmd[1]));
			board.addTile(t);
		}
		t.removeNeighbours();
		if (cmd.length < 2) return;
		for (int i = 3; i < cmd.length; i++) {
			Tile tempTile = board.getTByName((cmd[i]));
			t.addNeighbour(tempTile);
			tempTile.addNeighbour(t);
		}
	}

	private void handleOrangutan(String[] cmd) {
		if (orangutanCheck(cmd)) return;
		Orangutan o = new Orangutan();
		o.setName(cmd[1]);
		Tile t = board.getTByName(cmd[2]);
		t.setElement(o);
		Controller.getOrangutans().add(o);
	}

	private void handlePanda(String[] cmd) {
		if (pandaCheck(cmd)) return;
		Panda p = new Panda();
		p.setName(cmd[1]);
		Tile t = board.getTByName(cmd[2]);
		t.setElement(p);
		Controller.getPandas().add(p);
	}

	private void handleTPanda(String[] cmd) {
		if (pandaCheck(cmd)) return;
		TiredPanda p = new TiredPanda();
		p.setName(cmd[1]);
		Tile t = board.getTByName(cmd[2]);
		t.setElement(p);
		Controller.getPandas().add(p);
	}

	private void handleSPanda(String[] cmd) {
		if (pandaCheck(cmd)) return;
		ScaredPanda p = new ScaredPanda();
		p.setName(cmd[1]);
		Tile t = board.getTByName(cmd[2]);
		t.setElement(p);
		Controller.getPandas().add(p);
	}

	private void handleJPanda(String[] cmd) {
		if (pandaCheck(cmd)) return;
		JumpingPanda p = new JumpingPanda();
		p.setName(cmd[1]);
		Tile t = board.getTByName(cmd[2]);
		t.setElement(p);
		Controller.getPandas().add(p);
	}

	private void handleGM(String[] cmd) {
		if (steppableCheck(cmd)) return;
		GameMachine gm = new GameMachine();
		gm.setName(cmd[1]);
		Tile t = board.getTByName(cmd[2]);
		t.setElement(gm);
		Controller.getSteppables().add(gm);
	}

	private void handleCM(String[] cmd) {
		if (steppableCheck(cmd)) return;
		ChocolateMachine gm = new ChocolateMachine();
		gm.setName(cmd[1]);
		Tile t = board.getTByName(cmd[2]);
		t.setElement(gm);
		Controller.getSteppables().add(gm);
	}

	private void handleAC(String[] cmd) {
		if (elementCheck(cmd)) return;
		Armchair gm = new Armchair();
		gm.setName(cmd[1]);
		Tile t = board.getTByName(cmd[2]);
		t.setElement(gm);
		ArrayList<Tile> szomszedok = t.getNeighbours();
		for (Tile ti : szomszedok) {
			ti.neighbouringArmchairs.add(gm);
		}
		Controller.getElements().add(gm);
	}

	private void handleRelease(String[] cmd) {
		if (cmd.length < 1) {
			Indent.print("No orangutan was given.");
			return;
		}
		for (Orangutan o : Controller.getOrangutans()) {
			if (o.name.equals(cmd[1])) {
				o.release();
				return;
			}
		}
		Indent.print("No orangutan with name " + cmd[1] + " found.");
	}

	private void handleDoors(String[] cmd) {
		if (cmd.length < 6) {
			Indent.print("Parameters are missing.");
			return;
		}
		if (Controller.hasElement(cmd[1])) {
			Indent.print("Element already exists with given name.");
			return;
		}
		if (Controller.hasElement(cmd[4])) {
			Indent.print("Element already exists with given name.");
			return;
		}
		Tile e1 = board.getTByName(cmd[2]);
		if (e1 == null) {
			Indent.print("No tile with name " + cmd[2] + " was found.");
			return;
		}
		if (e1.getElement() != null) {
			Indent.print("Tile with name " + cmd[2] + " already has an element.");
			return;
		}
		Tile e2 = board.getTByName(cmd[3]);
		if (e2 == null) {
			Indent.print("No tile with name " + cmd[3] + " was found.");
			return;
		}

		Tile x1 = board.getTByName(cmd[5]);
		if (x1 == null) {
			Indent.print("No tile with name " + cmd[5] + " was found.");
			return;
		}
		if (x1.getElement() != null) {
			Indent.print("Tile with name " + cmd[5] + " already has an element.");
			return;
		}
		Tile x2 = board.getTByName(cmd[6]);
		if (x2 == null) {
			Indent.print("No tile with name " + cmd[6] + " was found.");
			return;
		}
		if (x1.equals(x2) || x1.equals(e1) || x1.equals(e2) || x2.equals(e1) || x2.equals(e2) || e1.equals(e2)) {
			Indent.print("This positioning is not possible due to tile confluence.");
			return;
		}
		EntryDoor ed = new EntryDoor();
		ed.setName(cmd[1]);
		ExitDoor xd = new ExitDoor();
		xd.setName(cmd[4]);
		e1.setElement(ed);
		ed.setDoorTile(e2);
		ed.setOther(xd);
		x1.setElement(xd);
		xd.setDoorTile(x2);
		xd.setOther(ed);
		Controller.getElements().add(ed);
		Controller.getElements().add(xd);
	}

	private void handleWD(String[] cmd) {
		if (cmd.length < 2) {
			Indent.print("No name given.");
			return;
		}
		if (cmd.length < 3) {
			Indent.print("No tile given as position.");
			return;
		}
		if (cmd.length < 4) {
			Indent.print("No door tile given.");
			return;
		}
		if (cmd[1].equals("connect")) {
			Wardrobe w1 = Controller.getWardrobe(cmd[2]);
			Wardrobe w2 = Controller.getWardrobe(cmd[3]);
			w1.setEnd(w2);
			w2.setEnd(w1);
			return;
		}
		Tile t = board.getTByName(cmd[2]);

		if (t == null) {
			Indent.print("No tile with name " + cmd[2] + " found.");
			return;
		}
		Tile dt = board.getTByName(cmd[3]);

		if (dt == null) {
			Indent.print("No tile with name " + cmd[3] + " found for door tile.");
			return;
		}

		Wardrobe w = Controller.getWardrobe(cmd[1]);
		if (w == null) {
			w = new Wardrobe(cmd[1]);
			Controller.getWardrobes().add(w);
		}
		t.setElement(w);
		w.setDoorTile(dt);

		if (5 <= cmd.length) {
			if (Controller.getRandom()) {
				Indent.print("Setting end point is not allowed as randomization is currently turned on.");
			} else {
				if (!Controller.hasWardrobe(cmd[4])) {
					Indent.print("Wardrobe with name " + cmd[4] + " does not exist.");
					return;
				}
				w.setEnd(Controller.getWardrobe(cmd[4]));
			}
		}
		for (Wardrobe ward : Controller.getWardrobes()) {
			ward.resetOtherWardrobes();
		}
	}

	private void handleStep(String[] cmd) {
		if (cmd.length <= 1) {
			Indent.print("No object given.");
		}
		Steppable s = Controller.getSteppable(cmd[1]);
		if (s == null) {
			Indent.print("No object with name " + cmd[1] + " was found.");
			return;
		}
		Tile t = board.getTByName(cmd[2]);
		if (t == null) {
			Indent.print("No tile with name " + cmd[2] + " was found.");
		}
		boolean neighbourFound = false;
		ArrayList<Tile> neighbours = s.getTile().getNeighbours();
		for (Tile n : neighbours) {
			if (n.name.equals(cmd[2])) neighbourFound = true;
		}
		if (!neighbourFound) {
			Indent.print("No neighbouring tile with name " + cmd[2] + " was found.");
			return;
		}
		if (!Controller.getRandom()) {
			if (cmd.length <= 2) {
				Indent.print("No tile given.");
				return;
			}
		} else {
			if (cmd.length >= 3) {
				Indent.print("As randomization is currently turned on, the tile given will not be used (except for Orangutans).");
			}
		}
		s.step(t);

	}

	private void handleQueue(String[] cmd) {
		Orangutan o = null;
		Panda p = null;
		for (Orangutan oc : Controller.getOrangutans()) {
			if (oc.name.equals(cmd[1])) {
				o = oc;
			}
		}
		for (Panda oc : Controller.getPandas()) {
			if (oc.name.equals(cmd[1])) {
				p = oc;
			}
		}
		if (o != null) {
			Orangutan o2 = null;
			for (Orangutan oc : Controller.getOrangutans()) {
				if (oc.name.equals(cmd[2])) {
					o2 = oc;
				}
			}
			if (o2 != null) {
				Indent.print("Queueing two orangutans is not allowed.");
				return;
			}
			Panda p2 = null;
			for (Panda oc : Controller.getPandas()) {
				if (oc.name.equals(cmd[2])) {
					p2 = oc;
				}
			}
			if (p2 == null) {
				Indent.print("Panda with name " + cmd[2] + " not found.");
				return;
			}
			if (!o.position.isNeighbour(p2.position)) {
				Indent.print("The two animals are not on neighbouring tiles.");
				return;
			}
			o.setBackNeighbour(p2);
			p2.setFrontNeighbour(o);
			return;
		}
		if (p != null) {
			Orangutan o2 = null;
			for (Orangutan oc : Controller.getOrangutans()) {
				if (oc.name.equals(cmd[2])) {
					o2 = oc;
				}
			}
			if (o2 != null) {
				Indent.print("Queueing orangutan after panda is not allowed.");
				return;
			}
			Panda p2 = null;
			for (Panda oc : Controller.getPandas()) {
				if (oc.name.equals(cmd[2])) {
					p2 = oc;
				}
			}
			if (p2 == null) {
				Indent.print("Panda with name " + cmd[2] + " not found.");
				return;
			}
			if (!p.position.isNeighbour(p2.position)) {
				Indent.print("The two animals are not on neighbouring tiles.");
				return;
			}
			p.setBackNeighbour(p2);
			p2.setFrontNeighbour(p);
		}

	}

	private void handleJingle(String[] cmd) {
		try {
			GameMachine gm = (GameMachine)Controller.getSteppable(cmd[1]);
			if (gm == null) {
				Indent.printr("No game machine with name " + cmd[1] + " was found.");
				return;
			}
			gm.jingle();
		} catch (Exception e) {
			Indent.print("Only game machines can jingle.");
		}
	}

	private void handleWhistle(String[] cmd) {
		try {
			ChocolateMachine gm = (ChocolateMachine)Controller.getSteppable(cmd[1]);
			if (gm == null) {
				Indent.printr("No chocolate machine with name " + cmd[1] + " was found.");
				return;
			}
			gm.whistle();
		} catch (Exception e) {
			Indent.print("Only chocolate machines can whistle.");
		}
	}

	private void handleCompare(String[] cmd) {
		try {
			FileReader outputFile = new FileReader(cmd[1]);
			FileReader testFile = new FileReader(cmd[2]);
			Scanner outputRead = new Scanner(outputFile);
			Scanner testRead = new Scanner(testFile);
			String outputString = outputRead.nextLine();
			String testString = testRead.nextLine();
			int i = 0;
			int hiba = 0;
			while (outputRead.hasNextLine() && testRead.hasNextLine()) {
				if (!outputString.equals(testString)) {
					Indent.print("--------\n\n" + (i + 1) + ". sor: \nTeszt:\t" + testString + "\nOutput:\t" + outputString + "\n");
					hiba++;
				}
				i++;
				outputString = outputRead.nextLine();
				testString = testRead.nextLine();
			}
			if ((outputRead.hasNextLine() && !testRead.hasNextLine()) || (!outputRead.hasNextLine() && testRead.hasNextLine())) {
				Indent.print("A sorok szama kulonbozik!");
			}
			if (hiba == 0) {
				Indent.print("A teszt hiba nelkul lefutott.");
			} else {
				Indent.print("A hibak szama: " + hiba);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Indent.print("Valamelyik fajl nem talalhato, probald ujra.");
		}
	}

	private void handleCompareAll(String[] cmd) {
		int testFileCount = 37;
		if (cmd.length > 1) {
			testFileCount = Integer.parseInt(cmd[1]);
		}


		for (int i = 0; i < testFileCount; i++) {
			Printer.setFile("tesztek/tempFile.txt");
			try {
				Scanner sc = new Scanner(new File("tesztek/testInput" + (i + 1) + ".txt"));
				String fileCmd;
				while ((sc.hasNextLine())) {
					fileCmd = sc.nextLine();
					String[] cmdParts = fileCmd.split(" ");
					handleCommand(cmdParts);
				}
			} catch (FileNotFoundException e) {
				Indent.print("Fajl nem letezik, probald ujra.");
			}
			resetGame();
			Printer.closeFile();
			System.out.println((i + 1) + ". teszt:");
			String[] command = {"compare", "tesztek/tempFile.txt", "tesztek/testOutput" + (i + 1) + ".txt"};
			handleCompare(command);
		}
	}

	/*Checker functions*/
	private boolean orangutanCheck(String[] cmd) {
		if (cmd.length < 3) {
			Indent.print("Missing parameters.");
			return true;
		}
		if (Controller.hasOrangutan(cmd[1])) {
			Indent.print("Orangutan already exists with given name.");
			return true;
		}
		Tile t = board.getTByName(cmd[2]);
		if (t == null) {
			Indent.print("Tile with name " + cmd[2] + " does not exist.");
			return true;
		}
		if (t.getElement() != null) {
			Indent.print("Tile already has something on it.");
			return true;
		}
		return false;
	}

	private boolean pandaCheck(String[] cmd) {
		if (cmd.length < 3) {
			Indent.print("Missing parameters.");
			return true;
		}
		if (Controller.hasPanda(cmd[1])) {
			Indent.print("Panda already exists with given name.");
			return true;
		}
		Tile t = board.getTByName(cmd[2]);
		if (t == null) {
			Indent.print("Panda with name " + cmd[2] + " does not exist.");
			return true;
		}
		if (t.getElement() != null) {
			Indent.print("Tile already has something on it.");
			return true;
		}
		return false;
	}

	private boolean steppableCheck(String[] cmd) {
		if (cmd.length < 3) {
			Indent.print("Missing parameters.");
			return true;
		}
		if (Controller.hasSteppable(cmd[1])) {
			Indent.print("Element already exists with given name.");
			return true;
		}
		Tile t = board.getTByName(cmd[2]);
		if (t == null) {
			Indent.print("Tile with name " + cmd[2] + " does not exist.");
			return true;
		}
		if (t.getElement() != null) {
			Indent.print("Tile already has something on it.");
			return true;
		}
		return false;
	}

	private boolean elementCheck(String[] cmd) {
		if (cmd.length < 3) {
			Indent.print("Missing parameters.");
			return true;
		}
		if (Controller.hasElement(cmd[1])) {
			Indent.print("Element already exists with given name.");
			return true;
		}
		Tile t = board.getTByName(cmd[2]);
		if (t == null) {
			Indent.print("Tile with name " + cmd[2] + " does not exist.");
			return true;
		}
		if (t.getElement() != null) {
			Indent.print("Tile already has something on it.");
			return true;
		}
		return false;
	}

	private void resetGame() {
		Controller.reset();
		board.reset();
		Controller.setRandom(true);
	}
}
