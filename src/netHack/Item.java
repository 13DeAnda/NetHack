/*
 * The root class for the hierarchy of items.
 */
package netHack;

abstract class Item {
    protected int itemTypeID;
    protected String fullDescription, partialDescription;
	String vision="normal"; //passes the state vision of the hero

    // Default version of read() -- you cannot read most items, like potions, helmets, etc.
    public void read() {
        throw new UnsupportedOperationException("Cannot be read");
    }

    // Return description of item
    public String getDescription() {
        if (Knowledge.isIdentified(itemTypeID))
            return fullDescription;
        else return partialDescription;
    }

    // modify item's damage
    public void enchantWeapon() {
        // Regular items are not helped
    }
    
    // default = attacking without a weapon = 0 damage
    public int computeTotalDamage() {
        return 0;
    }
    //when a potion drinks
    public void quaff(){
    	throw new UnsupportedOperationException("Cannot be drinked");
    }
    
    //gives the potion the vision status to change
	public void getVision(String vision) {
		this.vision=vision;
		
	}
	
	//returns the points to be healed
	public int getHealPoints(){
		return 0;
	}
	
	//returns the new vision
	public String returnVision(){

		return vision;
		
	}
    
}