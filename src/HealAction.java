import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HealAction extends Action {
    public HealAction(Hero hero) {
        this.hero = hero;
    }

    public Potion getPotion() {
        System.out.println("Please select a potion from your bag.");
        ArrayList<Potion> potions = hero.getBag().getPotionInventory();
        if (potions.size() > 0) {
            for (int i = 0; i < potions.size(); i++) {
                System.out.println((i + 1) + ": " + potions.get(i));
            }
            //get the potion they want
            int id = AskInput.askInt(1, potions.size()) - 1;
            Potion p = potions.remove(id);
            return p;
        }
        else{
            System.out.println("Failed: Current hero does not have any potion.");
            return null;
        }
    }

    boolean execute() {
        while (true) {
            Potion potion = getPotion();
            if (potion == null) {
                return false;
            }
            hero.heal(potion);
            if (!AskInput.inquireYN("Use more potions?")) {
                break;
            }
        }
        return true;
    }
}
