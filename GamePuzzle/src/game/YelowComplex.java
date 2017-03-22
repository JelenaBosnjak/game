package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;




public class YelowComplex extends AbstractPart {

	public YelowComplex(Point location, int size,int size1, Color color) {
        Rectangle bounds = new Rectangle();
        bounds.setLocation(location);
        bounds.setSize(size,size1);
        setBounds(bounds);
        setColor(color);
        


        
    }

    
	@Override
	public void paint(Graphics2D g2d) {

	 	g2d.setColor(getColor());
	 	g2d.fill(getBounds());
        g2d.setColor(Color.YELLOW);

        
        Rectangle bounds = getBounds();
		g2d.drawRect(bounds.x+138,bounds.y+70,bounds.width-69 ,bounds.height-71);	
		g2d.fillRect(bounds.x+138,bounds.y+70,bounds.width-69 ,bounds.height-71);
	
	

}
	
}
