package netHack;

/*Nora De Anda
 *basic console-based display for the game in a class called nethack
 * 
 */


import java.awt.Point;
import java.util.Random;

public class ConsoleDisplay {
String displayString=""; //to store the console display
char[][] console =new char[15][40]; //shows current state
char[][] hallucination =new char[15][40]; // changes the vision to hallucinaiton form
char[][] blind=new char[15][40]; // blinds the display
String vision=""; 

//initialize the display
public ConsoleDisplay(){
	for(int i=0; i<15;i++){
		for(int j=0; j<40;j++){
			console[i][j]='.';
					
		}
	}
}

//gets the hero Character
public void GetVision(String vision){
	this.vision=vision;
}

//returns icon of item name
public char getItemType(String symbolName){
	char i='.';
	if(symbolName.equals("potion"))
		i='!';
	else 	if( symbolName.equals("scroll"))
		i='?';
	else if ( symbolName.equals("."))
		i='.';
	else i=')';
	
	return i;
}

//creates the blind based on the current console positioning
public void blind(){
	for(int i=0; i<15;i++){
		for(int j=0; j<40;j++){
			if(console[i][j]=='@')
				blind[i][j]='@';
			else
				blind[i][j]=' ';
		}
	}
}

//creates the hallucination based on the current console positioning
public void hallucinate(){
	 Random r = new Random();
	 String player="@ABCDEFGHIK";
	 String  things="!)?";
	 
	 
	for(int i=0; i<15;i++){
		for(int j=0; j<40;j++){
			if(console[i][j]=='@')
				hallucination[i][j]=player.charAt(r.nextInt(player.length()));
			else if (console[i][j]=='.')
				hallucination[i][j]='.';
			else
				hallucination[i][j]=things.charAt(r.nextInt(things.length()));
		}
	}
}


//updates the console with the map of characters and items
public void update(String symbolName,int col, int row){

	if(symbolName.equals("@")){
		console[col][row]='@';
		printVision();
		displayString="";
	}
		
		else{
			console[col][row]=getItemType(symbolName);
			printVision();
			displayString="";
					
		}


}

//prints the state of vision

public void printVision(){
	if(vision.equals("blind")){
		blind();
		System.out.println(ToString(blind));
		}
		
	else if(vision.equals("hallucinate")){
		hallucinate();
		System.out.println(ToString(hallucination));
		 
			}
	else
		System.out.println(ToString(console));
}

//returns the string representation of current game display
public String ToString(char[][] disp){
	for(int i=0; i<15;i++){
		for(int j=0; j<40;j++){
			displayString+=disp[i][j];
		}
		displayString+="\n";
		}
	displayString+="--------------------------------------------------------\n";
	return displayString;
}

//changes the past position of a character to a blank position
public void pastPosition(Point p){
	console[p.x][p.y]='.';
}


}
