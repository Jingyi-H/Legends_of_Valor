import java.util.ArrayList;
import java.util.List;

public abstract class Hero {
    String name;
    int level;
    int hp;
    int exp;
    int mana;
    int maxHp;
    int money;
    int defense;
    int strength;
    int dexterity;
    int agility;
    static final int HANDS = 2;
    int emptyHands;

    Armor armor;
    List<Weapon> weapon;
    Bag bag;

    public Hero() {

    }

    public Hero(String name, int mana, int strength, int agility, int dexterity, int starting_money, int starting_exp) {
        this.name = name;
        this.mana = mana;
        this.strength = strength;
        this.dexterity = dexterity;
        this.agility = agility;
        this.exp = starting_exp;
        this.money = starting_money;
        // init
        this.level = 1;
        this.maxHp = this.hp = this.level * 100;
        this.defense = 0;
        this.bag = new Bag();
        this.emptyHands = HANDS;
        this.weapon = new ArrayList<>();
    }

    public void setAttributes(List<String> attrs) {
        //split by any amount of whitespace using regex sourced from: https://javarevisited.blogspot.com/2016/10/how-to-split-string-in-java-by-whitespace-or-tabs.html
        this.name = attrs.get(0);
        this.mana = Integer.parseInt(attrs.get(1));
        this.strength = Integer.parseInt(attrs.get(2);
        this.agility = Integer.parseInt(attrs.get(3));
        this.dexterity = Integer.parseInt(attrs.get(4));
        this.money = Integer.parseInt(attrs.get(5));
        this.exp = Integer.parseInt(attrs.get(6));
    }

    public int attack() {
        int hurtValue = getStrength();
        if (getWeapon().size() > 0) {
            for (Weapon w : getWeapon())
                hurtValue += w.getDamage();
        }
        hurtValue = (int)(hurtValue * 0.05);
        System.out.println("[Hero] " + getName() + "> regular attack: damage = " + hurtValue);

        return hurtValue;
    }

    public void heal(Potion potion) {
        //capped
        int healValue = potion.getAttrIncrease();
        // TODO: mana/skills increase
        if (potion.flags[0]) {
            int hp = this.hp + healValue;
            if (hp > maxHp) {
                hp = maxHp;
            }
            this.hp = hp;
        }
        if (potion.flags[1])
            mana += healValue;
        if (potion.flags[2])
            strength += healValue;
        if (potion.flags[3])
            dexterity += healValue;
        if (potion.flags[4])
            defense += healValue;
        if (potion.flags[5])
            agility += healValue;
    }

    public int castSpell(Spell spell) {
        // deduct mana
        this.mana = this.mana - spell.getMana();
        System.out.println("[Hero] " + getName() + "> " + spell.type.toString() + "SPELL damage=" + spell.damage);
        // return the damage it causes
        return spell.damage;

    }

    public void defend(int val) {
        // defend from monster attack
        int hurt = val;
        if (armor != null)
            hurt -= armor.getDamageDeduction();
        if (hurt < 0) {
            System.out.print("[Hero] " + this.name + ": hp-0");
        }
        else {
            setHp(this.hp - hurt);
            System.out.print("[Hero] " + this.name + ": hp-" + hurt);
        }
        System.out.println(" current hp: " + this.hp);

    }

    public boolean dodge() {
        if (Math.random() < this.agility * 0.001) {
            System.out.println("[Hero] " + this.name + " dodges the attack!");
            return true;
        }
        return false;
    }

    public void unloadWeapon(int idx) {
        // unload the weapon of idx
        Weapon unload = weapon.remove(idx);
        bag.getWeaponList().add(unload);
        emptyHands += unload.requiredHands;
    }

    public void equipWeapon(int idx) {
        // check hands before equip new weapons
        Weapon equip = bag.getWeaponList().remove(idx);
        emptyHands = emptyHands - equip.requiredHands;
    }

    public String toString() {
        return super.toString() + "  exp: " + exp + "  mana: " + mana + "  balance: $" + money;
    }

    protected void levelUp() {
        /* update heroes stats */
        level++;
        maxHp = hp = level * 100;
        mana = (int)(mana * 1.1);
    }

    // print methods

    public void printInfo() {
        System.out.println(getName());
        System.out.println("level: " + level);
        System.out.println("hp: " + hp);
        System.out.println("exp: " + exp);
        System.out.println("mana: " + mana);
        System.out.println("balance: $" + money);
        System.out.println("strength: " + strength);
        System.out.println("dexterity: " + dexterity);
        System.out.println("agility: " + agility);
    }

    public void printEquip() {
        System.out.println(getName() + " is now equipped with:");
        System.out.println("[Weapon]");
        if (weapon.size() == 0) {
            System.out.println("None");
        }
        for (Weapon w : weapon) {
            System.out.println(w.toString());
        }
        System.out.println("[Armor]");
        if (armor == null) {
            System.out.println("None");
        }
        else {
            System.out.println(armor.toString());
        }
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

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public Bag getBag() {
        return bag;
    }

    public int getMana() {
        return mana;
    }

    public int getExp() {
        return exp;
    }

    public void gainExp(int exp) {
        setExp(exp + this.exp);
    }

    private void setExp(int exp) {
        this.exp = exp;
        if (exp > level * 10) {
            levelUp();
        }
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public int getMoney() {
        return money;
    }

    public void gainMoney(int money) {
        setMoney(money + this.money);
    }

    public void spendMoney(int amount) {
        setMoney(getMoney() - amount);
    }

    public void lose() {
        setMoney((int)(money * 0.5));
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public List<Weapon> getWeapon() {
        return weapon;
    }

    public void setWeapon(List<Weapon> weapon) {
        this.weapon = weapon;
    }

    public int getDexterity() {
        return dexterity;
    }

    private void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getStrength() {
        return strength;
    }

    private void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    private void setAgility(int agility) {
        this.agility = agility;
    }




}
