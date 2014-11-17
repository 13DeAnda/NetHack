
package netHack;


class ScrollOfAmnesia extends Scroll {

    public ScrollOfAmnesia() {
        itemTypeID = 1;
        fullDescription = "Scroll of Amnesia";
    }
    
    @Override
    public void read() {
        Knowledge.clear();
    }
}