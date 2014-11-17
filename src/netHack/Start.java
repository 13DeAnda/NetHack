package netHack;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;


public class Start {
    static String display="";
    static Character hero = new Character("Prim",12);
    static Floor floor = new Floor();      
    static final JTextArea commentTextArea =  new JTextArea(display,30,20);
    static JFrame frame = new JFrame("NetHack");

	
  public static void main(String args[]) throws Exception {
      floor.place(hero,2,3);  //setting the hero in
	
     //	GUI  
	
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JTextField command = new JTextField();
    frame.add(command, BorderLayout.NORTH);
    
    
    
    frame.add(commentTextArea );
    
    
    //The key events recorded
    KeyListener keyListener = new KeyListener() {
      public void keyPressed(KeyEvent keyEvent) {
    	  Display("Pressed", keyEvent);
      }

      public void keyReleased(KeyEvent keyEvent) {
    	  //Display("Released", keyEvent);
      }

      public void keyTyped(KeyEvent keyEvent) {
    	  Display("Typed", keyEvent);
      }
      
      //Redirecting to the GUI window
      private void updateTextArea(final String text) {
    	  SwingUtilities.invokeLater(new Runnable() {
    	    public void run() {
    	       
    	    	commentTextArea.append(text);
    	    	
    	    	
    	    }
    	  });
    	}
    	 
    	private void redirectSystemStreams() {
    	  OutputStream out = new OutputStream() {
    	   
    	    public void write(int b) throws IOException {
    	      updateTextArea(String.valueOf((char) b));
    	    } 
    	 
    	    
    	    public void write(byte[] b, int off, int len) throws IOException {
    	        commentTextArea.setText("");
    	        updateTextArea(new String(b, off, len));
    	    }
    	 
    	    
    	    public void write(byte[] b) throws IOException {
    	      write(b, 0, b.length);
    	    }
    	  };
    	 
    	  System.setOut(new PrintStream(out, true));
    	  System.setErr(new PrintStream(out, true));
    	}    
       
      
    	//reads and displays
      private void Display(String title, KeyEvent keyEvent) {
          
        int keyCode = keyEvent.getKeyCode();
        String keyText = KeyEvent.getKeyText(keyCode);
        
        //reading in the input of the user
        	if (keyText =="Escape"){
        		System.out.println("escape");
        	}
        	else if (keyText == "Up"){
        		floor.move(hero,6);
        		redirectSystemStreams();		
        	}
        	else if(keyText =="Down"){
        	    floor.move(hero,2);
        		redirectSystemStreams();
        	}
        	else if(keyText =="Right"){
        	    floor.move(hero,4);
        	    redirectSystemStreams();
        	}
        	else if(keyText =="Left"){
        	    floor.move(hero,0);
        	    redirectSystemStreams();
        	}
        	else if(keyText =="a"){
        		
        	}
        	else if(keyText =="i"){
        	    hero.listInventory();
        	    redirectSystemStreams();
        		
        	}       	
        }
    };
    command.addKeyListener(keyListener);


    frame.setSize(300, 300);
    frame.setVisible(true);
  }
}