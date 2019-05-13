package skeleton;

import javax.swing.*;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Palyatopologia kirajzolasaert felelos osztaly
 **/
public class WebPanel extends JPanel {

	public ArrayList<Line> lines;
	public ArrayList<Color> colors;


	public WebPanel(ArrayList<Line> plswork,  ArrayList<Color> _colors) {
		lines = new ArrayList<>(plswork); colors = new ArrayList<>(_colors);
	}

	public void update(ArrayList<Line> plswork, ArrayList<Color> _colors) {
		lines = plswork; colors = _colors;
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
			for (int i = 0; i<lines.size(); i++) {
				Line line = lines.get(i);
				g.setColor(colors.get(i));
				Graphics2D g2 = (Graphics2D)g;
				if(colors.get(i).equals(Color.black)) {
					g2.setStroke(new BasicStroke(1));
				} else {
					g2.setStroke(new BasicStroke(3));
				}
				g2.drawLine(line.start.x, line.start.y, line.end.x, line.end.y);
			}
		} catch (Exception e) { }
	}
}