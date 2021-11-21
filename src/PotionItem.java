import java.util.ArrayList;

// parse potion data from config file
public class PotionItem {

	private ArrayList<ArrayList<String>> items;
	
	//default constructor
	public PotionItem() {this.items = AskInput.read("Potions.txt");	}
	
	//get potion information
	public ArrayList<ArrayList<String>> getItem(){return this.items;}
}
