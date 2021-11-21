import java.util.*;

// Game characters played by computer
public abstract class Monster implements CharacterBehavioral {
    String name;
    int level;
    int hp;
    int defense;
    int damage;
    int dodgeChance;

    public Monster() {}

    public Monster(String name, int level, int damage, int defense, int dodgeChance) {
        this.name = name;
        this.level = level;
        this.hp = this.level * 500;
        this.damage = damage;
        this.defense = defense;
        this.dodgeChance = dodgeChance;
    }

    public void setAttributes(List<String> attrs) {
        this.name = attrs.get(0);
        this.level = Integer.parseInt(attrs.get(1));
        this.hp = this.level * 500;
        this.damage = Integer.parseInt(attrs.get(2));
        this.defense = Integer.parseInt(attrs.get(3));
        this.dodgeChance = Integer.parseInt(attrs.get(4));
    }

    public int attack() {
        int hurtValue = this.damage;
        System.out.println("[Monster] " + getName() + "> attack: damage=" + hurtValue);
        return hurtValue;
    }

    public boolean dodge() {
        if (Math.random() < this.dodgeChance * 0.01) {
            System.out.println("[Monster] " + this.name + " dodges the attack!");
            return true;
        }
        return false;
    }

    public void defend(int damage) {
        int newhp = this.hp - damage + this.defense;
        if (newhp < 0) newhp = 0;
        if (newhp > this.hp) newhp = this.hp;
        setHp(newhp);
    }

    public void reduceDamage(double perc) {
        int newDamage = (int) (this.damage * (1-perc));
        setDamage(newDamage);
    }

    public void reduceDefense(double perc) {
        int newDefense = (int) (this.defense * (1-perc));
        setDefense(newDefense);
    }

    public void reduceDodge(double perc) {
        int newDodge = (int) (this.dodgeChance * (1-perc));
        setDodgeChance(newDodge);
    }

    // print methods
    public void printInfo() {
        System.out.println(getName());
        System.out.println("level: " + getLevel());
        System.out.println("hp: " + getHp());
        System.out.println("damage" + getDamage());
        System.out.println("defense: " + getDefense());
        System.out.println("dodgeChance" + getDodgeChance());
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDodgeChance() {
        return dodgeChance;
    }

    public void setDodgeChance(int dodgeChance) {
        this.dodgeChance = dodgeChance;
    }
}
