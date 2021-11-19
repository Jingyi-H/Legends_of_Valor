import java.util.ArrayList;


public class Cell {

		protected ArrayList<String> marker;
		protected String name;
		
		//Default Constructor
		public Cell() {
			
			this.marker = new ArrayList<String>();
			this.name = "";
			
		}
		
		public ArrayList<String> getMarker() {
			return this.marker;
		}
		
		public String getName() {
			return this.name;
		}
}
