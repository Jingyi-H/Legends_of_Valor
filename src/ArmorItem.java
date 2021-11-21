import java.util.ArrayList;

// parse armor data from config file
public class ArmorItem {
	
	private ArrayList<ArrayList<String>> items;
	
	public ArmorItem() {this.items = AskInput.read("Armory.txt");	}
	
	public ArrayList<ArrayList<String>> getItem(){return this.items;}

}
