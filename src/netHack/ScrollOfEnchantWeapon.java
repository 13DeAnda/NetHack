/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package netHack;

class ScrollOfEnchantWeapon extends Scroll {

    protected Character hero;
    
    public ScrollOfEnchantWeapon(Character _hero) {
        itemTypeID = 2;
        fullDescription = "Scroll of Enchant Weapon";
        hero = _hero;
    }
    
    @Override
    public void read() {
        Item weapon = hero.getWeapon();
        weapon.enchantWeapon();
        super.read();
    }
}