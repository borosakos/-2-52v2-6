package skeleton;



public class Main {

	public static void main(String[] args) {
		System.out.println("*******Panda proto 2500********");
		System.out.println();
		System.out.println("Udvozlunk eleted legjobb prototype progijaban!");
		System.out.println("Add meg a parancsokat, es mi keszseggel kiszolgalunk (majdnem) mindent!");
		
		Game game = new Game();
		Interpreter interp = new Interpreter(game.board);
		interp.getCommands();
		
	}

}
