
package netHack;

public class PotionOfBlindness extends Potion{
	
	//when drank sets the mode of hero sight to blind
	public PotionOfBlindness(){
        itemTypeID = 5;
        fullDescription = "potion of blindness";
	}
	
	
	public void quaff(){
		vision="blind";
	}
	
	
	
}