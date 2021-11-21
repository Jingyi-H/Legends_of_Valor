public class CaveCell extends Cell {
	// Cave cells boost the agility of any hero who is inside them by 10%
	public CaveCell() {
		this.marker.add("/"+"--"+"\\");
		this.marker.add("\\"+"__"+"/");
		
		this.name = "CaveCell";
		
	}

}
