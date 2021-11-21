// subclass of hero
public class Paladin extends Hero {

    public Paladin() { }

    public Paladin(String name, int mana, int strength, int agility, int dexterity, int starting_money, int starting_exp) {
        super(name, mana, strength, agility, dexterity, starting_money, starting_exp);
    }

    public void levelUp() {
        // Paladins are favored on strength and dexterity
        super.levelUp();
        strength = (int)(strength * 1.10);
        agility = (int)(agility * 1.05);
        dexterity = (int)(dexterity * 1.10);
    }

}