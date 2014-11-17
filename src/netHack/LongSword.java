/*
 * Long sword -- has some unique properties in nethack
 */
package netHack;


class LongSword extends Weapon {
    
    public LongSword() {
        itemTypeID = 4;
        partialDescription = "long sword";
    }

    // Compute base damage of this weapon
    @Override
    public int computeBaseDamage() {
        // @TODO replace with a randomized calculation
        return 5;   // "stub" implementation
    }
    
}