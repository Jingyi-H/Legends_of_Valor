import java.util.ArrayList;

public class Bag {
	// heroes bag with armor/weapon/spell/potion inventories
	protected ArrayList<Armor> ArmorInventory;
	protected ArrayList<Weapon> WeaponInventory;
	protected ArrayList<Spell> SpellInventory;
	protected ArrayList<Potion> PotionInventory;
	
	public Bag() {
		// initialization
		this.ArmorInventory = new ArrayList<Armor>();
		this.WeaponInventory = new ArrayList<Weapon>();
		this.SpellInventory = new ArrayList<Spell>();
		this.PotionInventory = new ArrayList<Potion>();
		
	}
	
	public void addArmor(Armor a) {this.ArmorInventory.add(a);}				// put armor into bag
	public void addWeapon(Weapon a) {this.WeaponInventory.add(a);}				// put weapon into bag
	public void addSpell(Spell a) {this.SpellInventory.add(a);}				// put spell into bag
	public void addPotion(Potion a) {this.PotionInventory.add(a);}				// put potion into bag

	// inventories 'get' methods
	public ArrayList<Armor> getArmorInventory(){return this.ArmorInventory;}
	public ArrayList<Weapon> getWeaponInventory(){return this.WeaponInventory;}
	public ArrayList<Spell> getSpellInventory(){return this.SpellInventory;}
	public ArrayList<Potion> getPotionInventory() { return PotionInventory; }

	public Potion removePotion(int a) {
		// remove and return potion by index
	    Potion potion = this.PotionInventory.remove(a);
	    return potion;
    }

    public String toString() {
		// print bag
	    String info = "";
        info += "============ Weapon ============\n";
        if (getWeaponInventory().size() == 0) {
        	info += "None\n";
		}
        for (Weapon i : getWeaponInventory()) {
            info += i.getName() + "\n";
        }
		info += "============ Armor ============\n";
		if (getArmorInventory().size() == 0) {
			info += "None\n";
		}
        for (Armor i : getArmorInventory()) {
			info += i.getName() + "\n";
		}
        info += "============ Spell ============\n";
		if (getSpellInventory().size() == 0) {
			info += "None\n";
		}
        for (Spell i : getSpellInventory()) {
            info += i.getName() + "\n";
        }
        info += "============ Potion ============\n";
		if (getPotionInventory().size() == 0) {
			info += "None\n";
		}
        for (Potion i : getPotionInventory()) {
            info += i.getName() + "\n";
        }
        return info;
    }

}
