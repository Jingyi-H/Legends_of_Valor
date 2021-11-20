import java.util.ArrayList;

public class Bag {
	
	protected ArrayList<Armor> ArmorInventory;
	protected ArrayList<Weapon> WeaponInventory;
	protected ArrayList<Spell> SpellInventory;
	protected ArrayList<Potion> PotionInventory;
	
	public Bag() {
		
		this.ArmorInventory = new ArrayList<Armor>();
		this.WeaponInventory = new ArrayList<Weapon>();
		this.SpellInventory = new ArrayList<Spell>();
		this.PotionInventory = new ArrayList<Potion>();
		
	}
	
	
	public void addArmor(Armor a) {this.ArmorInventory.add(a);}
	public void addWeapon(Weapon a) {this.WeaponInventory.add(a);}
	public void addSpell(Spell a) {this.SpellInventory.add(a);}
	public void addPotion(Potion a) {this.PotionInventory.add(a);}
	
	public ArrayList<Armor> getArmorInventory(){return this.ArmorInventory;}
	public ArrayList<Weapon> getWeaponInventory(){return this.WeaponInventory;}
	public ArrayList<Spell> getSpellInventory(){return this.SpellInventory;}
	public ArrayList<Potion> getPotionInventory() { return PotionInventory; }

	public Potion removePotion(int a) {
	    Potion potion = this.PotionInventory.remove(a);
	    return potion;
    }

    public String toString() {
	    String info = "";
        info += "============ Weapon ============\n";
        for (Weapon i : getWeaponInventory()) {
            info += i.getName() + "\n";
        }
		info += "============ Armor ============\n";
		for (Armor i : getArmorInventory()) {
			info += i.getName() + "\n";
		}
        info += "============ Spell ============\n";
        for (Spell i : getSpellInventory()) {
            info += i.getName() + "\n";
        }
        info += "============ Potion ============\n";
        for (Potion i : getPotionInventory()) {
            info += i.getName() + "\n";
        }
        return info;
    }

}
