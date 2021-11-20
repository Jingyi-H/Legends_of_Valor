public abstract class Action {
    Hero hero;
    // action of heroes
    // super class of ChangeEquipAction, HealAction

    public Action() {}

    abstract boolean execute();

    void setHero(Hero hero) {
        this.hero = hero;
    }

}
