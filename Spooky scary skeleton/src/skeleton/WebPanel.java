package skeleton;

import javax.swing.*;
import java.awt.Graphics;
import java.util.ArrayList;

public class WebPanel extends JPanel {

    public ArrayList<Integer> lineCoords;

    public WebPanel(ArrayList<Integer> plswork){
        lineCoords = new ArrayList<>(plswork);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i < lineCoords.size(); i += 4){
            g.drawLine(lineCoords.get(i), lineCoords.get(i + 1), lineCoords.get(i + 2), lineCoords.get(i + 3));
        }
    }
}
