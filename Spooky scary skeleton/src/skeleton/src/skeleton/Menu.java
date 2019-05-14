package skeleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Menu
 * A jatek elindulasakor es veget eresekor ez az ablak jelenik meg.
 *
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
	private Interpreter interp;

	/**
	 * Konstruktor
	 **/
	public Menu() {
		fMenu = new JFrame();
		this.fMenu = fMenu;
		fMenu = new JFrame(TITLE);
		pMenu = new JPanelWithBackround();
		bNewGame = new JButton(NEW_GAME);
		bExitGame = new JButton(EXIT);
		initControllButtons();
		createActionListeners();
		setUpWindow();
	}

	/**
	 * Inicializalja a fomenu gombjait
	 **/
	private void initControllButtons() {
		bNewGame.setBackground(Color.white);
		bNewGame.setOpaque(true);
		bNewGame.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		bNewGame.setFont(new Font("Arial", Font.BOLD, 16));
		
		bExitGame.setBackground(Color.white);
		bExitGame.setOpaque(true);
		bExitGame.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		bExitGame.setFont(new Font("Arial", Font.BOLD, 16));

		bNewGame.setBounds(new Rectangle(10, 320, 180, 30));
		bExitGame.setBounds(new Rectangle(10, 365, 180, 30));

		pMenu.add(bNewGame);
		pMenu.add(bExitGame);
		
	}

	/**
	 * Letrehozza a gombnyomast figyelo osztalyokat
	 **/
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

	/**
	 * Felallitja az ablakot
	 **/
	private void setUpWindow() {
		fMenu.setSize(new Dimension(500, 500));
		pMenu.setLayout(null);
		fMenu.add(pMenu, BorderLayout.CENTER);
		fMenu.setResizable(false);
		fMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		fMenu.setLocation(dim.width/2-fMenu.getSize().width/2, dim.height/2-fMenu.getSize().height/2);
		fMenu.setVisible(true);
	}
	
	/**
	 * Lekezeli azt az esemenyt, ha a New Game gombot megnyomtak
	 **/
	private synchronized void startNewGameClicked() {
		if(interp == null) {
			interp = new Interpreter();
			interp.start();
		}
	}



	/**
	 * Lekezeli azt az esemenyt, ha az Exit Game gombot megnyomtak
	 **/
	private void exitGameClicked() {
		System.exit(0);
	}
}
