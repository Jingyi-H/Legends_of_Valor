public class Test {
    public static void main(String[] args) {
        Hero h = AskInput.askHero(0);
        MonsterFactory fac = new MonsterFactory();
        Monster m = fac.getMonster(1, 3);
        LOVBoard board = new LOVBoard();
        board.addCharacter(h);
        Market market = new Market();
        BattleHelper.battle(h, m, board);



    }
}
