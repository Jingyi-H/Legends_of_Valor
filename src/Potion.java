import java.util.ArrayList;

public class Potion {
	
	private String name;
	private int level;
	private int cost;
	private int affect;
	private boolean[] attribute;
	
	public Potion(ArrayList<String> info) {
		System.out.println(info);
		this.name = info.get(0);
		this.cost = Integer.parseInt(info.get(1));
		this.level = Integer.parseInt(info.get(2));
		this.affect = Integer.parseInt(info.get(3));
		this.attribute = new boolean[]{false,false,false,false,false,false};
		
		String current = info.get(4);
		String[] output = current.split("\\w+");
		for(String i: output) {
			if(i.equals("Health")) {this.attribute[0]=true;}
			else if(i.equals("Mana")) {this.attribute[1]=true;}
			else if(i.equals("Strength")) {this.attribute[2]=true;}
			else if(i.equals("Dexterity")) {this.attribute[3]=true;}
			else if(i.equals("Dexterity")) {this.attribute[4]=true;}
			else {this.attribute[5]=true;}
		}
		
	}
	
	public String getName() {return this.name;}
	public int getLevel() {return this.level;}
	public int getCost() {return this.cost;}
	public boolean[] getAttribute() {return this.attribute;}
	public int getAffect() {return this.affect;}

}
