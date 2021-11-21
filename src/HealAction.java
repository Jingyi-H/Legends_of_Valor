import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// subclass of Action, implements action of using potions
public class HealAction extends Action {
    public HealAction(Hero hero) {
        this.hero = hero;
    }

    public Potion getPotion() {
        // get a potion from hero's bag
        ArrayList<Potion> potions = hero.getBag().getPotionInventory();
        if (potions.size() > 0) {
            System.out.println("Please select a potion from your bag.");
            for (int i = 0; i < potions.size(); i++) {
                System.out.println((i + 1) + ": " + potions.get(i));
            }
            //get the potion they want
            int id = AskInput.askInt(1, potions.size()) - 1;
            Potion p = hero.getBag().removePotion(id);
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
                // if current hero does not have any potion
                return false;
            }
            hero.heal(potion);  // use selected potion
            if (!AskInput.inquireYN("Use more potions?")) {
                break;
            }
        }
        return true;
    }
}
