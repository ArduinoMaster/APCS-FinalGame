import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import info.gridworld.actor.*;
import info.gridworld.grid.*;

public class Game extends Actor
{
   public static BoundedGrid<Actor> grid = new BoundedGrid<Actor>(20, 20);
   public static ActorWorld world = new ActorWorld(grid);
   
   
   public static void main(String[] args) 
   {
	   int num = 0;
	   Color[] colors = {Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.WHITE};
	   //Hiding unimportant things and changing name from GridWorld to Rat Game
       System.setProperty("info.gridworld.gui.selection", "hide");
       System.setProperty("info.gridworld.gui.tooltips", "hide");
       System.setProperty("info.gridworld.gui.frametitle", "The Game");
       
       //Test Popup for fighting sequence
       JFrame text = new JFrame();

       //Adding Rat to the world
       Player r = new Player();
	   AmongUs a = new AmongUs();
	   Dog d = new Dog();
	   Rat rat = new Rat();
	   world.add(new Location(10,10),r);
	   world.add(new Location(15,15), a);
	   world.add(new Location(5,5), d);
	   world.add(new Location(3,7), rat);
		for(int x = 0; x < 15; x++)
		{
			num = x % 4;
			world.add(new Rock(colors[num]));
		}
       world.show();
       
       //Keyboard inputs
       java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new java.awt.KeyEventDispatcher() 
       {
    	   public boolean dispatchKeyEvent(java.awt.event.KeyEvent event) 
    	   {
    		   String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString();
    		   //up
    		   if (key.equals("pressed W"))
    			   if(canMove(r.getLocation().getAdjacentLocation(0)))
    				   r.moveTo(r.getLocation().getAdjacentLocation(0));
    		   //down
    		   if (key.equals("pressed D"))
    			   if(canMove(r.getLocation().getAdjacentLocation(Location.EAST)))
    				   r.moveTo(r.getLocation().getAdjacentLocation(Location.EAST));
    		   //left
    		   if (key.equals("pressed S"))
    			   if(canMove(r.getLocation().getAdjacentLocation(Location.SOUTH)))
    			   r.moveTo(r.getLocation().getAdjacentLocation(Location.SOUTH));
    		   //right
    		   if (key.equals("pressed A"))
    			   if(canMove(r.getLocation().getAdjacentLocation(Location.WEST)))
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
   public static boolean canMove(Location loc) { //function for checking if the next space is valid
	   if(! grid.isValid(loc))
		   return false;
	   checkCollision(loc);
	   Actor thing = grid.get(loc); //gets whatever actor is at the location
	   
	   return(!(thing instanceof Rock || thing instanceof Dog || thing instanceof AmongUs)); //make sure to add (thing instanceof <what ever new class youre adding>)
   }
   public static void checkCollision(Location loc) { //checks for specific entities in the next space
	   Actor thing = grid.get(loc);
	   
	   if(thing instanceof AmongUs) {
		   //idk cayden puts however the battle system here
		   System.out.print("when the imposter is sus");
	   }
   }
}
