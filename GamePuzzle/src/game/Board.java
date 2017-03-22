package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;


	

public class Board extends AbstractPart {
	

    public Board(Point location, int size, Color color) {
        Rectangle bounds = new Rectangle();
        bounds.setLocation(location);
        bounds.setSize(size, size);
        setBounds(bounds);
        setColor(color);
       
        
       
        
        
    }
    
    

    @Override
    public void paint(Graphics2D g2d) {
        g2d.setColor(getColor());
        g2d.fill(getBounds());
        g2d.setColor(Color.BLACK);
        Rectangle bounds = getBounds();

       
        //Width rectangle
        g2d.drawLine(bounds.x + (bounds.width), bounds.y, bounds.x + (bounds.width), bounds.y + bounds.height);
        g2d.drawLine(bounds.x + (bounds.width - 70), bounds.y, bounds.x + (bounds.width -70), bounds.y + bounds.height);
        g2d.drawLine(bounds.x + (bounds.width - 140), bounds.y, bounds.x + (bounds.width -140), bounds.y + bounds.height);
        g2d.drawLine(bounds.x + (bounds.width -210), bounds.y, bounds.x + (bounds.width-210), bounds.y + bounds.height);
        g2d.drawLine(bounds.x + (bounds.width -280), bounds.y, bounds.x + (bounds.width-280), bounds.y + bounds.height);
        g2d.drawLine(bounds.x + (bounds.width -350), bounds.y, bounds.x + (bounds.width-350), bounds.y + bounds.height);
        //Height rectangle
        g2d.drawLine(bounds.x, bounds.y + (bounds.height), bounds.x + bounds.width, bounds.y + (bounds.height));
        g2d.drawLine(bounds.x, bounds.y + (bounds.height -70), bounds.x + bounds.width, bounds.y + (bounds.height -70));
        g2d.drawLine(bounds.x, bounds.y + (bounds.height -140), bounds.x + bounds.width, bounds.y + (bounds.height -140));
        g2d.drawLine(bounds.x, bounds.y + (bounds.height -210), bounds.x + bounds.width, bounds.y + (bounds.height -210));
        g2d.drawLine(bounds.x, bounds.y + (bounds.height -280), bounds.x + bounds.width, bounds.y + (bounds.height -280));
        g2d.drawLine(bounds.x, bounds.y + (bounds.height -350), bounds.x + bounds.width, bounds.y + (bounds.height -350));


    } 
    
    
        
    }




