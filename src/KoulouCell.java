public class KoulouCell extends Cell{
	// Koulou cells buff the strength of any hero who is inside them by 10%
	public KoulouCell() {
		super();
		this.marker.add("|##|");
		this.marker.add("|##|");
		this.name = "KoulouCell";
	}

}
