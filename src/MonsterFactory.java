import java.util.*;

public class MonsterFactory {
    // for creating monsters
    static final int DRAGON = 1;
    static final int EXOSKELETON = 2;
    static final int SPIRIT = 3;
    static final int BACK = 0;

    static final String DRAGON_MENU = "Dragons.txt";
    static final String EXOSKELETON_MENU = "Exoskeletons.txt";
    static final String SPIRIT_MENU = "Spirits.txt";


    public MonsterFactory() {}

    public Monster getMonster(int type, int level) {
        Monster newMonster = selectMonster(type, level);
        return newMonster;
    }


    private Monster selectMonster(int type, int level) {
        Monster newMonster = null;
        switch (type) {
            case DRAGON:
                ArrayList<ArrayList<String>> dragonList = AskInput.read(DRAGON_MENU);
                for (ArrayList<String> dragon : dragonList) {
                    if (dragon.get(1).equals(String.valueOf(level))) {
                        newMonster = getDragon(dragon);
                        break;
                    }
                }
                break;
            case EXOSKELETON:
                ArrayList<ArrayList<String>> exoskeletonList = AskInput.read(EXOSKELETON_MENU);
                for (ArrayList<String> exoskeleton : exoskeletonList) {
                    if (exoskeleton.get(1).equals(String.valueOf(level))) {
                        newMonster = getExoskeleton(exoskeleton);
                        break;
                    }
                }
                break;
            case SPIRIT:
                ArrayList<ArrayList<String>> spiritList = AskInput.read(SPIRIT_MENU);
                for (ArrayList<String> spirit : spiritList) {
                    if (spirit.get(1).equals(String.valueOf(level))) {
                        newMonster = getSpirit(spirit);
                        break;
                    }
                }
                break;
            default:
                return null;
        }
        return newMonster;
    }

    private Dragon getDragon(ArrayList<String> attrs) {
        Dragon dragon = new Dragon();
        dragon.setAttributes(attrs);

        return dragon;
    }

    private Exoskeleton getExoskeleton(ArrayList<String> attrs) {
        Exoskeleton exoskeleton = new Exoskeleton();
        exoskeleton.setAttributes(attrs);

        return exoskeleton;
    }

    private Spirit getSpirit(ArrayList<String> attrs) {
        Spirit spirit = new Spirit();
        spirit.setAttributes(attrs);

        return spirit;
    }

    private void printMenu(ArrayList<ArrayList<String>> monsterList) {
        String menu;
        for (int i = 0; i < monsterList.size(); i++) {
            System.out.print((i + 1) + ": ");
            for (String s : monsterList.get(i)) {
                System.out.print(s + "\t");
            }
            System.out.println();
        }
    }
}
