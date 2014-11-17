/*
 * Represents which Items are identified and which are not
 */
package netHack;

/**
 *
 * @author David Yang
 */
class Knowledge {
    // Stores whether a particular item type is identified, indexed by is ID
    private static boolean[] identified = new boolean[] {false, false, false, false, false,false,false,false,false};

    // returns whether the item is identified or not
    public static boolean isIdentified(int itemTypeID) {
        return identified[itemTypeID];
    }

    // mark an item as identified
    public static void identify(int itemTypeID) {
        identified[itemTypeID] = true;
    }
    
    // clear all knowledge
    public static void clear() {
        for (int item = 0; item < identified.length; item++)
            identified[item] = false;
    }
}