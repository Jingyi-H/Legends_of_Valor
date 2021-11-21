import java.util.ArrayList;
import java.util.List;

// Game characters played by users
public abstract class Hero implements CharacterBehavioral {
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
    static final int HANDS = 2; // total hands
    int emptyHands;             // number of currently empty hands

    Armor armor;            // currently equipped armor
    List<Weapon> weapon;    // currently equipped weapons
    Bag bag;

    public Hero() {
        // initialize heroes stats
        this.level = 1;
        this.maxHp = this.hp = this.level * 1000;
        this.defense = 0;
        this.bag = new Bag();
        this.emptyHands = HANDS;
        this.weapon = new ArrayList<>();
    }

    public Hero(String name, int mana, int strength, int agility, int dexterity, int starting_money, int starting_exp) {
        // initialize heroes stats with given variables
        this.name = name;
        this.mana = mana;
        this.strength = strength;
        this.dexterity = dexterity;
        this.agility = agility;
        this.exp = starting_exp;
        this.money = starting_money;
        // init
        this.level = 1;
        this.maxHp = this.hp = this.level * 1000;
        this.defense = 0;
        this.bag = new Bag();
        this.emptyHands = HANDS;
        this.weapon = new ArrayList<>();
    }

    public void setAttributes(List<String> attrs) {
        //split by any amount of whitespace using regex sourced from: https://javarevisited.blogspot.com/2016/10/how-to-split-string-in-java-by-whitespace-or-tabs.html
        this.name = attrs.get(0);
        this.mana = Integer.parseInt(attrs.get(1));
        this.strength = Integer.parseInt(attrs.get(2));
        this.agility = Integer.parseInt(attrs.get(3));
        this.dexterity = Integer.parseInt(attrs.get(4));
        this.money = Integer.parseInt(attrs.get(5));
        this.exp = Integer.parseInt(attrs.get(6));
    }

    public int attack() {
        // return the value of damage when hero takes a regular attack
        int hurtValue = this.strength;
        if (getWeapon().size() > 0) {
            for (Weapon w : getWeapon())
                hurtValue += w.getDamage() * 0.05;
        }
        System.out.println("[Hero] " + getName() + "> regular attack: damage=" + hurtValue);

        return hurtValue;
    }

    public void heal(Potion potion) {
        // for using a potion and increase the affected attributes
        //capped
        int healValue = potion.getAffect();
        if (potion.getAttribute()[0]) {
            int hp = this.hp + healValue;
            if (hp > maxHp) {
                hp = maxHp;
            }
            this.hp = hp;
        }
        if (potion.getAttribute()[1])
            mana += healValue;
        if (potion.getAttribute()[2])
            strength += healValue;
        if (potion.getAttribute()[3])
            dexterity += healValue;
        if (potion.getAttribute()[4])
            defense += healValue;
        if (potion.getAttribute()[5])
            agility += healValue;
        System.out.println("Succeed: Use [Potion] " + potion);
    }

    public int castSpell(Spell spell) {
        // return the value of damage when hero cast the given spell
        if (this.mana < spell.getManaCost()) {
            System.out.println("Failed: " + name + " does not have enough mana to cast this spell!");
            return 0;
        }
        // reduce mana
        this.mana = this.mana - spell.getManaCost();
        System.out.println("[Hero] " + name + "> " + spell.getType() + "SPELL damage=" + spell.getDamage());
        // return the damage it causes
        return spell.getDamage();
    }

    public void defend(int val) {
        // defend from monster attack
        int hurt = val;
        // if hero is armed
        if (armor != null)
            hurt -= armor.getDamageReduction();
        if (hurt < 0) {
            System.out.print("[Hero] " + this.name + ": hp-0");
        }
        else {
            // hero reduce hp
            int currentHp = this.hp - hurt;
            if (currentHp < 0) {
                currentHp = 0;
            }
            hp = currentHp;
            System.out.print("[Hero] " + this.name + ": hp-" + hurt);
        }
        System.out.println(" current hp: " + this.hp);

    }

    public boolean dodge() {
        // return whether hero dodges the attack by monster: if true --> dodge
        if (Math.random() < this.agility * 0.0005) {
            System.out.println("[Hero] " + this.name + " dodged the attack!");
            return true;
        }
        return false;
    }

    public void unloadWeapon(int idx) {
        // unload the weapon of idx
        Weapon unload = weapon.remove(idx);
        bag.getWeaponInventory().add(unload);
        emptyHands += unload.getHandsRequired();
    }

    public void equipWeapon(int idx) {
        // equip a weapon from the bag
        // check hands before equip new weapons
        Weapon equip = bag.getWeaponInventory().remove(idx);
        emptyHands = emptyHands - equip.getHandsRequired();
        weapon.add(equip);
    }

    public void unloadArmor() {
        // unload current armor and put it back into bag
        bag.getArmorInventory().add(armor);
        armor = null;
    }

    public String toString() {
        // basic information on hero
        return name + "  exp: " + exp + "  hp: " + hp + "  mana: " + mana + "  balance: $" + money;
    }

    protected void levelUp() {
        /* update heroes stats */
        level++;
        maxHp = hp = level * 1000;
        mana = (int)(mana * 1.1);
        System.out.println("[Hero] " + name + " levels up!");
        System.out.println(this);
    }


    public void printInfo() {
        // detailed information about hero
        System.out.println(getName());
        System.out.println("level: " + level);
        System.out.println("hp: " + hp);
        System.out.println("exp: " + exp);
        System.out.println("mana: " + mana);
        System.out.println("balance: $" + money);
        System.out.println("strength: " + strength);
        System.out.println("dexterity: " + dexterity);
        System.out.println("agility: " + agility);
        if (this.armor == null) {
            System.out.println("defense: " + defense);
        }
        else {
            System.out.println("defense: " + (defense + this.armor.getDamageReduction()));
        }
    }

    public void printEquip() {
        // print currently equipped weapons and armor
        System.out.println(getName() + " is now equipped with:");
        System.out.println("[Weapon]");
        if (weapon.size() == 0) {
            System.out.println("None");
        }
        for (Weapon w : weapon) {
            System.out.println(w.toString());
        }
        System.out.println("\n[Armor]");
        if (armor == null) {
            System.out.println("None");
        }
        else {
            System.out.println(armor.toString());
        }
    }

    public void win(int monsterLevel) {
        // hero wins and gain money & exp according to monster's level
        int money = monsterLevel * 100;
        int exp = monsterLevel * 10;
        //TODO: int exp = monsterLevel * 3;
        System.out.println("[Hero] " + name + " wins! You get money: $" + money + ",  exp: " + exp);
        gainMoney(money);
        gainExp(exp);

    }

    public void gainMoney(int money) {
        // gain some amount of money
        setMoney(money + this.money);
    }

    private void gainExp(int exp) {
        // gain some amount of exp
        setExp(exp + this.exp);
    }

    public void spendMoney(int amount) {
        // spend some amount of money
        setMoney(getMoney() - amount);
    }

    public void lose() {
        // hero lose message
        System.out.println("[Hero] " + name + " loses.");
    }

    public void addStrength(double increment) {
        // add strength in some specific cell
        this.strength = (int)(this.strength * (1 + increment));
    }

    public void addDexterity(double increment) {
        // add dexterity in some specific cell
        this.dexterity = (int)(this.dexterity * (1 + increment));
    }

    public void addAgility(double increment) {
        // add agility in some specific cell
        this.agility = (int)(this.agility * (1 + increment));
    }

    public void removeStrength(double increment) {
        // remove strength bonus
        this.strength = (int)(this.strength / (1 + increment));
    }

    public void removeDexterity(double increment) {
        // remove dexterity bonus
        this.dexterity = (int)(this.dexterity / (1 + increment));
    }

    public void removeAgility(double increment) {
        // remove agility bonus
        this.agility = (int)(this.agility / (1 + increment));
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

    public void resetHp() { this.hp = this.maxHp;}

    public int getHp() {
        return hp;
    }

    public Bag getBag() {
        return bag;
    }

    public int getMana() {
        return mana;
    }

    private void setExp(int exp) {
        // set current exp, if satisfies conditions for level up, level += 1
        this.exp = exp;
        if (exp > level * 10 && level < 10) {
            // maximum level == 10
            levelUp();
        }
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMoney() {
        return money;
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

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getAgility() {
        return agility;
    }




}
