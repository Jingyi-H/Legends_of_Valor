public class Test {
    public static void main(String[] args) {
        Hero h = AskInput.askHero();
        for (int i = 0; i < 10 ; i++) {
            h.levelUp();
        }
        Market m = new Market();
        PurchaseHelper.purchase(h, m);
        Action change = new ChangeEquipAction(h);
        change.execute();

        Action heal = new HealAction(h);
        heal.execute();
        h.printInfo();
        h.printEquip();



    }
}
