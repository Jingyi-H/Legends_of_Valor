import java.util.ArrayList;



public class Armor {
	//armor information
	private ArrayList<ArrayList<String>> items;
	
	//default constructor
	public Armor() {
		this.items = AskInput.read("Armory.txt");		
	}
	
	//get method
	public ArrayList<ArrayList<String>> getItem(){
		return this.items;
	}
	
}
