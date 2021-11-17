public class Test {
    public static void main(String[] args) {
        Hero h = AskInput.askHero();
        Market market = new Market();
        PurchaseHelper.purchase(h, market);
        for (Armor i : h.getBag().getArmorInventory()) {
            System.out.println(i.getName());
        }
        System.out.println("========================");
        for (Weapon i : h.getBag().getWeaponInventory()) {
            System.out.println(i.getName());
        }
        System.out.println("========================");
        for (Spell i : h.getBag().getSpellInventory()) {
            System.out.println(i.getName());
        }
        System.out.println("========================");
        for (Potion i : h.getBag().getPotionInventory()) {
            System.out.println(i.getName());
        }

    }
}
