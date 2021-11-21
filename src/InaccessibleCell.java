public class InaccessibleCell extends Cell {
    // cells on which heroes and monsters cannot move into
    public InaccessibleCell() {
        super();
        marker.add("XXXX");
        marker.add("XXXX");
        name = "InaccessibleCell";
    }
}
