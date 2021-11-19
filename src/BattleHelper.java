import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BattleHelper {
	
	public static void battle(Hero hero, Monster monster, LOVBoard gameboard, Market market) {
		System.out.println("###########################################################################");
		System.out.println("A Battle starts between "+ hero.getName() + " and "+ monster.getName());
		
		addingAttribute(hero, gameboard);
		
		while(true) {
			if(hero.getHp() == 0) {gameboard.heroRevive(hero); hero.resetHp();resetAttribute(hero, gameboard);PurchaseHelper.purchase(hero, market);break;}
			if(monster.getHp() == 0) {gameboard.monsterDie(monster);resetAttribute(hero, gameboard);hero.win(monster.getLevel());break;}
			displaySituation(hero, monster);
			
			//Ask Hero Moves
			System.out.println(hero.getName() + " please make your move: ");
			int choice = AskInput.askBattleMove();
			if(choice == 0) {heroAttack(hero, monster);}
			else if(choice == 1) {heroCast(hero, monster);}
			else if(choice == 2) {Action usePotion = new HealAction(hero);usePotion.execute();}
			else {Action changeEquip = new ChangeEquipAction(hero);changeEquip.execute();}
			
			monsterAttack(hero,monster);
		}
		
		
	}
	
	public static void monsterAttack(Hero hero, Monster monster) {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		
		boolean dodge = hero.dodge();
		if(dodge == true) {System.out.println(monster.getName() + " attacked, but you dodged its attack!");}
		else {int damage = monster.attack();hero.defend(damage);}
		

		
		
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}
	
	public static void heroAttack(Hero hero, Monster monster) {
		
		boolean dodge = monster.dodge();
		if(dodge == true) {System.out.println(monster.getName() + " dodged your attack!");}
		else {int hero_damage = hero.attack();monster.reduceHp(hero_damage);}
		
	}
	
	public static void heroCast(Hero hero, Monster monster) {
		
		boolean hasSpell = hasSpell(hero);
		if(hasSpell == false) {System.out.println("What are you doing? You don't have any Spell!");}
		else {

			int size = hero.getBag().getSpellInventory().size();
			for(int i = 0; i<size;i++) {
				System.out.print(i+ " -- ");
				System.out.println(hero.getBag().getSpellInventory().get(i).getName());				
			}
			System.out.println("Select your spell to cast: (corresponding integer)");
			int choice = 0;
			while(true) {
				try {
					Scanner file = new Scanner(System.in);
					choice = file.nextInt();
					while(choice<0 || choice>size-1) {
						System.out.println("Spell index doesn't exist, enter again:");
						choice = file.nextInt();
					}
					break;
				}catch(InputMismatchException|NumberFormatException ex){
					System.out.println("Spell index doesn't exist, enter again:");
				}				
			}
			Spell selected = hero.getBag().getSpellInventory().get(choice);
			
			
			int damage = hero.castSpell(selected);
			if(selected.getType().equals("Fire")) {monster.reduceDefense(0.2);}
			else if(selected.getType().equals("Ice")){monster.reduceDamage(0.2);}
			else {monster.reduceDodge(0.2);}
			monster.reduceHp(damage);
		}
	}
	
	public static boolean hasSpell(Hero hero) {
		
		int count = hero.getBag().getSpellInventory().size();
		if(count == 0) {return false;}
		else {return true;}
		
	}
	
	
	
	//display battle situation
	public static void displaySituation(Hero hero, Monster monster) {		
		System.out.println("-----------------------------------------");
		System.out.print("Hero: ");
		
		System.out.print(hero.getName());
		System.out.print(" -- HP(");
		System.out.print(hero.getHp());
		System.out.print("), -- MANA(");
		System.out.println(hero.getMana()+")");
		
		System.out.println("-----------------------------------------");
		System.out.print("Monster: ");
		
		System.out.print(monster.getName());
		System.out.print(" -- HP(");
		System.out.print(monster.getHp());
		System.out.println(")");
		
		System.out.println("-----------------------------------------");
	}
	
	//Adding Tribute based on different Cells
	public static void addingAttribute(Hero hero, LOVBoard gameboard) {
		
		String current = gameboard.getCellName(hero);
		if(current.equals("CaveCell")) {hero.addAgility(0.1);}
		else if(current.equals("BushCell")) {hero.addDexterity(0.1);}
		else if(current.equals("KoulouCell")) {hero.addStrength(0.1);}
		else {}
	}
	
	public static void resetAttribute(Hero hero, LOVBoard gameboard) {
		
		String current = gameboard.getCellName(hero);
		if(current.equals("CaveCell")) {hero.removeAgility(0.1);}
		else if(current.equals("BushCell")) {hero.removeDexterity(0.1);}
		else if(current.equals("KoulouCell")) {hero.removeStrength(0.1);}
		else {}
	}
}
