import java.util.ArrayList;

// subclass of item
public class Weapon extends Item implements Tradable {
	// armed by heroes and can increase damage by heroes when taking regular attack
	private int Damage;
	private int HandsRequired;
	
	public Weapon(ArrayList<String> info) {
		this.name = info.get(0);
		this.cost = Integer.parseInt(info.get(1));
		this.level = Integer.parseInt(info.get(2));
		this.Damage = Integer.parseInt(info.get(3));
		this.HandsRequired = Integer.parseInt(info.get(4));
		
	}

	public String toString() {
		String output = this.name + ": " + "damage=" + this.Damage + " hands_required=" + this.HandsRequired;
		return output;
	}

	@Override
	public boolean isTradable() {
		return true;
	}

	@Override
	public boolean isBuyable() {
		return true;
	}

	@Override
	public boolean isSellable() {
		return true;
	}

	// getter and setter
	public int getDamage() {return this.Damage;}
	public int getHandsRequired() {return this.HandsRequired;}

}
