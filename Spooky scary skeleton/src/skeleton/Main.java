package skeleton;

import java.applet.AudioClip;
import java.io.File;
import java.io.InputStream;






public class Main {

	public static void main(String[] args) {
		
	//	Menu menu = new Menu();
		Interpreter interp = new Interpreter(Controller.game.board);
		interp.getCommands();

	}

}
