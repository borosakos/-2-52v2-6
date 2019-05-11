package skeleton;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Graphics {
	JFrame f;
	JPanel p1, p2;
	JLayeredPane layers;
	ArrayList<JLabel> tiles;
	ArrayList<JLabel> elements;
	
	public void redraw() {
		drawTiles();
		rowHighlight();
	}
	public void stepHighlight(Animal a) {
		ArrayList<Integer> idx = new ArrayList<>();
		idx.add(Controller.game.board.getTiles().indexOf(a.getTile()));
		for(Tile t : a.getTile().neighbours) idx.add(Controller.game.board.getTiles().indexOf(t));
		for(Integer i : idx) {
			tiles.get(i).setOpaque(true);
		 tiles.get(i).setBackground(Color.white);
		}
		rowHighlight();
	}
	
	public void rowHighlight() {
		for(Orangutan o : Controller.getOrangutans()) {
			ArrayList<Integer> idx = new ArrayList<>();
			idx.add(Controller.game.board.getTiles().indexOf(o.getTile()));
			Panda lastBackNeighbour = o.backNeighbour;
			while (lastBackNeighbour != null) {
				idx.add(Controller.game.board.getTiles().indexOf(lastBackNeighbour.getTile()));
				lastBackNeighbour = lastBackNeighbour.backNeighbour;
			}
			for(Integer i : idx) {
				tiles.get(i).setOpaque(true);
				tiles.get(i).setBackground(new Color(o.color.get(0), o.color.get(1), o.color.get(2)));
			}
			
		}
	}
	
	
	private void drawElements() {
		
	}
	private void drawTiles() {
		if(tiles.isEmpty()) {
		for(Tile t : Controller.game.board.getTiles()) {
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
			int i = 0;
			for(Tile t : Controller.game.board.getTiles()) {
				t.draw(tiles.get(i), elements.get(i));
				tiles.get(i).setBackground(Color.cyan);
				i++;
			}
		}
	}
	public void showMenu() {
		JFrame f = new JFrame("Swing Example");
		JPanel p = new JPanel();
		JButton b = new JButton("Click Me!");
		JTextField t = new JTextField("Type here!");
		p.add(b);
		p.add(t);
		f.add(p, BorderLayout.NORTH);
		f.pack();
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public void showGame() {
	f = new JFrame("Panda Mall - The Reckoning");
	 p1 = new JPanel(); p2 = new JPanel();
	layers = new JLayeredPane();
	tiles = new ArrayList<>();
	elements = new ArrayList<>();

		f.setSize(100, 200);
		GridLayout grid = new GridLayout(10,10,0,0);
		p1.setLayout(grid);
		p2.setLayout(grid);
		
		redraw();
		p1.setBounds(0, 0, 500, 500);
		p1.setBackground(Color.cyan);  
		p2.setBounds(0, 0, 500, 500);
		//p2.setBackground(Color.red);  
		p2.setOpaque(false); 
		//layers.add(p2);
		//layers.add(p1);
		
		layers.setLayout(null);
        layers.setPreferredSize(new Dimension(500,500));
        layers.setBackground(Color.blue);

        layers.add(p2, JLayeredPane.PALETTE_LAYER);
	    layers.add(p1, JLayeredPane.DEFAULT_LAYER);  
	    layers.addMouseListener(new tileClick());
	      

		f.add(layers);


		f.pack();
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	private class tileClick implements MouseListener
	{		
		@Override
		public void mouseClicked(MouseEvent e) {
			return;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			Object source = e.getSource();
			float x = e.getX(); float y = e.getY();
			System.out.println(x + " ééééés " + y);
			int idx = 0;
			for(JLabel l : elements) {
				float lx = l.getX();
				float ly = l.getY();

				if(x<=lx+48 && lx<=x && y<=ly+48 && ly<=y) {

					for(Orangutan o : Controller.getOrangutans()) {
						
						if(o.toStep && Controller.game.board.getTiles().indexOf(o.getTile()) == idx) {
							o.release();
							o.toStep = false;
							redraw();
							return;
						}
						
						for(Tile t : o.getTile().getNeighbours()) {
							if (Controller.game.board.getTiles().indexOf(t) == idx) {
								if(o.toStep) o.step(Controller.game.board.getTiles().get(idx));
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
