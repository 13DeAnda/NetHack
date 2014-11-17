/*
 * Items that can be used as weapons should subclass this class
 */
package netHack;


public abstract class Weapon extends Item {
    protected int damageAdjustment = 0; // adjust damage by this amount
    
    @Override
    // modify weapon's damage
    public void enchantWeapon() {
        damageAdjustment++;
    }
    
    // Get total damage caused in attack
    // Accounts for adjustments
    public int computeTotalDamage() {
        return computeBaseDamage() + damageAdjustment;
    }
    
    // different weapons produce different amounts of damage
    // For the current assignment, there is no need to do this,
    // and depending on whether you really need different algorithms
    // to compute the damage, you might be able to just have a
    // single algorithm here.
    public abstract int computeBaseDamage();
    
    // full description includes damage adjustment
    @Override
    public String getDescription() {
        if (!Knowledge.isIdentified(itemTypeID))
            return partialDescription;
        if (damageAdjustment >= 0)
            return "+" + damageAdjustment + " " + partialDescription;
        else return damageAdjustment + partialDescription;
    }
}