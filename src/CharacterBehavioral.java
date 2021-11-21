// interface of heroes and monsters behavior
public interface CharacterBehavioral {

    int attack();               // return damage value
    void defend(int damage);    // reduce character's hp with given damage and current defense
    boolean dodge();            // return true --> dodged , false --> failed to dodge
}
