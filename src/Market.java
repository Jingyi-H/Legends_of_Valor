import java.util.ArrayList;



//Zhu's Assignment
public class Market {
	
	public ArmorItem ai;
	public WeaponItem wi;
	public SpellItem si;
	public PotionItem pi;
	
	public Market() {
		
		this.ai = new ArmorItem();
		this.wi = new WeaponItem();
		this.si = new SpellItem();
		this.pi = new PotionItem();
		
	}
	
	//display all items for sale, just all items
	public void showitems() {
		
		System.out.println("Armory:Name/cost/required level/damage reduction");
		for(int i = 0; i<5;i++) {
			System.out.print(i+" -- ");
			System.out.println(this.ai.getItem().get(i));
		}
		
		System.out.println("Weaponry:Name/cost/level/damage/required hands");
		for(int i = 0;i<6;i++) {
			System.out.print((i+5)+" -- ");
			System.out.println(this.wi.getItem().get(i));
		}
		
		System.out.println("FireSpells:Name/cost/required level/damage/mana cost");
		for(int i = 0;i<5;i++) {
			System.out.print((i+11)+" -- ");
			System.out.println(this.si.getFire().get(i));
		}
		
		System.out.println("IceSpells:Name/cost/required level/damage/mana cost");
		for(int i = 0;i<4;i++) {
			System.out.print((i+16)+" -- ");
			System.out.println(this.si.getIce().get(i));
		}
		
		System.out.println("LightningSpells:Name/cost/required level/damage/mana cost");
		for(int i = 0;i<4;i++) {
			System.out.print((i+20)+" -- ");
			System.out.println(this.si.getLightning().get(i));
		}
		
		System.out.println("Potions:Name/cost/required level/attribute increase/attribute affected");
		for(int i = 0;i<6;i++) {
			System.out.print((i+24)+" -- ");
			System.out.println(this.pi.getItem().get(i));
		}
		
	}
	
	//get armor for sales
	public ArrayList<ArrayList<String>> getarm(){
		return this.ai.getItem();
	}
	
	//get weapon for sales
	public ArrayList<ArrayList<String>> getwep(){
		return this.wi.getItem();
	}
	
	//get fire spell for sell
	public ArrayList<ArrayList<String>> getfire(){
		return this.si.getFire();
	}
	
	//get ice spell for sales
	public ArrayList<ArrayList<String>> getice(){
		return this.si.getIce();
	}
	
	//get lighting for sales
	public ArrayList<ArrayList<String>> getlightning(){
		return this.si.getLightning();
	}
	
	//get potion for sales
	public ArrayList<ArrayList<String>> getpo(){
		return this.pi.getItem();
	}

}
