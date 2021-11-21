// action of heroes
// super class
public abstract class Action {
    Hero hero;

    public Action() {}

    abstract boolean execute();     // execute current action

    void setHero(Hero hero) {
        this.hero = hero;
    }

}
