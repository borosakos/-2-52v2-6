package skeleton;

public class Game {
	public Controller controller;
	public Board board;
	boolean end = false;
	Game(){
		controller = new Controller();
		board = new Board();
	}
	public void endGame() {
		Indent.print("Game endGame()");
		end = true;
		System.exit(0);
	}
	public void startGame() {
		Indent.print("Game startGame()");
		Indent.inc();
		//while(!this.hasEnded()) {
			controller.tick();
		//}
		Indent.dec();
	}
	public boolean hasEnded() {
		Indent.print("Game hasEnded()");
	//	if(Controller.getPandas().isEmpty() || Controller.getOrangutans().isEmpty()) {
	//		end  = true;
	//	}
		return end;
	}
}
