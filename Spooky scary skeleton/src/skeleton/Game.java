package skeleton;

public class Game {
	public Board board;
	boolean end = false;

	Game() {
		board = new Board();
	}

	Game(Board _board) {
		board = _board;
	}

	public void endGame() {
		end = true;
		if(Controller.gameOn) {
		if(Controller.getOrangutans().size()<2) {
			Indent.print("\n-----------------------");
			Indent.print("The game has ended, due to a tragic event of an Orangutan's death.");
			Indent.print("-----------------------");
		}
		System.exit(0);
		}
	}

	public void startGame() {
		while (!this.hasEnded()) {
			Controller.tick();
		}
	}

	public boolean hasEnded() {
		//	if(Controller.getPandas().isEmpty() || Controller.getOrangutans().isEmpty()) {
		//		end  = true;
		//	}
		return end;
	}
}
