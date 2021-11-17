import java.util.ArrayList;
import java.util.HashMap;

public class LOVBoard {
    private Cell[][] cells;
    private HashMap<Hero, int[]> heros;
    private HashMap<Monster, int[]> monsters;

    // constructors
    public LOVBoard(int rows, int cols) {
        this.cells = new Cell[rows][cols];
    }

    public LOVBoard(int dim) {
        this(dim,dim);
    }

    public LOVBoard() {
        this(8);
    }

    // getters
    public Cell[][] getCells() {
        return cells;
    }

    public int[] getPos(Hero hero) {
        return this.heros.get(hero);
    }

    public int[] getPos(Monster monster) {
        return this.monsters.get(monster);
    }

    // setters
    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public void setCell(int row, int col, Cell cell) {
        this.cells[row-1][col-1] = cell;
    }

    // others
    public void print() {
        // TODO
    }

    public void addCharacter(Hero hero) {
        int num = this.heros.size();
        int[] pos = {7, num*3};
        this.heros.put(hero, pos);
    }

    public void addCharacter(Monster monster) {
        int num = this.monsters.size();
        int[] pos = {0, num*3};
        this.monsters.put(monster, pos);
    }

    public void move(Monster monster) {
        int pos[] = this.monsters.get(monster);
        int row = pos[0];
        int col = pos[1];
        int newpos[] = {row+1, col};
        this.monsters.replace(monster, newpos);
    }

    public boolean checkMovable(Hero hero, String direction) {
        int[] pos = this.heros.get(hero);
        int[] posChange = directionParser(direction);
        int row = pos[0] + posChange[0];
        int col = pos[1] + posChange[1];
        if (row < 0 || row > 7) return false;       // out of bound
        if (col < 0 || col > 7) return false;       // out of bound
        if (col == 2 || col == 5) return false;     // steps on inaccessible cells
        int[] newpos = {row, col};
        this.heros.replace(hero, newpos);
        return true;                                // return true and update hero pos
    }

    public int checkEvent(Hero hero) {
        int[] pos = this.heros.get(hero);
        if (pos[0] == 7) return 0;          // at nexus, trigger purchase event
        for (Monster monster : this.monsters.keySet()) {
            if (checkNeighbor(hero, monster)) return 1;     // hero monster neighboring, trigger battle event
        }
        return 2;                           // no event;
    }

    public int checkEvent(Monster monster) {
        for (Hero hero : this.heros.keySet()) {
            if (checkNeighbor(hero, monster)) return 1;     // hero monster neighboring, trigger battle event
        }
        return 2;                           // no event;
    }

    public Monster selectOpponent(Hero hero) {
        ArrayList<Monster> opponents = new ArrayList<Monster>();
        for (Monster monster : this.monsters.keySet()) {
            if (checkNeighbor(hero, monster)) opponents.add(monster);
        }
        return opponents.get(0);
    }

    public Hero selectOpponent(Monster monster) {
        ArrayList<Hero> opponents = new ArrayList<Hero>();
        for (Hero hero: this.heros.keySet()) {
            if (checkNeighbor(hero, monster)) opponents.add(hero);
        }
        return opponents.get(0);
    }

    public int[] directionParser(String direction) {
        int[] move = new int[2];
        switch (direction) {
            case "w": move = new int[]{-1,0}; break;
            case "a": move = new int[]{0,-1}; break;
            case "s": move = new int[]{1,0}; break;
            case "d": move = new int[]{0,1}; break;
        }
        return move;
    }

    public boolean checkNeighbor(Hero hero, Monster monster) {
        int[] posh = this.heros.get(hero);
        int rowh = posh[0];
        int colh = posh[1];
        int[] posm = this.monsters.get(monster);
        int rowm = posm[0];
        int colm = posm[1];
        boolean ver = (rowh - rowm == 1) || (rowh - rowm == -1);
        boolean hor = (colh - colm == 1) || (colh - colm == -1);
        if (ver && hor) return false;
        if (ver) return true;
        if (hor) return true;
        return false;
    }
}