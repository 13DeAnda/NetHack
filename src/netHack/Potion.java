
//The class extends a new item of potions which can affect the character if drank
package netHack;

public class Potion extends Item{

	boolean empty=false;
	String status="nocursed"; //records wether the potion is cursed,blesed or normal
	
	
	public Potion(){
		partialDescription = "potion";
	}
	

	//sets the enchanted state of the potion
	public void setState(String s){
		status=s;
	}
	
	//checks the enchanted state of the potion
	public String state(){
		return status;
	}
	
	public void quaff(){
		Knowledge.identify(itemTypeID);
		
	}
	
	
	public void getVision(String vision) {
		 this.vision=vision;
	}
	}
	

	
