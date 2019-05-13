package skeleton;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Placeholder extends Tile{

	public void draw(JLabel label, JLabel element) {
		ImageIcon image = new ImageIcon("tile.png");
		label.setIcon(image);
		label.setIcon(new ImageIcon("empty.png"));
		element.setIcon(new ImageIcon("empty.png"));
	}

}
