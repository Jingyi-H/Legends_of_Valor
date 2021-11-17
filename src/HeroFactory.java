import java.util.ArrayList;
import java.util.List;

public class HeroFactory {
    // for creating heros
    static final int WARRIOR = 1;
    static final int SORCERER = 2;
    static final int PALADIN = 3;
    static final int BACK = 0;
    static final String WARRIOR_MENU = Path.WARRIOR.toString();
    static final String SORCERER_MENU = Path.SORCERER.toString();
    static final String PALADIN_MENU = Path.PALADIN.toString();


    public HeroFactory() {

    }

    public Hero getHero() {
        int type = selectType();
        Hero newHero = selectHero(type);
        while (newHero == null) {
            type = selectType();
            newHero = selectHero(type);
        }

        return newHero;
    }

    private int selectType() {
        System.out.println("Select a hero type:");
        System.out.println("1: Warrior");
        System.out.println("2: Sorcerer");
        System.out.println("3: Paladin");
        int type = AskInput.askInt(1, 3);

        return type;
    }

    private Hero selectHero(int type) {
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
//                printMenu(SORCERER);
//                id = AskInput.askInt(0, Utils.getTtlLinesFromFile(SORCERER_MENU, 1));
//                if (id == 0) {
//                    return null;
//                }
//                newHero = getSorcerer(id);
//                break;
            case PALADIN:
                printMenu(PALADIN);
                id = AskInput.askInt(0, Utils.getTtlLinesFromFile(PALADIN_MENU, 1));
                if (id == 0) {
                    return null;
                }
                newHero = getPaladin(id);
                break;
                default:
                    return null;
        }
        return newHero;
    }

    private Warrior getWarrior(ArrayList<String> attrs) {
        Warrior warrior = new Warrior();
        warrior.setAttributes(attrs);

        return warrior;
    }

    private Sorcerer getSorcerer(ArrayList<String> attrs) {
        Sorcerer sorcerer = new Sorcerer();
        sorcerer.setAttributes(attrs);

        return sorcerer;
    }

    private Paladin getPaladin(ArrayList<String> attrs) {
        Paladin paladin = new Paladin();
        paladin.setAttributes(attrs);

        return paladin;
    }

    private void printMenu(ArrayList<ArrayList<String>> heroList) {
        String menu;
        for (int i = 0; i < heroList.size(); i++) {
            System.out.print((i + 1) + ": ");
            for (String s : heroList.get(i)) {
                System.out.print(s + "\t");
            }
            System.out.println();
        }
        System.out.println("Enter 0 to get back to the former menu.");
        System.out.println("Select a hero by id.");
    }



}
