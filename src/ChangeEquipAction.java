import java.util.List;

// subclass of Action, for heroes to change their equipment: weapons/armors
public class ChangeEquipAction extends Action {
    boolean exit;
    public ChangeEquipAction(Hero hero) {
        this.hero = hero;
        this.exit = false;
    }

    @Override
    boolean execute() {
        // execute this action
        hero.printEquip();
        while (!exit) {
            int equipType = selectType();
            //if they want to equip a weapon
            if (equipType == 1) {
                int action = selectAction(); // equip / unload
                if (action == 1) {
                    equipWeapon();
                } else if (action == 2) {
                    unloadWeapon();
                }
            } else if (equipType == 2) {
                int action = selectAction(); // equip / unload
                if (action == 1) {
                    equipArmor();
                } else if (action == 2) {
                    unloadArmor();
                }
            }
            exit = AskInput.inquireYN("> Finish equip/unload?");
        }

        return true;
    }

    private int selectType() {
        // select equipment type
        System.out.println("> Change Equipment...");
        System.out.println("1: Weapon");
        System.out.println("2: Armor");
        System.out.println("Enter 0 to get back to the last menu.");
        int equipType = AskInput.askInt(0, 2);

        return equipType;
    }

    private int selectAction() {
        // select equip/unload
        System.out.println("> Select your action...");
        System.out.println("1: Equip");
        System.out.println("2: Unload");
        int actionType = AskInput.askInt(1, 2);

        return actionType;
    }

    private boolean equipWeapon() {
        // select an weapon from bag and equip
        List<Weapon> weapons = hero.getBag().getWeaponInventory();
        if (weapons.size() == 0) {
            //if hero has no weapons
            System.out.println("Failed: Current hero does not have other weapons.");
            return false;
        }
        else {
            if (hero.emptyHands == 0) {
                System.out.println("No empty hands now, please unload some of your weapons.");
                unloadWeapon();
            }
            weapons = hero.getBag().getWeaponInventory();
            System.out.println("> Please select a weapon to equip:");
            for (int i = 0; i < weapons.size(); i++) {
                System.out.println((i + 1) + ": " + weapons.get(i));
            }
            int id = AskInput.askInt(1, weapons.size()) - 1;

            // set current weapon
            if (hero.getBag().getWeaponInventory().get(id).getHandsRequired() <= hero.emptyHands) {
                System.out.println("Succeed: Equipped with [Weapon]" + hero.getBag().getWeaponInventory().get(id));
                hero.equipWeapon(id);
                return true;
            }
            return false;

        }
    }

    private boolean equipArmor() {
        // select an armor from bag and equip
        System.out.println("> Please select an armor to equip:");
        List<Armor> armors = hero.getBag().getArmorInventory();
        if (armors.size() == 0) {
            //if hero has no armors
            System.out.println("Failed: Current hero does not have other armors.");
            return false;
        }
        else {
            for (int i = 0; i < armors.size(); i++) {
                System.out.println((i + 1) + ": " + armors.get(i));
            }
            int id = AskInput.askInt(1, armors.size()) - 1;
            // get current equipped armor and put it back to inventory
            Armor armor = hero.getArmor();
            if (armor != null)
                hero.getBag().getArmorInventory().add(armor);
            // set current armor
            armor = hero.getBag().getArmorInventory().remove(id);
            hero.setArmor(armor);
            System.out.println("Succeed: Equipped with [Armor]" + armor);
        }

        return true;
    }

    private boolean unloadWeapon() {
        // get current equipped weapon and put it back to inventory
        List<Weapon> weapons = hero.getWeapon();
        if (weapons.size() == 0) {
            //if hero has no weapons
            System.out.println("Failed: Hero is not equipped with any weapon.");
            return false;
        }
        System.out.println("> Please select a weapon to unload:");
        for (int i = 0; i < weapons.size(); i++) {
            System.out.println((i + 1) + ": " + weapons.get(i));
        }
        int id = AskInput.askInt(1, weapons.size()) - 1;
        System.out.println("Succeed: Unload [Weapon] " + weapons.get(id));
        hero.unloadWeapon(id);

        return true;
    }

    private boolean unloadArmor() {
        // get current equipped weapon and put it back to inventory
        Armor armor = hero.getArmor();
        if (armor == null) {
            //if hero has no weapons
            System.out.println("Failed: Hero is not equipped with armor.");
            return false;
        }

        System.out.println("Succeed: Unload [Armor]" + armor);
        hero.unloadArmor();
        return true;
    }


}
