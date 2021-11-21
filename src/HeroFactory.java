import java.util.ArrayList;
import java.util.List;

// For creations of heroes, enable players to select heroes
public class HeroFactory {
    // for creating heros
    static final int WARRIOR = 1;
    static final int SORCERER = 2;
    static final int PALADIN = 3;
    static final int BACK = 0;
    static final String WARRIOR_MENU = "Warriors.txt";
    static final String SORCERER_MENU = "Sorcerers.txt";
    static final String PALADIN_MENU = "Paladins.txt";


    public HeroFactory() {}

    public Hero getHero() {
        // get hero according to player's choice
        int type = selectType();
        Hero newHero = selectHero(type);
        while (newHero == null) {
            type = selectType();
            newHero = selectHero(type);
        }

        return newHero;
    }

    private int selectType() {
        // return heroes type id according to player's choice
        System.out.println("Select a hero type:");
        System.out.println("1: Warrior");
        System.out.println("2: Sorcerer");
        System.out.println("3: Paladin");
        int type = AskInput.askInt(1, 3);

        return type;
    }

    private Hero selectHero(int type) {
        // get player's choice and instantiate the selected hero
        int id;
        Hero newHero;
        switch (type) {
            case WARRIOR:
                ArrayList<ArrayList<String>> warriorList = AskInput.read(WARRIOR_MENU);
                printMenu(warriorList);
                id = AskInput.askInt(0, warriorList.size());
                if (id == 0) {
                    return null;
                }
                newHero = getWarrior(warriorList.get(id - 1));
                break;
            case SORCERER:
                ArrayList<ArrayList<String>> sorcererList = AskInput.read(SORCERER_MENU);
                printMenu(sorcererList);
                id = AskInput.askInt(0, sorcererList.size());
                if (id == 0) {
                    return null;
                }
                newHero = getSorcerer(sorcererList.get(id - 1));
                break;
            case PALADIN:
                ArrayList<ArrayList<String>> paladinList = AskInput.read(PALADIN_MENU);
                printMenu(paladinList);
                id = AskInput.askInt(0, paladinList.size());
                if (id == 0) {
                    return null;
                }
                newHero = getPaladin(paladinList.get(id - 1));
                break;
                default:
                    return null;
        }
        return newHero;
    }

    private Warrior getWarrior(ArrayList<String> attrs) {
        // return a warrior according to player's input
        Warrior warrior = new Warrior();
        warrior.setAttributes(attrs);

        return warrior;
    }

    private Sorcerer getSorcerer(ArrayList<String> attrs) {
        // return a sorcerer according to player's input
        Sorcerer sorcerer = new Sorcerer();
        sorcerer.setAttributes(attrs);

        return sorcerer;
    }

    private Paladin getPaladin(ArrayList<String> attrs) {
        // return a paladin according to player's input
        Paladin paladin = new Paladin();
        paladin.setAttributes(attrs);

        return paladin;
    }

    private void printMenu(ArrayList<ArrayList<String>> heroList) {
        // print the menu of heroes character of some type (warrior/sorcerer/paladin)
        String menu;
        System.out.println("Name/mana/strength/agility/dexterity/starting money/starting experience");
        for (int i = 0; i < heroList.size(); i++) {
            System.out.print((i + 1) + ": ");
            for (String s : heroList.get(i)) {
                System.out.print(s + "\t");
            }
            System.out.println();
        }
        System.out.println("\nSelect a hero by id or enter 0 to get back to the former menu.");
    }



}
