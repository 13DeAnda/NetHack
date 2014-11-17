
package netHack;

import java.util.Random;


public class PotionOfExtraHealing extends Potion{
int healpoints; //the points the potion heals;
	
	public PotionOfExtraHealing(){
        itemTypeID = 6;
        fullDescription = "potion of extra healing";
       
	}
	
	//returns the points healed
	public int getHealPoints(){
		return healpoints;
	}
	
	
	
	
	//when drink it helps the hero ith vision and lifepoints
	public void quaff(){
		Random r = new Random();
		
		//change vision to normal
		vision="normal";
		
		//set healing points depending of state of potion
		if(vision.equals("cursed")){
			healpoints = r.nextInt(32 - 4) + 4;
		}
		else if(vision.equals("uncursed")){
			healpoints = r.nextInt(48 - 6) + 6;
		}
		
		else if(vision.equals("blessed")){
			 healpoints = r.nextInt(64 - 8) + 8;
		}
		

		
	}
}