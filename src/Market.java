import java.util.ArrayList;

//Zhu's Assignment
public class Market {
	
	private Armor armoritems;
	private Weapon weaponitems;
	private Spell spellitems;
	private Potion potionitems;
	
	public Market() {
		
		this.armoritems = new Armor();
		this.weaponitems = new Weapon();
		this.spellitems = new Spell();
		this.potionitems = new Potion();
		
	}
	
	public void showItems() {
		
		System.out.println("Armory:Name/cost/required level/damage reduction");
		for(int i = 0; i<5;i++) {
			System.out.print(i+" -- ");
			System.out.println(this.armoritems.getItem().get(i));
		}
		
		System.out.println("Weaponry:Name/cost/level/damage/required hands");
		for(int i = 0;i<6;i++) {
			System.out.print((i+5)+" -- ");
			System.out.println(this.weaponitems.getItem().get(i));
		}
		
		System.out.println("FireSpells:Name/cost/required level/damage/mana cost");
		for(int i = 0;i<5;i++) {
			System.out.print((i+11)+" -- ");
			System.out.println(this.spellitems.getFire().get(i));
		}
		
		System.out.println("IceSpells:Name/cost/required level/damage/mana cost");
		for(int i = 0;i<4;i++) {
			System.out.print((i+16)+" -- ");
			System.out.println(this.spellitems.getIce().get(i));
		}
		
		System.out.println("LightningSpells:Name/cost/required level/damage/mana cost");
		for(int i = 0;i<4;i++) {
			System.out.print((i+20)+" -- ");
			System.out.println(this.spellitems.getLightning().get(i));
		}
		
		System.out.println("Potions:Name/cost/required level/attribute increase/attribute affected");
		for(int i = 0;i<6;i++) {
			System.out.print((i+24)+" -- ");
			System.out.println(this.potionitems.getItem().get(i));
		}
		
	}
	
	//get armor for sales
	public ArrayList<ArrayList<String>> getarm(){
		return this.armoritems.getItem();
	}
	
	//get weapon for sales
	public ArrayList<ArrayList<String>> getwep(){
		return this.weaponitems.getItem();
	}
	
	//get fire spell for sell
	public ArrayList<ArrayList<String>> getfire(){
		return this.spellitems.getFire();
	}
	
	//get ice spell for sales
	public ArrayList<ArrayList<String>> getice(){
		return this.spellitems.getIce();
	}
	
	//get lighting for sales
	public ArrayList<ArrayList<String>> getlightning(){
		return this.spellitems.getLightning();
	}
	
	//get potion for sales
	public ArrayList<ArrayList<String>> getpo(){
		return this.potionitems.getItem();
	}

}
