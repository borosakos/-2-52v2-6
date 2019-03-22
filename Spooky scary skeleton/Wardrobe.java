package skeleton;

import java.util.*;

/**
 * 
 */
public class Wardrobe extends Element {

    /**
     * Default constructor
     */
    public Wardrobe() {
    	Indent.print("Wardrobe Wardrobe()");
    }

    /**
     * az a tile, amirõl a szekrénybe lehet lépni
     */
    private Tile doorTile; 
    private Wardrobe end;
    private ArrayList<Wardrobe> otherWardrobes;

    /**
     * Elterepoltálja az orángutánt a szekrény melletti mezõre.
     * @param o orángután
     */
    public void teleport(Orangutan o) {
    	Indent.print("Wardrobe teleport(Orangutan o)");
    	Indent.inc();
    	
    	doorTile.accept(o);
    	o.getTile().remove(o);
    	doorTile.take(o);
    	if(o.isInQueue()) o.getBackNeighbour().follow(doorTile);
    	
    	Indent.inc();
    }

    /**
     * @param p
     */
    public void teleport(Panda p) {
    	Indent.print("Wardrobe teleport(Orangutan o)");
    	Indent.inc();
    	
    	doorTile.accept(p);
    	p.getTile().remove(p);
    	doorTile.take(p);
    	
    	Indent.dec;
    }

    /**
     * @return
     */
    public Wardrobe selectRandomWardrobe() {
    	Indent.print("Wardrobe selectRandomWardrobe()");
    	Indent.inc();
    	
    	int index = (int)( Math.random() * otherWardrobes.size() );
        return otherWardrobes.get(index);
        
        Indent.dec();
    }

    /**
     * @param o 
     * @return
     */
    public boolean hitBy(Orangutan o) {
    	Indent.print("Wardrobe hitBy(Orangutan o)");
    	Indent.inc();
    	
    	setEnd( selectRandomWardrobe() );
        teleport(o);
        return false;
        
        Indent.dec();
    }

    /**
     * @param p 
     * @return
     */
    public boolean hitBy(Panda p) {
    	Indent.print("Wardrobe hitBy(Panda p)");
    	Indent.inc();
    	
    	setEnd( selectRandomWardrobe() );
        teleport(p);
        
        Indent.dec();
        return false;
    }

    /**
     * @param w
     */
    public void setEnd(Wardrobe w) {
    	Indent.print("Wardrobe setEnd(Wardrobe w)");
    	Indent.inc();
    	
    	end = w;
    	
    	Indent.dec();
    }

    /**
     * @param e 
     * @return
     */
    public boolean collideWith(Element e) {
    	Indent.print("Wardrobe collideWith(Element e)");
    	
    	return false;
    }

}