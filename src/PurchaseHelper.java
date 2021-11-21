import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


// for market(nexus) event
public class PurchaseHelper {
	
	public static void sell(Hero hero) {
		// current hero select item(s) to sell and get money
		while(true) {
			System.out.println("You have $" + hero.getMoney());
			System.out.println("What do you want to sell: 1 -- Armor, 2 -- Weapon, 3 -- Spell, 4 -- Potion, 5 -- quit");
			int choice = AskInput.askSell();
			if(choice == 5) {break;}
			if(choice == 1) {sellArmor(hero);}
			else if(choice == 2) {sellWeapon(hero);}
			else if(choice == 3) {sellSpell(hero);}
			else {sellPotion(hero);}
		}
	}
	
	public static void sellArmor(Hero hero) {
		// current hero wants to sell armor
		if(hasArmor(hero)==false) {System.out.println("You don't have any Armor");}
		else {
			int size = hero.getBag().getArmorInventory().size();
			for(int i = 1; i<size+1;i++) {
				System.out.print(i+" -- ");
				System.out.println(hero.getBag().getArmorInventory().get(i-1).getName() + "("+hero.getBag().getArmorInventory().get(i-1).getCost()/2 + ")");
			}
			System.out.println("Select your Armor to sell: (corresponding integer or 0 to quit)");
			int choice = 0;
			while(true) {
				try {
					Scanner file = new Scanner(System.in);
					choice = file.nextInt();
					while(choice<0 || choice>size) {
						System.out.println("Armor index doesn't exist, enter again:");
						choice = file.nextInt();
					}
					break;
				}catch(InputMismatchException|NumberFormatException ex){
					System.out.println("Armor index doesn't exist, enter again:");
				}				
			}
			if (choice == 0) {return;}
			int money = hero.getBag().getArmorInventory().get(choice - 1).getCost()/2;
			hero.gainMoney(money);
			hero.getBag().getArmorInventory().remove(choice -1);
		}
	}

	public static void sellWeapon(Hero hero) {
		// current hero wants to sell weapon
		if(hasWeapon(hero)==false) {System.out.println("You don't have any Weapon");}
		else {
			int size = hero.getBag().getWeaponInventory().size();
			for(int i = 1; i<size+1;i++) {
				System.out.print(i+" -- ");
				System.out.println(hero.getBag().getWeaponInventory().get(i-1).getName() + "("+hero.getBag().getWeaponInventory().get(i-1).getCost()/2 + ")");
			}
			System.out.println("Select your Weapon to sell: (corresponding integer or 0 to quit)");
			int choice = 0;
			while(true) {
				try {
					Scanner file = new Scanner(System.in);
					choice = file.nextInt();
					while(choice<0 || choice>size) {
						System.out.println("Weapon index doesn't exist, enter again:");
						choice = file.nextInt();
					}
					break;
				}catch(InputMismatchException|NumberFormatException ex){
					System.out.println("Weapon index doesn't exist, enter again:");
				}				
			}
			if (choice == 0) {return;}
			int money = hero.getBag().getWeaponInventory().get(choice - 1).getCost()/2;
			hero.gainMoney(money);
			hero.getBag().getWeaponInventory().remove(choice -1);
		}
	}
	public static void sellSpell(Hero hero) {
		// current hero wants to sell spell
		if(hasSpell(hero)==false) {System.out.println("You don't have any Spell");}
		else {
			int size = hero.getBag().getSpellInventory().size();
			for(int i = 1; i<size+1;i++) {
				System.out.print(i+" -- ");
				System.out.println(hero.getBag().getSpellInventory().get(i-1).getName() + "("+hero.getBag().getSpellInventory().get(i-1).getCost()/2 + ")");
			}
			System.out.println("Select your Spell to sell: (corresponding integer or 0 to quit)");
			int choice = 0;
			while(true) {
				try {
					Scanner file = new Scanner(System.in);
					choice = file.nextInt();
					while(choice<0 || choice>size) {
						System.out.println("Spell index doesn't exist, enter again:");
						choice = file.nextInt();
					}
					break;
				}catch(InputMismatchException|NumberFormatException ex){
					System.out.println("Spell index doesn't exist, enter again:");
				}				
			}
			if (choice == 0) {return;}
			int money = hero.getBag().getSpellInventory().get(choice - 1).getCost()/2;
			hero.gainMoney(money);
			hero.getBag().getSpellInventory().remove(choice -1);
		}
	}
	
	public static void sellPotion(Hero hero) {
		// current hero wants to sell potion
		if(hasPotion(hero)==false) {System.out.println("You don't have any Potion");}
		else {
			int size = hero.getBag().getPotionInventory().size();
			for(int i = 1; i<size+1;i++) {
				System.out.print(i+" -- ");
				System.out.println(hero.getBag().getPotionInventory().get(i-1).getName() + "("+hero.getBag().getPotionInventory().get(i-1).getCost()/2 + ")");
			}
			System.out.println("Select your Potion to sell: (corresponding integer or 0 to quit)");
			int choice = 0;
			while(true) {
				try {
					Scanner file = new Scanner(System.in);
					choice = file.nextInt();
					while(choice<0 || choice>size) {
						System.out.println("Potion index doesn't exist, enter again:");
						choice = file.nextInt();
					}
					break;
				}catch(InputMismatchException|NumberFormatException ex){
					System.out.println("Potion index doesn't exist, enter again:");
				}				
			}
			if (choice == 0) {return;}
			int money = hero.getBag().getPotionInventory().get(choice - 1).getCost()/2;
			hero.gainMoney(money);
			hero.getBag().getPotionInventory().remove(choice -1);
		}
	}
	
	
	public static boolean hasSpell(Hero hero) {
		// check if current hero has any spell
		int count = hero.getBag().getSpellInventory().size();
		if(count == 0) {return false;}
		else {return true;}
		
	}
	public static boolean hasArmor(Hero hero) {
		// check if current hero has any armor in bag
		int count = hero.getBag().getArmorInventory().size();
		if(count == 0) {return false;}
		else {return true;}
		
	}
	public static boolean hasWeapon(Hero hero) {
		// check if current hero has any weapon in bag
		int count = hero.getBag().getWeaponInventory().size();
		if(count == 0) {return false;}
		else {return true;}
		
	}
	public static boolean hasPotion(Hero hero) {
		// check if current hero has any potion
		int count = hero.getBag().getPotionInventory().size();
		if(count == 0) {return false;}
		else {return true;}
		
	}
	
	public static void purchase(Hero hero, Market market) {
		// for heroes to select items and purchase
		System.out.println("####################################################");
		market.showitems();
		System.out.println("####################################################");
		System.out.print(hero.getName());
		System.out.println(", please make your purchase or quit:"+ "("+hero.getMoney()+" remain money"+")");
		while(true) {
			int choice = AskInput.askpurchase();
			if(choice == 30) {
				sell(hero);
				System.out.println("####################################################");
				market.showitems();
				System.out.println("####################################################");
				System.out.print(hero.getName());
				System.out.println(", please make your purchase or quit:"+ "("+hero.getMoney()+" remain money"+")");
				continue;
			}
			if(choice == 31) {break;}
			int choiceindex = purchaseindex(choice);
			ArrayList<ArrayList<String>> division = purchaseDivision(choice,market);
			if(buyable(choiceindex,division,hero)) {
				int InventoryNo = whichInv(choice);
				ArrayList<String> itembought = division.get(choiceindex);
				int cost = Integer.parseInt(itembought.get(1));
				hero.spendMoney(cost);
				if(InventoryNo == 0) {
					hero.getBag().addArmor(new Armor(itembought));
				}else if(InventoryNo == 1) {
					hero.getBag().addWeapon(new Weapon(itembought));
				}else if(InventoryNo == 2) {
					hero.getBag().addSpell(new Spell(itembought,2));
				}else if(InventoryNo == 3) {
					hero.getBag().addSpell(new Spell(itembought,3));
				}else if(InventoryNo == 4) {
					hero.getBag().addSpell(new Spell(itembought,4));
				}else {
					hero.getBag().addPotion(new Potion(itembought));
				}
				System.out.println(">>>Transaction succeeded");
				System.out.println("####################################################");
				market.showitems();
				System.out.println("####################################################");
				System.out.print(hero.getName());
				System.out.println(", please make your purchase or quit:"+ "("+hero.getMoney()+" remain money"+")");
				System.out.println("You have $"+hero.getMoney() + " left");
			}
			else {
				System.out.println(">>>Transaction failed: You don't have enough money or you are not level enough to purchase this item, please make another selecion");
			}
			
			
		}
	}
	
	//get purchase index of each item for sale
	public static int purchaseindex(int a) {	
		if(a<5) {return a;}
		else if(a>=5 && a<11) {return a-5;}
		else if(a>=11 && a<16) {return a-11;}
		else if(a>=16 && a<20) {return a-16;}
		else if(a>=20 && a<24) {return a-20;}
		else {return a-24;}
	}
	
	
	//get purchase division, which isle to go 
	public static ArrayList<ArrayList<String>> purchaseDivision(int a, Market b){
		
		if(a<5) {return b.getarm();}
		else if(a>=5 && a<11) {return b.getwep();}
		else if(a>=11 && a<16) {return b.getfire();}
		else if(a>=16 && a<20) {return b.getice();}
		else if(a>=20 && a<24) {return b.getlightning();}
		else {return b.getpo();}
		
	}
	
	//check if buyable
	public static boolean buyable(int a, ArrayList<ArrayList<String>> b, Hero c) {		
		int price = Integer.parseInt(b.get(a).get(1));
		int levelrequired = Integer.parseInt(b.get(a).get(2));
		int money = c.getMoney();
		int level = c.getLevel();
		if(money >=price && level>=levelrequired) {
			return true;
		}
		else {
			return false;
		}		
	}

	//check which inventory to go to after buying
	public static int whichInv(int a) {
		if(a<5) {return 0;}
		else if(a>=5 && a<11) {return 1;}
		else if(a>=11 && a<16) {return 2;}
		else if(a>=16 && a<20) {return 3;}
		else if(a>=20 && a<24) {return 4;}
		else {return 5;}
	}
	
	

}
