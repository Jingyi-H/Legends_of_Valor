import java.util.ArrayList;

public class Weapon {
	
	private int Damage;
	private String name;
	private int level;
	private int cost;
	private int HandsRequired;
	
	public Weapon(ArrayList<String> info) {
		this.name = info.get(0);
		this.cost = Integer.parseInt(info.get(1));
		this.level = Integer.parseInt(info.get(2));
		this.Damage = Integer.parseInt(info.get(3));
		this.HandsRequired = Integer.parseInt(info.get(4));
		
	}
	
	public int getDamage() {return this.Damage;}
	public String getName() {return this.name;}
	public int getLevel() {return this.level;}
	public int getCost() {return this.cost;}
	public int getHandsRequired() {return this.HandsRequired;}

}
