import java.util.ArrayList;

public class LegendOfValor {

	private LOVBoard gameboard;
	private Market market;
	private Hero[] team;
	private String move;
	private int round;
	private MonsterFactory monsterFactory;




	public LegendOfValor() {

		System.out.println("Welcome to the World of Legend of Valor");
		this.gameboard = new LOVBoard();
		this.team = new Hero[3];
		this.round = 0;
		this.market = new Market();

		runGame();
	}

	public void runGame() {

		for(int i=0;i<3;i++) {
			this.team[i] = AskInput.askHero();
			PurchaseHelper.purchase(this.team[i], this.market);
		}
		// initiate coordinates of hero groups
		this.gameboard.addCharacter(this.team[0]);
		this.gameboard.addCharacter(this.team[1]);
		this.gameboard.addCharacter(this.team[2]);
		while(true) {
			round();
			this.round += 1;
		}

	}


	public void round() {

		//check movable
		if(this.round % 8 == 0) {
			for(int i = 0; i<3;i++) {
				// TODO: Monster needs to be the same level as hero
				int monsterLevel = getHighest(this.team);
				Monster current = monsterFactory.getMonster(getRandomNumber(1, 3), monsterLevel);
				this.gameboard.addCharacter(current);
			}
		}
		this.gameboard.print();
		System.out.println();// TODO: Zhu's Assignment map explanation
		for(int i = 0; i<3;i++) {
			System.out.println(team[i].getName() + " please make your move");
			while(true) {
				this.move = AskInput.askMove();
				//end game
				if(this.move.equals("q")) {System.out.println("End Game");System.exit(0);}
				//open character information
				if(this.move.equals("i")){
				    // TODO: show info
					System.out.println(this.team[i].toString());
					System.out.println(this.team[i].getBag());
                    while(true) {
                        System.out.println("> Select your actions:");
                        System.out.println("1: Change Equipment");
                        System.out.println("2: Use potions");
                        System.out.println("Enter 0 to quit.");
                        int id = AskInput.askInt(0, 2);
                        if(id == 0) {
                            break;
                        }
                        else {
                            if (id == 1) {
                                Action a = new ChangeEquipAction(this.team[i]);
                                a.execute();
                            }
                            else if (id == 2) {
                                Action a = new HealAction(this.team[i]);
                                a.execute();
                            }
                        }
                    }
				}
				if(this.move.equals("t")) {
					// TODO: teleport
					int[] coord = AskInput.askCoordinates(0, 8);
					if(this.gameboard.teleport(this.team[i], coord)) {break;}
				}
				else if(this.gameboard.checkMovable(this.team[i],this.move)) {break;}
				else {System.out.println("Place cannot be reached, please make another move");}
			}

			//
			int incident = this.gameboard.checkEvent(this.team[i]);
			if(incident == 0) {PurchaseHelper.purchase(this.team[i], market);}
			else if (incident == 1) {
				BattleHelper.battle(this.team[i], this.gameboard.selectOpponent(this.team[i]), this.gameboard, this.market);
			}
			else if (incident == 2) {System.out.println("The hero team won!"); System.exit(0);}


		}

		for(Monster i: this.gameboard.getMonsters()) {
			// monster i moves
			this.gameboard.move(i);
			int incident = this.gameboard.checkEvent(i);
			if (incident == 1) {
				BattleHelper.battle(this.gameboard.selectOpponent(i), i, this.gameboard, this.market);
			}
			else if (incident == 2) {
				System.out.println("The monster team won!");
				System.exit(0);
			}
		}

	}

	private int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	public int getHighest(Hero[] heroes) {
		int max = 0;
		for (Hero h : heroes) {
			if (h.getLevel() > max) {
				max = h.getLevel();
			}
		}
		return max;
	}

	public boolean checkEnd() {
		return false;
	}



}
