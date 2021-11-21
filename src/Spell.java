import java.util.ArrayList;

// subclass of item
public class Spell extends Item implements Tradable {
	// used in battle and can affect monsters' attributes
	private int Damage;
	private int ManaCost;
	private String type;
	
	public Spell(ArrayList<String> info, int type) {
		// initialize attributes with strings read from config files
		this.name = info.get(0);
		this.cost = Integer.parseInt(info.get(1));
		this.level = Integer.parseInt(info.get(2));
		this.Damage = Integer.parseInt(info.get(3));
		this.ManaCost = Integer.parseInt(info.get(4));
		if(type == 2) {this.type = "Fire";}
		else if(type == 3) {this.type = "Ice";}
		else {this.type = "Lighting";}
	}

	public String toString() {
		// return basic info of spell
		String output = this.name + ": type=" + this.type + " mana_cost=" + this.ManaCost;
		return output;
	}

	@Override
	public boolean isTradable() {
		return true;
	}

	@Override
	public boolean isBuyable() {
		return false;
	}

	@Override
	public boolean isSellable() {
		return false;
	}

	public int getDamage() {return this.Damage;}			// return damage of spell
	public int getManaCost() {return this.ManaCost;}		// return mana cost for casting the spell
	public String getType() {return this.type;}			// return the type of spell: Fire/Ice/Lightning

}
