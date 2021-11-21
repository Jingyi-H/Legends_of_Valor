public class Sorcerer extends Hero {

    public Sorcerer() { }

    public Sorcerer(String name, int mana, int strength, int agility, int dexterity, int starting_money, int starting_exp) {
        super(name, mana, strength, agility, dexterity, starting_money, starting_exp);
    }

    public void levelUp() {
        // Sorcerers are favored on the dexterity and the agility.
        super.levelUp();
        strength = (int)(strength * 1.05);
        agility = (int)(agility * 1.10);
        dexterity = (int)(dexterity * 1.10);
    }

}
