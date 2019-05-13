package skeleton;

import java.awt.Color;

import javax.swing.*;

/**
 *
 */
public class Armchair extends Element {

	/**
	 * Default constructor
	 */
	public Armchair() {
	}

	public void setOccupied(boolean occupied) {
		isOccupied = occupied;
	}

	private boolean isOccupied;

	/**
	 * Megmutatja, foglalt-e a fotel
	 *
	 * @return foglalt-e
	 */
	public boolean getIsOccupied() {
		return isOccupied;
	}


	/**
	 * Jelzi, hogy az orangutan nem utkozhet a fotellal.
	 *
	 * @param o orangutan
	 * @return hamis (nem utkozhet)
	 */
	public boolean hitBy(Orangutan o) {
		return false;
	}

	/**
	 * Jelzi, hogy a panda nem utkozhet a fotellal.
	 *
	 * @param p panda
	 * @return hamis (nem utkozhet)
	 */
	public boolean hitBy(Panda p) {
		return false;
	}

	/**
	 * Megmutatja, hogy a fotelnak utkozhet-e egy elem
	 *
	 * @param e elem
	 * @return false (nem utkozhet)
	 */
	public boolean collideWith(Element e) {
		return false;
	}

	/**
	 * Kiprinteli standard outputra vagy egy fajlba az objektum allapotat.
	 */
	public void printStats() {
		Printer.printName(name);
		Printer.print("position: " + position.getName());
		Printer.print("isOccupied: " + isOccupied);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(JLabel label) {
		label.setIcon(new ImageIcon("ac.png"));
		if (isOccupied) label.setIcon(new ImageIcon("acs.png"));
	}

	@Override
	public Color getLineColor() {
		// TODO Auto-generated method stub
		return null;
	}


}