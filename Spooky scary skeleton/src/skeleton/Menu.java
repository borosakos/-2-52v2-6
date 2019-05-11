package skeleton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Menu
 * A jatek elindulasakor es veget eresekor ez az ablak jelenik meg.
 * @author Boros Akos
 * @version 1.0
 */
public class Menu {
	private JFrame fMenu;
	private JPanelWithBackround pMenu;
	private JButton bNewGame;
	private JButton bExitGame;
	
	private final String TITLE = "Panda Mall - The Reckoning";
	private final String NEW_GAME = "New Game";
	private final String EXIT = "Exit";
	
	public Menu() {
		fMenu = new JFrame(TITLE);
		pMenu = new JPanelWithBackround();
		bNewGame = new JButton(NEW_GAME);
		bExitGame = new JButton(EXIT);
		initControllButtons();
		createActionListeners();
		setUpWindow();
	}
	
	private void initControllButtons() {	
		bNewGame.setBackground(Color.white);
		bNewGame.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		bNewGame.setFont(new Font("Arial", Font.BOLD, 16));
		
		bExitGame.setBackground(Color.white);
		bExitGame.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		bExitGame.setFont(new Font("Arial", Font.BOLD, 16));	
		
		bNewGame.setBounds(new Rectangle(10, 320, 180, 30));
		bExitGame.setBounds(new Rectangle(10, 365, 180, 30));
		
		pMenu.add(bNewGame);
		pMenu.add(bExitGame);
	}
	
	private void createActionListeners() {
		bNewGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				startNewGameClicked();
			}
		});
		
		bExitGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exitGameClicked();				
			}
		});
	}
	
	private void setUpWindow() {
		fMenu.setSize(new Dimension(500, 500));		
		pMenu.setLayout(null);
		fMenu.add(pMenu, BorderLayout.CENTER);
		fMenu.setResizable(false);
		fMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		fMenu.setVisible(true);
	}
	
	private void startNewGameClicked() {
		//TODO Innen kell inditani a jatekot.
	}
	
	private void exitGameClicked() {
		System.exit(0);
	}
}
