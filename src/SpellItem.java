import java.util.ArrayList;

// parse spell data from config file
public class SpellItem {
	
	private ArrayList<ArrayList<String>> FireSpell;
	private ArrayList<ArrayList<String>> IceSpell;
	private ArrayList<ArrayList<String>> LightningSpell;
	
	//default constructors
	public SpellItem() {
		this.FireSpell = AskInput.read("FireSpells.txt");
		this.IceSpell = AskInput.read("IceSpells.txt");
		this.LightningSpell = AskInput.read("LightningSpells.txt");
	}
	
	//get firing spell info
	public ArrayList<ArrayList<String>> getFire(){return this.FireSpell;}
	
	//get ice spell information
	public ArrayList<ArrayList<String>> getIce(){return this.IceSpell;}
	
	//get lightning spell informaiton
	public ArrayList<ArrayList<String>> getLightning(){return this.LightningSpell;}

}
