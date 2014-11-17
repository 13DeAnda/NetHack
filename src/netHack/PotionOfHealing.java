
package netHack;

import java.util.Random;

public class PotionOfHealing extends Potion {
	int healpoints; //the points the potion heals;
	

	public PotionOfHealing(){
        itemTypeID = 8;
        fullDescription = "potion of healing";
	}
	
	
	public void quaff(){
		Random r = new Random();
		
	
		//if not cursed and blind cure
		
		if(vision.equals("blind") && !(state().equals("cursed")))
			vision="normal";
		
		
		//set healing points depending of state of potion
		if(state().equals("cursed")){
			healpoints = r.nextInt(16 - 4) + 4;
		}
		else if(state().equals("uncursed")){
			healpoints = r.nextInt(24 - 6) + 6;
		}
		
		else if(state().equals("blessed")){
			 healpoints = r.nextInt(32 - 8) + 8;
		}
		

		
	}
	
}