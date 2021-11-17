import java.util.ArrayList;

import Assignment3.purchaseHelper;



public class PurchaseHelper {
	
	public static void purchase(Hero hero, Market market) {
		
		System.out.println("####################################################");
		market.showItems();
		System.out.println("####################################################");
		System.out.print(hero.getName());
		System.out.println(", make your purchase or quit:"+ "("+ hero.getMoney()+" remain money"+")");
		while(true) {
			int choice = AskInput.askpurchase();
			if(choice == 0) {break;}
			int choiceindex = purchaseindex(choice);
			ArrayList<ArrayList<String>> division = purchaseDivision(choice,market);
			if(buyable(choiceindex,division,hero)) {
				int InventoryNo = whichInv(choice);
				ArrayList<String> itembought = division.get(choiceindex);
				int cost = Integer.parseInt(itembought.get(1));
				hero.spendMoney(cost);
				if(InventoryNo == 0) {
					hero.getBag().addArmor(itembought);
				}else if(InventoryNo == 1) {
					hero.getBag().addWeapon(itembought);
				}else if(InventoryNo == 2) {
					hero.getBag().addFire(itembought);
				}else if(InventoryNo == 3) {
					hero.getBag().addIce(itembought);
				}else if(InventoryNo == 4) {
					hero.getBag().addLightning(itembought);
				}else {
					hero.getBag().addPotion(itembought);
				}
				System.out.println("You have "+ hero.getMoney() + " left");				
			}
			else {
				System.out.println("You don't have enough money or you are not level enough to purchase this item, please make another selecion");
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
