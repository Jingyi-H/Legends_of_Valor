import java.util.ArrayList;



public class Potion {
	
	private ArrayList<ArrayList<String>> items;
	
	//default constructor
	public Potion() {		
		this.items = AskInput.read("Potions.txt");		
	}
	
	//get potions information
	public ArrayList<ArrayList<String>> getItem(){
		return this.items;
	}

}
