import java.util.ArrayList;



public class WeaponItem {
	
	private ArrayList<ArrayList<String>> items;
	
	//default constructor
	public WeaponItem() {this.items = AskInput.read("Weaponry.txt");}
	
	//get item information
	public ArrayList<ArrayList<String>> getItem(){return this.items;}

}
