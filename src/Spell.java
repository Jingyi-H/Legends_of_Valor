import java.util.ArrayList;

public class Spell {
	//
	private int Damage;
	private String name;
	private int level;
	private int cost;
	private int ManaCost;
	private String type;
	
	public Spell(ArrayList<String> info, int type) {
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
		String output = this.name + ": type=" + this.type + " mana_cost=" + this.ManaCost;
		return output;
	}
	public int getDamage() {return this.Damage;}
	public String getName() {return this.name;}
	public int getLevel() {return this.level;}
	public int getCost() {return this.cost;}
	public int getManaCost() {return this.ManaCost;}
	public String getType() {return this.type;}

}
