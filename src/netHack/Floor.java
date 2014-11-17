/*//Modified By Nora De Anda
 * One floor of the dungeon
 */
package netHack;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;


class Floor {
	int testCount=0;
	
    // The items on this floor
    protected HashMap<Point, ArrayList<Item>> items;
    // The characters on this floor
    protected HashMap<Point, Character> characters;
    //used to display the current floor
    protected ConsoleDisplay display= new ConsoleDisplay();
    boolean heroGot=true;
    Character vision;
  
    
    public Floor() {
        characters = new HashMap<>();
        items = new HashMap<>();
    }

    /*modified: first character assumed to be the hero.
     * 
    */
    void place(Character character, int col, int row) {
    	
    	if(heroGot){	
    		vision=character;	
    		heroGot=false;
    	}
    	
        characters.put(new Point(col, row), character);
        character.setPosition(col, row);
        display.GetVision(vision.vision());
        display.update("@",col,row);
        
    }

    void move(Character character, int direction) {
    	
    	//if it is the hero get the updated data and as soon as it moves the vision would be changed
    	if(character.getName().equalsIgnoreCase(vision.getName()))
    		vision=character;
    	
        Point pos = character.getPosition();
        
        Point newPos = new Point(pos.x + Directions.XMOD[direction],
                                 pos.y + Directions.YMOD[direction]);
        
        //if there is someone to attack or get attacked
        if (null != characters.get(newPos)) {
            int damage = character.computeDamage();
            Character target = characters.get(newPos);
            target.attacked(damage);
            System.out.println("You attacked " + target.getName() + " for " + damage + " hit points");
            

                   
            if (0 >= target.getHitPoints()) {
                System.out.println(target.getName() + " has breathed its last");
                characters.remove(newPos);
                
                display.GetVision(vision.vision());
                display.update(".",newPos.x,newPos.y);
            }
        }
        
        //no character near to attack
        else {
        	display.GetVision(vision.vision());
        	display.pastPosition(pos); //
            display.update("@",newPos.x,newPos.y);
            
            
            characters.remove(pos);
            characters.put(newPos, character);
            character.setPosition(newPos.x, newPos.y);
            System.out.println(character.getName() + " moved to (" + newPos.x + ", " + newPos.y + ")");
            ArrayList<Item> foundItems = items.get(newPos);
            if (null != foundItems) {
                for (Item item : foundItems) {
                    character.pickup(item);
                    System.out.println("You pick up a " + item.getDescription());
                }
                foundItems.clear();
            }
            
        }

    }

    void place(Item item, int col, int row) {
        Point pt = new Point(col, row);
        ArrayList<Item> existing = items.get(pt);
        if (null == existing) {
            existing = new ArrayList<Item>();
            existing.add(item);
            items.put(pt, existing);
          
         display.GetVision(vision.vision());
         display.update(item.getDescription(),col,row);  
        
        }
        else existing.add(item);
        
        display.GetVision(vision.vision());
        display.update(item.getDescription(),col,row);
    }
    
}