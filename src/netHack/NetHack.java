/*//
 * The driver to run the sample scenario for nethack
 */
package netHack;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class NetHack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // No map yet, and just a few simple actions
        String name;
        Character hero;
        
        Item scroll = new ScrollOfNothing();
        Item anotherScroll = new ScrollOfNothing();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Welcome to (not-yet) Nethack!");
        System.out.print("What is the name of your hero? ");
        name = stdin.readLine();
        hero = new Character(name, 12);	// 12 is the "hit points" or "life points" of the Character
        Floor floor = new Floor();

        floor.place(hero, 2, 3);    // (0,0 is top left point)
      
        
        /// to start the game interaction
        //arrows to move
        //a to atackt with normal
        //d to defend
        //i to look at inventory
        //# to use some inventory next to it
        
               
        KeyEvent key=null;
        
       

       
        
    }
}