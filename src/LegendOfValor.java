import java.util.ArrayList;

public class LegendOfValor {
	
	private LOVBoard gameboard;
	private Market market;
	private Hero[] team;
	private String move;
	private int round;
	private ArrayList<Monster> monsters;
	
	
	

	public LegendOfValor() {
		
		System.out.println("Welcome to the World of Legend of Valor");
		this.gameboard = new LOVBoard();
		this.team = new Hero[3];
		this.round = 0; 
		
		runGame();
	}
	
	public void runGame() {
		
		for(int i=0;i<3;i++) {
			this.team[i] = AskInput.askHero();
		}
		
		this.gameboard.addPosition(this.team[0]);
		this.gameboard.addPosition(this.team[1]);
		this.gameboard.addPosition(this.team[2]);
		
		while(true) {
			this.round += 1;
			round();
		}
		
	}
	
	
	public void round() {
		
		//check movable
		if(this.round % 8 == 0) {
			for(int i = 0; i<3;i++) {
				// TODO: Monster
				Monster current = new Monster();
				this.monsters.add(current);
				this.gameboard.addPosition(current);
			}
		}
		this.gameboard.print();
		System.out.println();//Zhu's Assignment map explanation
		for(int i = 0; i<3;i++) {
			System.out.println(team[i].getName() + " please make your move");
			while(true) {
				this.move = AskInput.askMove();
				//end game
				if(this.move.equals("q")) {System.out.println("End Game");System.exit(0);}
				//open character information
				if(this.move.equals("i")){
					Action a = new ChangeEquipAction(this.team[i]);
					a.execute();
				}
				if(this.gameboard.checkMovable(this.team[i],this.move)) {break;}
				else {System.out.println("Place cannot be reached, please make another move");}
			}
			
			//
			int incident = this.gameboard.checkEvent(this.team[i]);
			if(incident == 0) {this.team[i] = PurchaseHelper.purchase(this.team[i], market);}
			else if (incident == 1) {
				BattleHelper.battle(this.team[i], this.gameboard.whichMonster(this.team[i]));
			}
			else {}
			
		}
		if(checkend()==true) {System.exit(0);}
		
		
		for(Monster i: this.monsters) {
			
			this.gameboard.move(i);
			int incident = this.gameboard.checkEvent(i);
			if(incident == 0) {BattleHelper.battle(i,this.gameboard.whichHero(i));}
			else{}

			
		}
		
		if(checkEnd()==true) {System.exit(0);}
		
		
		
		
		
		

		
		
	}
	
	public boolean checkEnd() {
		return false;
	}

}
