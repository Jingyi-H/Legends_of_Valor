import java.util.ArrayList;


public class Cell {
	// Super class of cells on the game board

	protected ArrayList<String> marker;
	protected String name;
	protected boolean visited;

	//Default Constructor
	public Cell() {

		this.marker = new ArrayList<>();
		this.name = "";
		this.visited = false;

	}

	public ArrayList<String> getMarker() {
		return this.marker;
	}

	public String getName() {
		return this.name;
	}

	public void visit() {
		this.visited = true;
	}
}
