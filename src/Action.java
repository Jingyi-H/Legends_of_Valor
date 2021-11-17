public abstract class Action {
    Hero hero;
    // action of a character: hero/monster

    public Action() {

    }

    public Action(Hero hero) {
        this.hero = hero;
    }

    abstract boolean execute();

    void setHero(Hero hero) {
        this.hero = hero;
    }

}
