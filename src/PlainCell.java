public class PlainCell extends Cell {
    // Cells with no special attributes in this game
    public PlainCell() {
        super();
        marker.add("    ");
        marker.add("    ");
        name = "PlainCell";
    }
}
