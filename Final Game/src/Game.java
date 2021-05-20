import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import info.gridworld.actor.*;
import info.gridworld.grid.*;

public class Game extends Actor
{
   public static BoundedGrid grid = new BoundedGrid<Actor>(20, 20);
   public static ActorWorld world = new ActorWorld(grid);
   
   
   public static void main(String[] args) 
   {
	   //variables
	   int num = 0;
	   Color[] colors = {Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.WHITE};
	   
	   //Hiding unimportant things and changing name from GridWorld to The Game
       System.setProperty("info.gridworld.gui.selection", "hide");
       System.setProperty("info.gridworld.gui.tooltips", "hide");
       System.setProperty("info.gridworld.gui.frametitle", "The Game");
       
       //Test Popup for fighting sequence
       JFrame text = new JFrame();
       
       Grid<Actor> gr; //grid

       //Adding Player and other entities to the world
	   Player r = new Player();
	   world.add(new Location(10,10),r);
		for(int x = 0; x < 15; x++)
		{
			num = x % 4;
			world.add(new Rock(colors[num]));
		}
		
		//show the world
       world.show();
       
       //Keyboard inputs
       java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new java.awt.KeyEventDispatcher() 
       {
    	   public boolean dispatchKeyEvent(java.awt.event.KeyEvent event) 
    	   {
    		   String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString();
    		   //up
    		   if (key.equals("pressed W"))
    			   if(grid.isValid(r.getLocation().getAdjacentLocation(0)))
    				   r.moveTo(r.getLocation().getAdjacentLocation(0));
    		   //down
    		   if (key.equals("pressed D"))
    			   if(grid.isValid(r.getLocation().getAdjacentLocation(Location.EAST)))
    				   r.moveTo(r.getLocation().getAdjacentLocation(Location.EAST));
    		   //left
    		   if (key.equals("pressed S"))
    			   if(grid.isValid(r.getLocation().getAdjacentLocation(Location.SOUTH)))
    			   r.moveTo(r.getLocation().getAdjacentLocation(Location.SOUTH));
    		   //right
    		   if (key.equals("pressed A"))
    			   if(grid.isValid(r.getLocation().getAdjacentLocation(Location.WEST)))
    			   r.moveTo(r.getLocation().getAdjacentLocation(Location.WEST));
    		   //pick up
    		   if (key.equals("pressed E"))
    			   JOptionPane.showMessageDialog(text, "You grabbed an item");
    		   //fight
    		   if (key.equals("pressed F"))
    			   JOptionPane.showMessageDialog(text, "FIGHT");
    		   world.show();
    		   return true;
    	   }
       });
       
       //Shows message above game window
       world.setMessage("Its Gaming Time");      
       world.show();
    }
}
