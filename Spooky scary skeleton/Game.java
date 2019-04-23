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
