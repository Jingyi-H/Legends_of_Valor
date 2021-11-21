import java.util.ArrayList;

// subclass of item
public class Armor extends Item implements Tradable{
	// armed by heroes and can reduce damage from attack
	private int DamageReduction;
	
	public Armor(ArrayList<String> info) {
		this.name = info.get(0);
		this.cost = Integer.parseInt(info.get(1));
		this.level = Integer.parseInt(info.get(2));
		this.DamageReduction = Integer.parseInt(info.get(3));
		
	}

	public String toString() {
		String output = this.name + ": " + "damage_reduction=" + this.DamageReduction;
		return output;
	}

	@Override
	public boolean isTradable() {
		return true;
	}

	// 'get' methods
	public int getDamageReduction() {return this.DamageReduction;}

}
