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
     * az a tile, amirol a szekrenybe lehet lepni
     */
    private Tile doorTile; 
    private Wardrobe end;
    private ArrayList<Wardrobe> otherWardrobes = new ArrayList<>();

    /**
     * Elteleportalja az orangutant a szekreny melletti mezore.
     * @param o or�ngut�n
     */
    public void teleport(Orangutan o) {
    	Indent.print("Wardrobe teleport(Orangutan o)");
    	Indent.inc();
    	
    	doorTile.accept(o);
    	o.getTile().remove(o);
    	doorTile.take(o);
    	if(o.isInQueue()) o.getBackNeighbour().follow(doorTile);
    	
    	Indent.dec();
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
    	
    	Indent.dec();
    }

    /**
     * @return
     */
    public Wardrobe selectRandomWardrobe() {
    	Indent.print("Wardrobe selectRandomWardrobe()");
    	Indent.inc();
    	Wardrobe end = new Wardrobe();
    	Tile t = new Tile();
    	end.setTile(t);
    	end.doorTile = t;
        otherWardrobes.add(end);
    	int index = (int)( Math.random() * otherWardrobes.size() );
    	

    	Indent.dec();
    	return otherWardrobes.get(index);
    }

    /**
     * @param o 
     * @return
     */
    public boolean hitBy(Orangutan o) {
    	Indent.print("Wardrobe hitBy(Orangutan o)");
    	Indent.inc();
    	
    	setEnd( selectRandomWardrobe() );
        end.teleport(o);

        Indent.dec();
        return false;
    }

    /**
     * @param p 
     * @return
     */
    public boolean hitBy(Panda p) {
    	Indent.print("Wardrobe hitBy(Panda p)");
    	Indent.inc();
    	
    	setEnd( selectRandomWardrobe() );
        end.teleport(p);
        
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