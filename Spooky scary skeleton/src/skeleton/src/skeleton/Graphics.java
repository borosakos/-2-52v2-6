package skeleton;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Rajzolasert felelos osztaly
 **/
public class Graphics {
	JFrame f;
	JPanel p1, p2;
	WebPanel wp;
	JLayeredPane layers;
	ArrayList<JLabel> tiles;
	ArrayList<JLabel> elements;

	public void redraw() {
		drawLines();
		drawTiles();
		//rowHighlight();
	}

	/**
	 * Jelzi, melyik csempekre lephet a parameterkent kapott allat
	 **/
	public void stepHighlight(Orangutan o) {
		int idx = Controller.game.board.getTiles().indexOf(o.getTile());
		tiles.get(idx).setBackground(new Color(o.color.get(0), o.color.get(1), o.color.get(2), 0.3f));
		tiles.get(idx).setOpaque(true);
	}


	
	private float getLabelWidth() {
		int tileNum = Controller.game.board.getTiles().size();
		int nColumn = (int) Math.ceil(tileNum/10);
		return (float)500/nColumn;
	}

	/**
	 * Kirajzolja a csempeket es a rajtuk levo elemeket
	 **/
	private void drawTiles() {
		if (tiles.isEmpty()) {
			for (Tile t : Controller.game.board.getTiles()) {
				JLabel label = new JLabel();
				JLabel element = new JLabel();
				label.setHorizontalAlignment(JLabel.CENTER);
				element.setHorizontalAlignment(JLabel.CENTER);
				elements.add(element);
				tiles.add(label);
				t.draw(label, element);
				p1.add(label);
				p2.add(element);
			}
		} else {
			for (int i = 0; i< Controller.game.board.getTiles().size(); i++) {
				Tile t = Controller.game.board.getTiles().get(i);
				t.draw(tiles.get(i), elements.get(i));
				tiles.get(i).setOpaque(false);
		
			}
		}
	}

	public ArrayList<Line> lines = new ArrayList<>();
	public ArrayList<Color> colors = new ArrayList<>();

	/**
	 * Meghatarozza a palyatopologiat - ket csempe kozott pontosan akkor fut el, ha
	 * azok szomszedosak
	 **/
	private void drawLines() {
		ArrayList<Tile> theTiles = new ArrayList<>(Controller.game.board.getTiles());
		lines.clear();
		colors.clear();
		for (int i = 0; i < theTiles.size(); i++) {
			for (Tile t : theTiles.get(i).getNeighbours()) {
				Line line = new Line();
				int ricsiIsTheBest = theTiles.indexOf(t);
				//System.out.println("yassfasdfdasfdasfdasf" + tiles.size());
				if (tiles.size() == 0)
					return;

				int tileX = (int) (tiles.get(i).getX() + getLabelWidth()/2);
				int tileY = tiles.get(i).getY() + 25;

				int neighborX = (int) (tiles.get(ricsiIsTheBest).getX() + getLabelWidth()/2);
				int neighborY = tiles.get(ricsiIsTheBest).getY() + 25;

				line.start = new Point(tileX, tileY);
				line.end = new Point(neighborX, neighborY);
				
				if(t.inPair(Controller.game.board.getTiles().get(i))) {
					if(t.getLineColor()==null) colors.add(Color.black);
					if(t.getLineColor()!=null) colors.add(t.getLineColor());
				} else {
					colors.add(Color.black);
				}
				
				lines.add(line);
				

			}
		}

		wp.update(lines, colors);
		wp.repaint();
	}

	/**
	 * Kirajzolja a fomenut
	 **/
	public void showMenu() {
		f = new JFrame("Panda Mall - The Reckoning");
		Menu m = new Menu();
	}
	
	public void SoundClipTest() {
	     

	      try {
	         // Open an audio input stream.
	         URL url = this.getClass().getClassLoader().getResource("cut.mp3");
	         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	         // Get a sound clip resource.
	         Clip clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioIn);
	         clip.start();
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	   }
	
	void playSound(String soundFile) {
	    File f = new File("./" + soundFile);
	    AudioInputStream audioIn;
		try {
			audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
			Clip clip = AudioSystem.getClip();
		    clip.open(audioIn);
		    clip.start();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    
	}
	
	/**
	 * Megjeleniti a jatekot
	 **/
	public void showGame() {
		f = new JFrame("Panda Mall - The Reckoning");
		p1 = new JPanel();
		p2 = new JPanel();
		wp = new WebPanel(lines, colors);
		layers = new JLayeredPane();
		tiles = new ArrayList<>();
		elements = new ArrayList<>();

		f.setSize(100, 200);
		GridLayout grid = new GridLayout(10, 10, 0, 0);
		p1.setLayout(grid);
		p2.setLayout(grid);

		redraw();
		p1.setBounds(0, 0, 500, 500);
		p1.setOpaque(false);
		p2.setBounds(0, 0, 500, 500);
		wp.setBounds(0, 0, 500, 500);
		//p2.setBackground(Color.red);
		p2.setOpaque(false);
		//layers.add(p2);
		//layers.add(p1);

		wp.setOpaque(false);

		layers.setLayout(null);
		layers.setPreferredSize(new Dimension(500, 500));
		layers.setOpaque(false);

		layers.add(p1, JLayeredPane.PALETTE_LAYER);
		layers.add(wp, JLayeredPane.DEFAULT_LAYER);
		layers.add(p2, JLayeredPane.MODAL_LAYER);
		layers.addMouseListener(new tileClick());

		f.add(layers);
		playSound("despacito.wav");
		f.pack();
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	/**
	 * Figyeli, melyik csempere kattint a jatekos
	 **/
	private class tileClick implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			return;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			Object source = e.getSource();
			float x = e.getX();
			float y = e.getY();
			int idx = 0;
			for (JLabel l : elements) {
				float lx = l.getX();
				float ly = l.getY();

				if (x <= lx + getLabelWidth() && lx <= x && y <= ly + 50 && ly <= y) {

					for (Orangutan o : Controller.getOrangutans()) {

						if (o.toStep && Controller.game.board.getTiles().indexOf(o.getTile()) == idx) {
							o.release();
							o.toStep = false;
							redraw();
							return;
						}

						for (Tile t : o.getTile().getNeighbours()) {
							if (Controller.game.board.getTiles().indexOf(t) == idx) {
								if (o.toStep) o.step(Controller.game.board.getTiles().get(idx));
							}
						}

					}
				}
				idx++;
			}

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			return;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}
}
