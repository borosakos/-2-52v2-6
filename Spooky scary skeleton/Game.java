package skeleton;

public class Game {
	public Controller controller;
	public Board board;
	boolean end = false;

	Game() {
		controller = new Controller();
		board = new Board();
	}

	public void endGame() {
		end = true;
	}

	public void startGame() {
		//while(!this.hasEnded()) {
		controller.tick();
		//}
	}

	public boolean hasEnded() {
		//	if(Controller.getPandas().isEmpty() || Controller.getOrangutans().isEmpty()) {
		//		end  = true;
		//	}
		return end;
	}
}
