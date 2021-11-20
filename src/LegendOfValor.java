import java.util.ArrayList;

public class LegendOfValor {
	// main program of LOV
	private LOVBoard gameboard;
	private Market market;
	private Hero[] team;
	private String move;
	private int round;
	private MonsterFactory monsterFactory;




	public LegendOfValor() {
		// initialize Legends of Valor
		System.out.println("Welcome to the World of Legend of Valor");
		this.gameboard = new LOVBoard();
		this.team = new Hero[3];
		this.round = 0;
		this.market = new Market();
		this.monsterFactory = new MonsterFactory();

		runGame();
	}

	private void runGame() {
		// initialize heroes team and run the game
		for(int i=0;i<3;i++) {
			this.team[i] = AskInput.askHero(i + 1);
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


	private void round() {

		//check movable
		if(this.round % 8 == 0) {
			for(int i = 0; i<3;i++) {
				int monsterLevel = getHighest(this.team);
				Monster current = monsterFactory.getMonster(getRandomNumber(1, 3), monsterLevel);
				this.gameboard.addCharacter(current);
//				System.out.println("==" + gameboard.getPos(current)[0] + gameboard.getPos(current)[1]);

			}
		}
		if (this.round % 3 == 0) {
			for (int i = 0; i < 3; i++) {
				if (team[i].getHp() == 0) {
					team[i].resetHp();
					gameboard.heroRevive(team[i]);
				}
			}
		}
		this.gameboard.print();
		System.out.println();// TODO: Zhu's Assignment map explanation
		for(int i = 0; i<3;i++) {
			if (team[i].getHp() == 0) {continue;}
			if (gameboard.checkEvent(team[i]) == 0) {
				//Ask enter shop or not on the map
				if (AskInput.inquireYN("You are at Nexus, would you like to purchase?")) {
					PurchaseHelper.purchase(team[i], market);
				}
			}
			else if (gameboard.checkEvent(team[i]) == 4) {
				if (AskInput.inquireYN("You are at Nexus, would you like to purchase?")) {
					PurchaseHelper.purchase(team[i], market);
				}
				BattleHelper.battle(team[i], gameboard.selectOpponent(team[i]), gameboard);
			}
			System.out.println(team[i].getName() + " please make your move");
			while(true) {
				this.move = AskInput.askMove();
				//end game
				if(this.move.equals("q")) {System.out.println("End Game");System.exit(0);}
				//open character information
				if(this.move.equals("i")){
				    // show info
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
					continue;
				}
				if(this.move.equals("t")) {
					// teleport
					int[] coord = AskInput.askCoordinates(0, 8);
					if(this.gameboard.teleport(this.team[i], coord)) {break;}
				}
				else if(this.gameboard.checkMovable(this.team[i],this.move)) {
					break;}
				else {System.out.println("Place cannot be reached, please make another move");
				}
			}

			//
			int incident = this.gameboard.checkEvent(this.team[i]);
			if(incident == 0) {
				if (AskInput.inquireYN("You are at Nexus, would you like to purchase?")) {
					PurchaseHelper.purchase(team[i], market);
				}
				this.gameboard.print();
			}
			else if (incident == 1) {
				this.gameboard.print();
				BattleHelper.battle(this.team[i], this.gameboard.selectOpponent(this.team[i]), this.gameboard);
				this.gameboard.print();
			}
			else if (incident == 2) {this.gameboard.print(); System.out.println("The hero team won!"); System.exit(0);}
			else if (incident == 3) {this.gameboard.print();}
			System.out.println("------------------------------------------");


		}

		for(Monster i: this.gameboard.getMonsters()) {
			// monster i moves
			this.gameboard.move(i);
//			System.out.println("==" + gameboard.getPos(i)[0] + gameboard.getPos(i)[1]);
			int incident = this.gameboard.checkEvent(i);
			this.gameboard.print();
			System.out.println("the monster team makes a move");
			System.out.println();
			if (incident == 1) {
				BattleHelper.battle(this.gameboard.selectOpponent(i), i, this.gameboard);
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

	private int getHighest(Hero[] heroes) {
		int max = 0;
		for (Hero h : heroes) {
			if (h.getLevel() > max) {
				max = h.getLevel();
			}
		}
		return max;
	}

}
