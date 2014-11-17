
package netHack;

public class PotionOfHallucination extends Potion {
	//change the usermode to hallucinating
	public PotionOfHallucination(){
        itemTypeID = 7;
        fullDescription = "potion of hallucination";
	}
	
	public void quaff(){
		vision="hallucinate";
	}
	
	
	
}