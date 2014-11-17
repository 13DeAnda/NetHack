/*
 * The general scroll class
 */
package netHack;

abstract class Scroll extends Item {
    
    public Scroll() {
        partialDescription = "scroll";
    }
    
    // By default, reading a scroll identifies it
    @Override
    public void read() {
        Knowledge.identify(itemTypeID);
    }
    
}