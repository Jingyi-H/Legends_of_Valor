public class BushCell extends Cell{
	// Bush cells increase the dexterity of any hero who is inside them by 10%.
	public BushCell() {
		super();
		this.marker.add("^^^^");
		this.marker.add("^^^^");
		this.name = "BushCell";
	}

}
