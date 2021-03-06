package map_drawing;

import map_making.Field;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.util.ArrayList;

public class TwoDView extends Tiles {
	private static final long serialVersionUID = 1L;
	int xCrd[] = new int[4];
	int yCrd[] = new int[4];
	
	public TwoDView(int space, int maxFields, ArrayList<ArrayList<Field>> map, Boolean grid, int miniscale) {
		super(space, maxFields, map, grid, miniscale);
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		for(int x = 0; x < maxFields; x++){
            for(int y = 0; y < maxFields; y++) {
            	
            	this.field = map.get(x).get(y);
            	int size = field.getTileSize();	
            	size = miniscale > 0 ? (int) size/miniscale : size;
            	
            	xCrd[0] = 0 + x*size;
            	xCrd[1] = size + x*size;
            	xCrd[2] = size + x*size;
            	xCrd[3] = 0 + x*size;
        
            	yCrd[0] = 0 + y*size;
            	yCrd[1] = 0 + y*size;
            	yCrd[2] = size + y*size;
            	yCrd[3] = size + y*size;

            	Polygon p = new Polygon(xCrd, yCrd, xCrd.length);
            	//draw tile
            	g2.setColor(field.getColor());
            	g2.fillPolygon(p);
            	//draw grid
            	if(grid){
            		g2.setStroke(new BasicStroke((int)size/32));
            		g2.setColor(Color.black);
            	}
            	g2.drawPolygon(p);
            }
		}		
	}

}
