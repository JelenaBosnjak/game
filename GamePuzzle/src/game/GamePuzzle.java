package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class GamePuzzle extends JPanel {

    private List <Part> parts;
    private Board board;
    private Part selected;
    private static JButton start = new JButton("START");

    

   public GamePuzzle() {

        Dimension size = getPreferredSize();
        parts = new ArrayList<>();
        //Board
        Point location = new Point((size.height-150) / 2, (size.width-400) / 2);
        board = new Board(location, 350, Color.LIGHT_GRAY);
        
        //Points
        final Point pRed = new Point((size.height -650) / 2, (size.width - 400) / 2);
        final Point pGreen = new Point((size.height -150) / 2, (size.width - 600) / 2);
        final Point pPurple = new Point((size.height + 430) / 2, (size.width -880) / 2);
        final Point pBlue = new Point((size.height -150) / 2, (size.width -900) / 2);
        final Point pYelow = new Point((size.height +650) / 2, (size.width -400) / 2);
        
        //Parts
        final RedComplex red = new RedComplex(pRed,209,69,Color.RED);
        final YelowComplex yelow = new YelowComplex(pYelow,139,209,Color.YELLOW);
        final Parts green = new Parts(pGreen,279,69,Color.GREEN);
        final Parts purple = new Parts(pPurple,69,209,Color.MAGENTA);
        final Parts blue = new Parts(pBlue,139,139,Color.BLUE);
       
        //Adding in list of parts
        parts.add(red);
        parts.add(yelow);
        
        parts.add(green);
        parts.add(purple);
        parts.add(blue);
        
        
        //Start-restart 
        ActionListener action = new ActionListener(){

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			removeAll();
                add(new GamePuzzle());
                revalidate();
                repaint();

    			
    		}
        	
        };
        
        start.addActionListener(action);
        
        //Movement of parts
        MouseAdapter ma = new MouseAdapter() {


            private Point point;

            
            @Override
            public void mousePressed(MouseEvent e) {
            	List<Part> reversed = new ArrayList<>(parts); 
                Collections.reverse(reversed); 
                if(selected == null || !selected.getBounds().contains(e.getPoint())){
                	for(Part p : reversed){
                		if(p.getBounds().contains(e.getPoint())){
                			
                			selected = p;
                			point = new Point(e.getX() - selected.getBounds().x, e.getY() - selected.getBounds().y);
                			repaint();                  
         
                		}
                	} if (selected != null) { 		
                		parts.remove(selected); 
                		parts.add(parts.size()-1, selected); 
                   }
                }else if (selected != null) {	
         		   point = new Point(e.getX() - selected.getBounds().x, e.getY() - selected.getBounds().y); 
         	   }
            }
            
            
            
            @Override
            public void mouseDragged(MouseEvent e) {

            		if(selected != null){
            			
            			//Screen collisions
                         if( e.getX()-point.x >= -1  && e.getY()-point.y >= -1){
                 			
                             int x1 = Math.min(1200-selected.getBounds().width, e.getX()-point.x);
                             int y1 = Math.min(900-selected.getBounds().height, e.getY()-point.y);
                            	 
                            	 selected.getBounds().x = x1; 
                                 selected.getBounds().y = y1;
                                 repaint();
                                 
                     		}
               
                                  
           //Moves for parts
            if(selected.getBounds().intersects(board.getBounds())){
                 selected.getBounds().x = board.getBounds().x+1; 
                 selected.getBounds().y = board.getBounds().y+1;

                 
                

                 if(!selected.getBounds().contains(e.getPoint())){
                	 selected.getBounds().x = board.getBounds().x+71; 
                	 selected.getBounds().y = board.getBounds().y+1;
                	
                 }
                 if(!selected.getBounds().contains(e.getPoint())){
                	 selected.getBounds().x = board.getBounds().x+141; 
                	 selected.getBounds().y = board.getBounds().y+1;
                	 
                 }
                 if(!selected.getBounds().contains(e.getPoint())){
                	 selected.getBounds().x = board.getBounds().x+211; 
                	 selected.getBounds().y = board.getBounds().y+1;
                	 
                 }
                 if(!selected.getBounds().contains(e.getPoint())){
                	 selected.getBounds().x = board.getBounds().x+281; 
                	 selected.getBounds().y = board.getBounds().y+1;
                 }
                 if(!selected.getBounds().contains(e.getPoint())){
                	 selected.getBounds().x = board.getBounds().x+1; 
                	 selected.getBounds().y = board.getBounds().y+71;
                 }
                 if(!selected.getBounds().contains(e.getPoint())){
                	 selected.getBounds().x = board.getBounds().x+71; 
                	 selected.getBounds().y = board.getBounds().y+71;
                 }
                 if(!selected.getBounds().contains(e.getPoint())){
                	 selected.getBounds().x = board.getBounds().x+141; 
                	 selected.getBounds().y = board.getBounds().y+71;
                 }
                 if(!selected.getBounds().contains(e.getPoint())){
                	 selected.getBounds().x = board.getBounds().x+211; 
                	 selected.getBounds().y = board.getBounds().y+71;
                 }
                 if(!selected.getBounds().contains(e.getPoint())){
                	 selected.getBounds().x = board.getBounds().x+281; 
                	 selected.getBounds().y = board.getBounds().y+71;
                 }

                 if(!selected.getBounds().contains(e.getPoint())){
                	 selected.getBounds().x = board.getBounds().x+1; 
                	 selected.getBounds().y = board.getBounds().y+141;
                	 
                 }
                 if(!selected.getBounds().contains(e.getPoint())){
                	 selected.getBounds().x = board.getBounds().x+71; 
                	 selected.getBounds().y = board.getBounds().y+141;
                 }
                 if(!selected.getBounds().contains(e.getPoint())){
                	 selected.getBounds().x = board.getBounds().x+141; 
                	 selected.getBounds().y = board.getBounds().y+141;
                 }
                 if(!selected.getBounds().contains(e.getPoint())){
                	 selected.getBounds().x = board.getBounds().x+211; 
                	 selected.getBounds().y = board.getBounds().y+141;
                 }
                 if(!selected.getBounds().contains(e.getPoint())){
                	 selected.getBounds().x = board.getBounds().x+281; 
                	 selected.getBounds().y = board.getBounds().y+141;
                 }
                 if(!selected.getBounds().contains(e.getPoint())){
                	 selected.getBounds().x = board.getBounds().x+71; 
                	 selected.getBounds().y = board.getBounds().y+211;
                 }
                 if(!selected.getBounds().contains(e.getPoint())){
                	 selected.getBounds().x = board.getBounds().x+211; 
                	 selected.getBounds().y = board.getBounds().y+211;
                 }
                 if(!selected.getBounds().contains(e.getPoint())){
                	 selected.getBounds().x = board.getBounds().x+281; 
                	 selected.getBounds().y = board.getBounds().y+211;
                 }
                 if(!selected.getBounds().contains(e.getPoint())){
                	 selected.getBounds().x = board.getBounds().x+71; 
                	 selected.getBounds().y = board.getBounds().y+281;
                 }

                 if(!selected.getBounds().contains(e.getPoint())){
                	 selected.getBounds().x = board.getBounds().x+1; 
                	 selected.getBounds().y = board.getBounds().y+211;
                	 
                 }

                 if(!selected.getBounds().contains(e.getPoint())){
                	 selected.getBounds().x = board.getBounds().x+1; 
                	 selected.getBounds().y = board.getBounds().y+281;
                	
                	 
                 }
                 
                 

                 //Parts collisions for board(grid)  
                 if(yelow.getBounds().x == board.getBounds().x+211 || yelow.getBounds().x == board.getBounds().x+281 || yelow.getBounds().y == board.getBounds().y+281 || yelow.getBounds().y == board.getBounds().y+211 || yelow.getBounds().x == 216 || yelow.getBounds().y == 546){
                	 selected.getBounds().x = pYelow.x; 
                     selected.getBounds().y = pYelow.y;
                 }
                 if(red.getBounds().y == board.getBounds().y+281 || red.getBounds().x == board.getBounds().x+281 ||  red.getBounds().y == board.getBounds().y+211 || red.getBounds().y == board.getBounds().y+141 || red.getBounds().x == board.getBounds().x+211){
                	 selected.getBounds().x = pRed.x; 
                     selected.getBounds().y = pRed.y;
                     repaint();
                 }
                 
                 if(blue.getBounds().x == board.getBounds().x+281  || blue.getBounds().y == board.getBounds().y+281 ){
                	 selected.getBounds().x = pBlue.x; 
                     selected.getBounds().y = pBlue.y;
                 }

  
                 if(green.getBounds().x == board.getBounds().x+281 || green.getBounds().x == board.getBounds().x+211 || green.getBounds().x == board.getBounds().x+141  ){
                	 selected.getBounds().x = pGreen.x; 
                     selected.getBounds().y = pGreen.y;
                 }
                 if(purple.getBounds().y == board.getBounds().y+281 || purple.getBounds().y == board.getBounds().y+211){
                	 selected.getBounds().x = pPurple.x; 
                     selected.getBounds().y = pPurple.y;
                 }
                 

                 
                 
                 	//Moras da resis ovo, kada selektovan objekat dodje na grid da radi,a ne van njega
                 	//Overlap for yelow part
                   	 if(yelow.getBounds().intersects(green.getBounds())){
                   		green.getBounds().x = pGreen.x;
                   		green.getBounds().y = pGreen.y;


                   	 }
                 	 if(yelow.getBounds().intersects(red.getBounds())){
                 		red.getBounds().x = pRed.x;
                 		red.getBounds().y = pRed.y;


                   	 }
                	 if(yelow.getBounds().intersects(blue.getBounds())){
                		 blue.getBounds().x = pBlue.x;
                		 blue.getBounds().y = pBlue.y;


                   	 }
                	 if(yelow.getBounds().intersects(purple.getBounds())){
                		 purple.getBounds().x =pPurple.x;
                		 purple.getBounds().y = pPurple.y;


                   	 }
                	 
                	 //Overlap for red part
                	 if(red.getBounds().intersects(green.getBounds())){
                		 green.getBounds().x = pGreen.x;
                		 green.getBounds().y = pGreen.y;

                   	 }
                	 
                	 if(red.getBounds().intersects(blue.getBounds())){
                		 blue.getBounds().x = pBlue.x;
                		 blue.getBounds().y = pBlue.y;

                   	 }
                	 
                	 if(red.getBounds().intersects(purple.getBounds())){
                		 purple.getBounds().x = pPurple.x;
                		 purple.getBounds().y = pPurple.y;

                   	 }
                	 
                	 if(red.getBounds().intersects(yelow.getBounds())){
                		 yelow.getBounds().x = pYelow.x;
                		 yelow.getBounds().y = pYelow.y;

                   	 }
                	 
                	 //Overlap for green part
                  	 if(green.getBounds().intersects(blue.getBounds())){
                  		blue.getBounds().x = pBlue.x;
                  		blue.getBounds().y = pBlue.y;

                   	 }
                   	 if(green.getBounds().intersects(yelow.getBounds())){
                   		yelow.getBounds().x = pYelow.x;
                   		yelow.getBounds().y = pYelow.y;

                   	 }
                   	 
                   	 if(green.getBounds().intersects(red.getBounds())){
                   		red.getBounds().x = pRed.x;
                   		red.getBounds().y = pRed.y;

                   	 }
                   	 if(green.getBounds().intersects(purple.getBounds())){
                   		purple.getBounds().x = pPurple.x;
                   		purple.getBounds().y = pPurple.y;

                   	 }
                   	 
                   	 //Overlap for blue part
                   	 if(blue.getBounds().intersects(purple.getBounds())){
                   		purple.getBounds().x = pPurple.x;
                   		purple.getBounds().y = pPurple.y;
                   	 }
                   	 
                   	 if(blue.getBounds().intersects(green.getBounds())){
                   		 green.getBounds().x = pGreen.x;
                		 green.getBounds().y = pGreen.y;
                   	 }
                   	 
                  	 if(blue.getBounds().intersects(yelow.getBounds())){
                 		yelow.getBounds().x = pYelow.x;
                   		yelow.getBounds().y = pYelow.y;
                   	 }
                  	 
                  	 if(blue.getBounds().intersects(red.getBounds())){
                  		red.getBounds().x = pRed.x;
                   		red.getBounds().y = pRed.y;
                   	 }
                  	 
                  	 
                  	 //Overlap for purple
                 	 if(purple.getBounds().intersects(red.getBounds())){
                   		red.getBounds().x = pRed.x;
                    	red.getBounds().y = pRed.y;
                    }
                 	 
                 	 if(purple.getBounds().intersects(yelow.getBounds())){
                  		yelow.getBounds().x = pYelow.x;
                    	yelow.getBounds().y = pYelow.y;
                    }
                 	 
                   	 if(purple.getBounds().intersects(green.getBounds())){
                   		 green.getBounds().x = pGreen.x;
                		 green.getBounds().y = pGreen.y;
                   	 }
                   	 
                  	 if(purple.getBounds().intersects(blue.getBounds())){
                  		blue.getBounds().x = pBlue.x;
                  		blue.getBounds().y = pBlue.y;

                   	 }
                  	 
                 	 

                	 //Finish
                	 if(red.getBounds().x ==board.getBounds().x+1 &&  yelow.getBounds().x == board.getBounds().x+71 && blue.getBounds().y == board.getBounds().y+1 && purple.getBounds().y == board.getBounds().y+141  && purple.getBounds().x == board.getBounds().x+281 && green.getBounds().y == board.getBounds().y+281){                		 
                		 JOptionPane optionPane = new JOptionPane("Great job! (: You won! Click start for new game! ",JOptionPane.INFORMATION_MESSAGE);

                		 JDialog dialog = optionPane.createDialog("Info");
                		 dialog.setBounds(760, 500, 400,150);
                		 dialog.setVisible(true); 
                		
                		 
                	 }
             
                	 


                    

                	 
                	 
                 }

              }
            }//End of mouse dragg
        };
        



        addMouseListener(ma);
        addMouseMotionListener(ma);
       
       
        
    }
    


	@Override
    public Dimension getPreferredSize() {
        return new Dimension(1200,1000);
    }
	
	

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        board.paint(g2d);
        g2d.dispose();
        for (Part part : parts) {
        	 if (part != parts) {
            	 Graphics2D g2d3 = (Graphics2D) g.create();
            	 part.paint(g2d3);
            	 g2d3.dispose();

             }
        }if (selected != null) {
        	 Graphics2D g2d4 = (Graphics2D) g.create();
        	 selected.paint(g2d4);
        	 g2d4.dispose();
        	
        }
        
    }
    

        
   
    
    
    public static void main (String args[]){
    	GamePuzzle game = new GamePuzzle();
    	JFrame frame = new JFrame("Simple puzzle game");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(1200, 1000);
    	frame.setVisible(true);
    	frame.setLocationRelativeTo(null);
        JPanel forButton = new JPanel();
        forButton.add(start);
        frame.add(forButton,BorderLayout.SOUTH);
    	frame.setResizable(false);
    	
    	frame.remove(game);
    	frame.add(game);
    }

}
