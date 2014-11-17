
package netHack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


class ScrollOfIdentify extends Scroll {
    Character reader;

    public ScrollOfIdentify(Character _reader) {
        itemTypeID = 3;
        fullDescription = "Scroll of Identify";
        reader = _reader;
    }
    
    @Override
    public void read() {
        try {
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Which item would you like to identify?");
            reader.listInventory();
            String selection = stdin.readLine();
            Knowledge.identify(reader.getItem(Integer.parseInt(selection)).itemTypeID);
            super.read();
        } catch (IOException ex) {
            Logger.getLogger(ScrollOfIdentify.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}