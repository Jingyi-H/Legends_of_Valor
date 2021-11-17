import java.util.ArrayList;

public class Bag {
	
	protected ArrayList<ArrayList<String>> FireSpellInventory;
	protected ArrayList<ArrayList<String>> IceSpellInventory;
	protected ArrayList<ArrayList<String>> LightningSpellInventory;
	protected ArrayList<ArrayList<String>> ArmorInventory;
	protected ArrayList<ArrayList<String>> PotionInventory;
	protected ArrayList<ArrayList<String>> WeaponInventory;
	
	public Bag() {
		
		this.FireSpellInventory = new ArrayList<ArrayList<String>>();
		this.IceSpellInventory = new ArrayList<ArrayList<String>>();
		this.LightningSpellInventory = new ArrayList<ArrayList<String>>();
		this.ArmorInventory = new ArrayList<ArrayList<String>>();
		this.PotionInventory = new ArrayList<ArrayList<String>>();
		this.WeaponInventory = new ArrayList<ArrayList<String>>();
		
	}
	
	//adding weapon to inventory
	public void addWeapon(ArrayList<String> a) {
		this.WeaponInventory.add(a);
	}
	
	//adding armor to inventory
	public void addArmor(ArrayList<String> a) {
		this.ArmorInventory.add(a);
	}
	
	//adding fire spell to inventory
	public void addFire(ArrayList<String> a) {
		this.FireSpellInventory.add(a);		
	}
	
	//adding ice spell to inventory
	public void addIce(ArrayList<String> a) {
		this.IceSpellInventory.add(a);		
	}
	
	//adding lightning spell to inventory
	public void addLightning(ArrayList<String> a) {
		this.LightningSpellInventory.add(a);
	}
	
	//adding potions to inventory
	public void addPotion(ArrayList<String> a) {
		this.PotionInventory.add(a);
	}

}
