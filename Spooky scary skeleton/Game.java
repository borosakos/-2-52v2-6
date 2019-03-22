package skeleton;

public class Game {
	public Controller controller;
	public Board board;
	Game(){
		controller = new Controller();
		board = new Board();
	}
	public void endGame() {
		Indent.print("Game endGame()");
	}
	public void startGame() {
		Indent.print("Game endGame()");
		Indent.inc();
		while(!this.hasEnded()) {
			controller.tick();
		}
		Indent.dec();
	}
	public boolean hasEnded() {
		Indent.print("Game hasEnded()");
		return false;
	}
}
