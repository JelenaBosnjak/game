package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;



public interface Part  {
	
	 	public Rectangle getBounds();
	    public Color getColor();
	    public void setLocation(Point point);
	    public void paint(Graphics2D g2d);

}
