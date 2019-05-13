package skeleton;

import javax.swing.*;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Palyatopologia kirajzolasaert felelos osztaly
 **/
public class WebPanel extends JPanel {

	public ArrayList<Line> lines;

	public WebPanel(ArrayList<Line> plswork) {
		lines = new ArrayList<>(plswork);
	}

	public void update(ArrayList<Line> plswork) {
		lines = plswork;
	}

	/**
	 * Kirajzolja a palya topologiajat - ket csempe kozott pontosan akkor fut el, ha
	 * azok szomszedosak
	 **/
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(lines == null) return;
		
		try {
			for (Line line : lines) {
				g.drawLine(line.start.x, line.start.y, line.end.x, line.end.y);
			}
		} catch (Exception e) { }
	}
}