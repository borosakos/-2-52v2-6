package skeleton;

import java.awt.Color;

import javax.swing.*;

public interface IDrawable {
	public void draw();

	void draw(JLabel label);
	public Color getLineColor();
}
