import java.util.ArrayList;

// subclass of item
public class Potion extends Item {
	// used by heroes and can recover hp/increase other attributes
	private int affect;
	private String attrString;
	private boolean[] attribute;	// record the attributes affected in boolean: health/mana/strength/dexterity/defense/agility
	
	public Potion(ArrayList<String> info) {
		// initialization
		this.name = info.get(0);
		this.cost = Integer.parseInt(info.get(1));
		this.level = Integer.parseInt(info.get(2));
		this.affect = Integer.parseInt(info.get(3));
		this.attrString = info.get(4);
		this.attribute = new boolean[]{false,false,false,false,false,false};
		
		String current = info.get(4);
		String[] output = current.split("/");
		for(String i: output) {
			if(i.equals("Health")) {this.attribute[0]=true;}
			else if(i.equals("Mana")) {this.attribute[1]=true;}
			else if(i.equals("Strength")) {this.attribute[2]=true;}
			else if(i.equals("Dexterity")) {this.attribute[3]=true;}
			else if(i.equals("Defense")) {this.attribute[4]=true;}
			else {this.attribute[5]=true;}
		}
		
	}

	public String toString() {
		String output = this.name + ": increment=" + this.affect + " attribute_affected=" + this.attrString;
		return output;
	}

	// 'get' methods
	public boolean[] getAttribute() {return this.attribute;}
	public int getAffect() {return this.affect;}

}
