// super class of weapon/armor/potion/spell
public abstract class Item {
    protected String name;
    protected int cost;
    protected int level;

    public String getName() {return this.name;}			// return name of item
    public int getLevel() {return this.level;}				// return the required level for getting the item
    public int getCost() {return this.cost;}              // return price of the item
}
