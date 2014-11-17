
package netHack;

import java.awt.Point;
import java.util.ArrayList;


class Character {
    protected String name;
    protected ArrayList<Item> inventory;
    protected int hitPoints;    // when it goes to zero or below, the character dies
    protected Item wielded;
    protected Point position;
    protected String vision="normal"; //states what is the vision of the hero

    // initialize with name of character
    public Character(String _name, int _hitPoints) {
        name = _name;
        inventory = new ArrayList<>();
        hitPoints = _hitPoints;
        position = new Point();
    }

    // Display list of items in inventory
    public void listInventory() {
        System.out.println(name + "'s possessions: ");
        for (int index = 0; index < inventory.size(); index++)
            System.out.println(index + ". " + inventory.get(index).getDescription());
    }

    // Add an item to your inventory
    public void pickup(Item item) {
        inventory.add(item);
    }

    // Try to read an item. If you are successful, then the item should be removed from your inventory
    public void read(int index) {
        Item item = inventory.get(index);
       if(!item.getDescription().equals("potion")){
        item.read();
        inventory.remove(item);
       }
    }

    public void wield(int itemIndex) {
        wielded = inventory.get(itemIndex);
    }
    
    public int getHitPoints() { return hitPoints; }
    
    public String getName() { return name; }

    public Item getWeapon() {
        return wielded;
    }

    public void setPosition(int col, int row) {
        position.x = col;
        position.y = row;
    }
    
    public Point getPosition() {
        return position;
    }

    public Item getItem(int index) {
        return inventory.get(index);
    }

    void attacked(int damage) {
        hitPoints -= damage;
    }

    int computeDamage() {
        if (null == wielded)
            return 0;
        else return wielded.computeTotalDamage();
    }
    
    //to attack
    public void attack(){
    	
    }
    
    
    
    
    
    // the to drink a potion and acquire it's effects
   public void quaff(int i){
	   
	 
	   inventory.get(i).getVision(vision);//gives vision status to the potion
	   inventory.get(i).quaff(); //gets the
	   vision=inventory.get(i).returnVision();//returns the new vision
	   heal(inventory.get(i).getHealPoints());//heals the character with the points won
	   System.out.println("TEST you just drank the "+inventory.get(i).getDescription()+inventory.get(i).returnVision());
   }
   
   //changes the vision of the hero
   public void changeVision(String v){
	   vision=v;
   }
   
   //returns the current vision of the hero
   public String vision(){
	   return vision;
   }
   
   //heals the hero by the specified points
   public void heal(int i){
	   hitPoints += i;
   }
    
    
}