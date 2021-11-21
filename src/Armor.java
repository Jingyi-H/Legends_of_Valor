import java.util.ArrayList;

// subclass of item
public class Armor {
	// armed by heroes and can reduce damage from attack
	private int DamageReduction;
	private String name;
	private int level;
	private int cost;
	
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

	// 'get' methods
	public String getName() {return this.name;}
	public int getLevel() {return this.level;}
	public int getDamageReduction() {return this.DamageReduction;}
	public int getCost() {return this.cost;}

}
