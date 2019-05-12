package skeleton;

import javax.swing.*;
import java.awt.Graphics;
import java.util.ArrayList;

public class WebPanel extends JPanel {

	public ArrayList<Line> lines;

	public WebPanel(ArrayList<Line> plswork) {
		lines = new ArrayList<>(plswork);
	}

	public void update(ArrayList<Line> plswork) {
		lines = plswork;
	}

	@Override
	protected void paintComponent(Graphics g) {
		System.out.printf("asd");
		super.paintComponent(g);
		for (Line line : lines) {
			g.drawLine(line.start.x, line.start.y, line.end.x, line.end.y);
		}
	}
}