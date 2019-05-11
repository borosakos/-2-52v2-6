package skeleton;


public class Main {

	public static void main(String[] args) {
		
		Interpreter interp = new Interpreter(Controller.game.board);
		interp.getCommands();

	}

}
