// subclass of monster (a kind of monster)
public class Exoskeleton extends Monster {
    public Exoskeleton() {}

    public Exoskeleton(String name, int level, int damage, int defense, int dodgeChance) {
        super(name, level, damage, defense, dodgeChance);
    }
}
