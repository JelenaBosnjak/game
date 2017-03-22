package game;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;




public abstract class AbstractPart implements Part {

    protected Rectangle bounds;
    private Color color;
    
    

    @Override
    public void setLocation(Point point) {
        bounds.setLocation(point);
    }

    @Override
    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public Color getColor() {
        return color;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}

