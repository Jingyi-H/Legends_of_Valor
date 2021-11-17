import java.util.ArrayList;



public class Weapon {
	
	private ArrayList<ArrayList<String>> items;
	
	//default constructor
	public Weapon() {		
		this.items = AskInput.read("Weaponry.txt");		
	}
	
	//get item information
	public ArrayList<ArrayList<String>> getItem(){
		return this.items;
	}
	
	

}
