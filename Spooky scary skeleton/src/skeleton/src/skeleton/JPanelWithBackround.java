package skeleton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Ez az osztaly egy tovabb fejlesztett JPanel, amely kepes hatterkepkent
 * kepet megjeleniteni.
 *
 * @author Boros Akos
 * @version 1.0
 */
@SuppressWarnings("serial")
public class JPanelWithBackround extends JPanel {
	private Image backroundImage;

	public JPanelWithBackround() {
		readImage();
		backroundImage = backroundImage.
				getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH);
	}

	private void readImage() {
		try {
			backroundImage = ImageIO.read(new File("menu.png"));
		} catch (IOException e) {
			System.out.println("A menu.png fajl nem letezik.");
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backroundImage, 0, 0, this);
	}

}
