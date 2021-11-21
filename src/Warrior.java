// subclass of Hero
public class Warrior extends Hero {

    public Warrior() {
        super();
    }

    public Warrior(String name, int mana, int strength, int agility, int dexterity, int starting_money, int starting_exp) {
        super(name, mana, strength, agility, dexterity, starting_money, starting_exp);
    }

    public void levelUp() {
        // Warriors are favored on strength and agility.
        super.levelUp();
        strength = (int)(strength * 1.10);
        agility = (int)(agility * 1.10);
        dexterity = (int)(dexterity * 1.05);
    }

}
